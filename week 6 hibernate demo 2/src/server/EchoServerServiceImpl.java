/* File: EchoServerServiceImpl.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Feb 13, 2018
 * Description: Implementation of EchoServerService interface, also
 *              uses Hibernate to persist client information to database
 *              for every message received. Also sends the client all
 *              of it's previous messages in response to 'dumpit' String
 *              Updated: Modified to close down resources.
 */
package server;

import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;

import datatransfer.MessageLogEntry;

// ToDo: Change this to an enum for singleton
//       We can only have one SessionFactory per application, so use Singleton.
public class EchoServerServiceImpl extends RemoteServer implements EchoServerService{
	private static final long serialVersionUID = 1L;
	private int messagenum;
	private SessionFactory factory;
	private final StandardServiceRegistry registry = buildRegistry();

	public EchoServerServiceImpl(){
		try {
			// A SessionFactory is set up once for an application!
			MetadataImplementor meta = 
					(MetadataImplementor) new MetadataSources( registry )
					.addAnnotatedClass(MessageLogEntry.class)
					.buildMetadata();
			factory = meta.buildSessionFactory();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Problem starting hibernate, attempting to shutdown");
			shutdown();
		}
	}

	private StandardServiceRegistry buildRegistry() {
		StandardServiceRegistry registry = null;
		try {
			// A SessionFactory is set up once for an application!
			registry =  new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Problem starting hibernate, attempting to shutdown");
			shutdown();
		}
		return registry;
	}

	@Override
	public String processMessage(String hostName, String messageFromClient){
		// if this instance had shutdown() called, abort the method call.
		if(factory == null) {
			return "unable to save data"; 
		}

		// Each RMI client request can be on separate threads, this
		// synchronized block ensures that messagenum++ is completed
		// fully by one thread at a time, and all threads see the 
		// new value. We save the generated value for the current thead to use
		// later onwards in the code. (note the spelling messageNum vs messagenum)
		int messageNum;
		synchronized(this){
			messageNum = messagenum++;
		}

		System.out.println("From:" + hostName + ">"+messageFromClient);
		String clientHost = null;
		try {
			clientHost = getClientHost(); // getClientHost() inherited from RemoteServer
		}catch (ServerNotActiveException e){
			e.printStackTrace();
		}

		// save message from client into database with additional information
		// the factory handles thread-safety issues for us, provided there is only
		// one factory.
		// A local-scope session is thread-safe. (declared and created local).
		// Note: A module-level session accessed by more than one thread
		// is not thread-safe, keep it local where possible.

		// also, see this website for more information on the code sample used twice below
		// http://docs.jboss.org/hibernate/orm/5.2/javadocs/org/hibernate/Session.html
		MessageLogEntry message = new MessageLogEntry(); // used in two try-catches so local scope
		Session s = null;
		Transaction tx = null;
		try {
			s = factory.openSession();
			tx = s.beginTransaction();
			message.setMessage(messageFromClient);
			message.setClient(clientHost);
			message.setMesNumber(messageNum);
			message.setMesDate(Calendar.getInstance());
			s.save(message);
			tx.commit();
		}
		catch (Exception e) {
			if (tx!=null) tx.rollback();
			throw e;
		}
		finally {
			s.close(); // close resources
		}	

		// select records based on query
		if (messageFromClient.equals("dumpit")){
			s = null;
			tx = null;
			try {
				s = factory.openSession();
				tx = s.beginTransaction();
				// IMPORTANT: 'Message' is entity class name, not the database table name!!!!!
				@SuppressWarnings("unchecked")
				List<MessageLogEntry> result = s.createQuery( "from MessageLogEntry where client = :client")
						.setParameter("client",clientHost) // :client and client could be :tuna and tuna as long as the strings match
						.list();
				tx.commit();
				StringBuilder sb = new StringBuilder();
				sb.append(messageNum);
				sb.append(" Output (dumpit request)> \n");
				for ( MessageLogEntry mes : result ) {
					sb.append(mes.getMessage());
					sb.append("\n");
				}
				// return dumpit results to client
				return new String(sb.toString()); 
			}
			catch (Exception e) {
				if (tx!=null) tx.rollback();
				throw e;
			}
			finally {
				s.close(); // close resources
			}
			
		}else{
			// return the typical echoed string to client
			return new String(messageNum + " Output> " + message.getMessage());
		}
	}

	// shut down the factory, and the registry (StandardServiceRegistry)
	public void shutdown() {
		System.out.println("Closing factory");
		try {
			if(factory != null && factory.isClosed() == false) {
				factory.close();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Destroying registry");
		try {
			if(registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
