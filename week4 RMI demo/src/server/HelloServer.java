/* Description:
 * This file runs the server, by loading the rmi registry
 * and exporting a remote object to it, at which point
 * the registry listens for clients.
 */
package server;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import remoteinterface.Hello;

public class HelloServer {
	/**
	 * Server program for the "Hello, world!" example.
	 * @param argv The command line arguments which are ignored.
	 */
	public static void main (String[] args) {
		try {
			// locate and start the registry on port 1099
			// (default port for rmi is 1099)
			// code was updated to keep reference to registry for resource release
			java.rmi.registry.Registry registry = LocateRegistry.createRegistry(1099);
			
			// create the remote object
			Hello hello = new HelloImpl("Hello world!");
			
			// Because HelloImpl inherits UnicastRemoteObject a
			// line like this is not needed (will be seen in future demos):
			// UnicastRemoteObject.exportObject(hello,1099);
			
			// bind a new HelloImpl in registry to identifier "Hello"
			Naming.rebind ("Hello", hello); // "name", remoteObject
			
			// NOTE: The name "Hello" does not need to match
			// the Interface or class name. If Naming.rebind("TunaFish", hello)
			// was used the client would also need to use "TunaFish".
			
			// This line will be hit and main will exit, the rmi registry 
			// will keep running waiting for clients to connect.
			System.out.println ("Hello Server is ready.");
			
			// Updated to release resources
			System.out.println("Use the Enter key to close server");
			String data = (new java.util.Scanner(System.in)).nextLine();
			
			System.out.println("un-exporting remote object");
			UnicastRemoteObject.unexportObject(hello, true); // remove remote object forcefully
			
			// may not be needed, port 1099 is free on JVM exit regardless of unexporting registry
			System.out.println("Shutting down registry"); 
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (Exception e) {
			System.out.println ("Hello Server failed: " + e);
		}
	}
}
