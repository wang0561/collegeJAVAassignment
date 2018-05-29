/* Description
 * This client attempts to obtain a reference or stub to the
 * remote object on server's rmi registry with name "Hello"
 */
package client;

import java.rmi.Naming;
import remoteinterface.Hello; // Remote Interface

class HelloClient {
	/**
	 * Client program for the "Hello, world!" example.
	 * @param argv The command line arguments which are ignored.
	 */
	public static void main (String[] argv) {
		try {
			// obtain reference to remote object on localhost with name "Hello"
			Hello hello = (Hello) Naming.lookup ("//localhost/Hello");
			
			// call method say on the remote object
			System.out.println (hello.say());
		} catch (Exception e) {
			System.out.println ("HelloClient exception: " + e);
		}
	}

}