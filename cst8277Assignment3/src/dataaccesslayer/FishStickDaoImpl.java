/* File: FishStickDaoImpl.java
 * Author: Stanley Pieda
 * Date: Jan 2018
 * References:
 * Ram N. (2013). Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 * http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */
package dataaccesslayer;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import datatransfer.FishStick;

/**
 * Ensure that all classes and class members have Javadoc comments with your
 * name
 * 
 * @author Tao Wang, Min Luo
 * @version 1.0
 */
public enum FishStickDaoImpl implements FishStickDao {

	/** Only use one constant for Singleton Design Pattern */
	INSTANCE;
	/**Fishstick reference*/
	private FishStick fishstick;
	/**hibernate session factory for database connectivity*/
	private SessionFactory factory;
	/** registry for build the factory*/
	private final StandardServiceRegistry registry = buildRegistry();
    /**
     *constructor for the class 
     */
	private FishStickDaoImpl() {
		try {
			// A SessionFactory is set up once for an application!
			// code here to set up the registry
			MetadataImplementor meta = (MetadataImplementor) new MetadataSources(registry)
					.addAnnotatedClass(FishStick.class).buildMetadata();
			factory = meta.buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory,
			// but if we are here we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println(e.getMessage());
			System.out.println("Problem starting hibernate, attempting to shutdown");
			if (registry != null) {
				shutdown();
			}
			// throw e;
		}
	}
    
	/**
	 *Method for insert fish stick 
	 * @param FishStick fishStick
	 */
	@Override
	public void insertFishStick(FishStick fishStick) {
		// code here to use Hibernate to insert a record.
		if (factory == null)
			System.out.println("unable to save data....");
		this.fishstick = fishStick;
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			session.save(fishstick);
			transaction.commit();
			//System.out.println("From "+clientName+" >"+fishstick.toString());
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}finally {
			session.close(); // close resources
		}

	}
    
	/**
	 *Method for get a standard service registry
	 *@return StandardServiceRegistry 
	 * 
	 */
	private StandardServiceRegistry buildRegistry() {
		StandardServiceRegistry registry = null;
		try {
			// A SessionFactory is set up once for an application!
			registry = new StandardServiceRegistryBuilder().configure() // configures settings from hibernate.cfg.xml
					.build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Problem starting hibernate, attempting to shutdown");
			shutdown();
		}
		return registry;
	}

	/**
	 *Method to get fish stick by uuid 
	 * @param String uuid
	 * @return FishStick
	 */
	@SuppressWarnings("unchecked")
	@Override
	public FishStick findByUUID(String uuid) {
		// Code here to use Hibernate to look up a record based on UUID
		if (factory == null)
			System.out.println("unable to save data....");

		Session session = null;
		Transaction transaction = null;
		String hql = " from FishStick  where UUID = :uuid";
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			List<FishStick> list = session.createQuery(hql).setParameter("uuid",uuid).list();
			for(FishStick fish :  list)
				fishstick = fish;
			transaction.commit();
		}catch(Exception e) {
			if (transaction != null)
				transaction.rollback();
			throw e;
		}finally {
		
			session.close(); // close resources
		}

		return fishstick;

	}
   /**
    *Method for closing the hibernate resources
    * 
    * 
    */
	@Override
	public void shutdown() {
		// code here to close the factory, and to destroy the registry
		System.out.println("Closing factory");
		try {
			if (factory != null && factory.isClosed() == false) {
				factory.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Destroying registry");
		try {
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
