/* Description
 * This client attempts to obtain a reference or stub to the
 * remote object on server's rmi registry with name "EchoService"
 */
package client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import remoteinterface.EchoService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.rmi.NotBoundException;

public class EchoClientRMI {

	public static void main(String[] args) {
		int port = 1099;
		String serverName = new String("localhost");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String myHostName = "localhost";
		
		switch (args.length) {
		case 0:
			break;
		case 1: 
			serverName = args[0];
			break;
		case 2:
			serverName = args[0];
			port = Integer.parseInt(args[1]);
			break;
		default:
			System.out.println("usage: EchoClient [hostname] [portnum]");
			break;
		}
		try {
			InetAddress myHost = Inet4Address.getLocalHost();
			myHostName = myHost.getHostName();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}

		try {
			String message;
			System.out.println("Attempting to connect to rmi://" +
			    serverName + ":" + port + "/EchoService");
			EchoService es = (EchoService) 
					Naming.lookup("rmi://" +
			        serverName + ":" + port + "/EchoService");
			do {
				System.out.print("Input> ");
					message = br.readLine();
					if ( ! (message == null || message.isEmpty()) ) {
						message = es.processMessage(myHostName + ": " + message);
						System.out.println(message);
					}
			} while ( ! (message == null || message.isEmpty()) );
		}
		catch (MalformedURLException e) {
			System.out.println();
			System.out.println("MalformedURLException");
			System.out.println(e);
		}
		catch (RemoteException e) {
			System.out.println();
			System.out.println("RemoteException");
			System.out.println(e);
		}
		catch (NotBoundException e) {
			System.out.println();
			System.out.println("NotBoundException");
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println();
			System.out.println("Exception");
			System.out.println(e);
		}
	}
}
