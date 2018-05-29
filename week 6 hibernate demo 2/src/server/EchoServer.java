/* File: EchoServer.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Feb 13, 2018
 * Description: Starts the RMI Registry and loads the EchoServerService for use.
 *              Updated: When server admin uses enter key resources will be cleaned
 *                       up before the server shuts down.
 */
package server;

import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/** EXERCISE FOR READER: read the code, understand it, and insert comments 
 *
 * @author Todd
 */
public class EchoServer{

	public static void main(String[] args) {
		EchoServerServiceImpl es = null;
		int portNum = 8082;
		if(args.length > 0){
			portNum = Integer.parseInt(args[0]);
		}
		// set the hostname property to the public IP of the server if the server has several IP addresses
		// System.setProperty("java.rmi.server.hostname", "10.70.176.85");
		try {
			es = new EchoServerServiceImpl(); // no interface, need to use shutdown()
			Registry registry = LocateRegistry.createRegistry(portNum);
			System.out.println( "Registry created" );
			UnicastRemoteObject.exportObject(es,0);
			System.out.println( "Exported" );
			Naming.rebind("//localhost:" + portNum + "/EchoService", es);

			// pause main thread until server admin presses a key.
			System.out.println("Press enter key to shutdown EchoServer server");
			new java.util.Scanner(System.in).nextLine(); // blocks main thread until enter key
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
			e.printStackTrace();
		}
		finally {
			if(es != null) {
				es.shutdown();
			} // close down Hibernate resources
		}
		System.out.println("un-exporting remote object");
		try {
			UnicastRemoteObject.unexportObject(es, true); // remove remote object forcefully
		}
		catch(NoSuchObjectException e) {
			System.out.println("Trouble: " + e);
		}
		// next lines not needed, port 1099 is free on JVM exit regardless of unexporting registry
		// System.out.println("Shutting down registry"); 
		// UnicastRemoteObject.unexportObject(registry, true);
	}
}
