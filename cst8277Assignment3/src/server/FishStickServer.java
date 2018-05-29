/* File FishStickServer.java
 * Author: Todd Kelley
 * Modified By: Stanley Pieda
 * Modifed On: Jan 2018
 * Description: RMI Server startup.
 */
package server;

import static java.lang.System.out;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*
 * Referenced works on shutting down RMI within the application:
 * https://coderanch.com/t/210114/java/Shut-RMI-Registry
 * https://community.oracle.com/thread/1180058?start=0&tstart=0
 */

/**
 * @author Tao Wang & Min Luo
 * class for handling server side
 * 
 * */

public class FishStickServer {
	
	/**
	 * @param String[] args
	 * Main method for server side
	 * */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			int portNum = 1099;
			if(args.length > 0){
				portNum = Integer.parseInt(args[0]);
			}

			// ToDo: Create the remote service
			FishStickServiceImpl fishStickServiceImpl = new FishStickServiceImpl(); // replace null
			// ToDo: create RMI registry, saving reference to it
			Registry registry = LocateRegistry.createRegistry(portNum);
			// message to users (this is done already on, next line)
			System.out.println( "Registry created" );

			// ToDo: export the remote service
			UnicastRemoteObject.exportObject(fishStickServiceImpl,0);
			// ToDo: rebind using portNum with service name /FishStickService
			// message to users (this is done already on next line)
			System.out.println( "Exported" );
			Naming.rebind("rmi://localhost:" + portNum + "/FishStickService", fishStickServiceImpl);
			//print current time and authors
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
			out.printf("FishStickServer by: Tao Wang & Min Luo run on %s%n",dateTime.format(format));
			System.out.println("Press any key to shutdown remote object and end program");
			
			input.nextLine(); // pause, let server-side admin close down connections

			fishStickServiceImpl.shutDownDao(); // close down Hibernate resources

			System.out.println("un-exporting remote object");
			UnicastRemoteObject.unexportObject(fishStickServiceImpl, true); // remove remote object

			//next lines not needed in this case, port 1099 is free on JVM exit according to TCPView
			//see: https://docs.microsoft.com/en-us/sysinternals/downloads/tcpview
			//System.out.println("Shutting down registry"); 
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
			e.printStackTrace();
		}finally {
			input.close();
		}
	}
}
