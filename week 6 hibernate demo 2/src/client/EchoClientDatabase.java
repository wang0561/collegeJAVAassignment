/* File: EchoClientDatabase.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Echoclient that communicates to server using RMI and
 *              serialized Strings.
 */
package client;

import java.rmi.Naming;
import java.rmi.RemoteException;

import server.EchoServerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.rmi.NotBoundException;

public class EchoClientDatabase {

	public static void main(String[] args) {
		int port = 8082;
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
			System.out.println("usage: EchoClient [hostname [portnum]]");
			break;
		}
		try {
			InetAddress myHost = Inet4Address.getLocalHost();
			myHostName = myHost.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			String message;
			System.out.println("Attempting to connect to rmi://"+serverName+":"+port+"/EchoService");
			EchoServerService es = (EchoServerService) 
					Naming.lookup("rmi://"+serverName+":"+port+"/EchoService");
			
			do {
				System.out.print("Input> ");
				try {
					message = br.readLine();
					if (message != null){
						System.out.println(es.processMessage(myHostName, message));
					}
				}catch(IOException e){
					System.out.println(e);
					message = null;
				}
			} while ( ! (message == null || message.isEmpty()) );
			System.out.println("Client shutting down");
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
			System.out.println(e.getClass().getName());
			System.out.println(e);
		}
	}
}
