/* Description:
 * This file runs the server, by loading the rmi registry
 * and exporting a remote object to it, at which point
 * the registry listens for clients.
 */
package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import remoteinterface.EchoService;

public class EchoServer {
	public static void main(String[] args) {
		int portNum = 1099;
		if(args.length > 0){
			portNum = Integer.parseInt(args[0]);
		}
		try {
			// instantiate the Remote object
			EchoService es = new EchoServiceImpl();

			// start the rmi registry
			java.rmi.registry.Registry registry = LocateRegistry.createRegistry(portNum);
			LocateRegistry.getRegistry();

			// report status to user
			System.out.println( "Registry created" );

			// export Remote object to registry for use by client
			UnicastRemoteObject.exportObject(es,portNum);

			// report status to user
			System.out.println( "Exported" );

			// bind the Remote object to a name, so that
			// it is accessible to clients
			Naming.rebind("//localhost:" + portNum + "/EchoService", es);

			// updated to release resources
			System.out.println("Use the Enter key to close server");
			String data = (new java.util.Scanner(System.in)).nextLine();

			System.out.println("un-exporting remote object");
			UnicastRemoteObject.unexportObject(es, true); // remove remote object forcefully

			// may not be needed, port 1099 is free on JVM exit regardless of unexporting registry
			System.out.println("Shutting down registry"); 
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}
}
