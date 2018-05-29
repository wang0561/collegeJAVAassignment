/* Description:
 * This file runs the server, by loading the rmi registry
 * and exporting a remote object to it, at which point
 * the registry listens for clients.
 */
package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import remoteinterface.Calculator;

public class CalculatorServer {

	public void runServer(){
		try {
			// create remote object
			Calculator c = new CalculatorImpl();
			
			// start and run the rmi registry on port 1099
			java.rmi.registry.Registry registry = LocateRegistry.createRegistry(1099);
			
			// report status to user
			System.out.println( "Registry created" );
			
			// export Calculator instance to rmi registry
			// (not needed if CalculatorImpl extended UnicastRemoteObject)
			UnicastRemoteObject.exportObject(c,1099);
			
			// report status to user
			System.out.println( "Exported" );
			
			// make the Calculator instance available with name "CalculatorService"
			Naming.rebind("CalculatorService", c);
			
			// updated to release resources
			System.out.println("Use the Enter key to close server");
			String data = (new java.util.Scanner(System.in)).nextLine();
			
			System.out.println("un-exporting remote object");
			UnicastRemoteObject.unexportObject(c, true); // remove remote object forcefully
			
			// may not be needed, port 1099 is free on JVM exit regardless of unexporting registry
			System.out.println("Shutting down registry"); 
			UnicastRemoteObject.unexportObject(registry, true);
			
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	// entry point for the application
	public static void main(String args[]) {
		new CalculatorServer().runServer();
	}
}
