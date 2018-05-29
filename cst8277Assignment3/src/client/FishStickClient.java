/* File FishStickClient.java
 * Author: Stanley Pieda
 * Created On: Jan 2018
 * Description: Client used to insert FishStick records on server.
 */
package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import datatransfer.FishStick;
import remoteinterface.FishStickService;
import server.FishStickServiceImpl;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.rmi.NotBoundException;

/**
 * class for implementing the client side which invoke the fishstickservie' methods.
 * @author Tao Wang, Min Luo
 * @version 1.0
 */
public class FishStickClient {

	/**
	 * @param String[] args
	 * Main method for client side
	 */
	public static void main(String[] args) {
		//print current time and authors
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
		out.printf("FishStickClient by: Tao Wang & Min Luo run on %s%n",dateTime.format(format));
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
			System.out.println("usage: EchoClient [hostname [portnum]]");
			break;
		}
		//test the connection to server
		try {
			InetAddress myHost = Inet4Address.getLocalHost();
			myHostName = myHost.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			FishStick fishstick = null;
			System.out.println("Attempting to connect to rmi://"+serverName+":"+port+"/FishStickService");
			FishStickService service =  (FishStickService)Naming.lookup("rmi://"+serverName+":"+port+"/FishStickService");
			String record=null;
			String omega=null;
			String lambda=null;
			String uuid=null;
			do {
				//prompt client input the data of a new FishStick
				out.println("Enter data for new FishStick:");
				out.println("please enter record number:");
				record=br.readLine();
				out.println("please enter omega: ");
				omega=br.readLine();
				out.println("please enter lambda: ");
				lambda = br.readLine();
				uuid=UUID.randomUUID().toString();

				//create a new FishStick object
				fishstick = new FishStick();
				while(true) {
					try {
						fishstick.setRecordNumber(Integer.parseInt(record));
						break;
					}
					catch(NumberFormatException e) {
						out.println("record number must be a number, enter again: ");
						record = br.readLine();
					}
				}
				fishstick.setOmega(omega);
				fishstick.setLambda(lambda);
				fishstick.setUUID(uuid);
				out.println("FishStick input: "+fishstick.toString());
				service.insert(fishstick);

				out.println("FishStick find by UUID : "+service.findByUUID(uuid));
				out.println("Do you want to input another fishstick? (Y/N)");

				//insert another fishstick
				String yesORno=br.readLine();
				if(yesORno.equalsIgnoreCase("y") || yesORno.equalsIgnoreCase("yes")) {
					fishstick.setLastFishStick(false);
				}else {
					//not insert another FishStick
					fishstick.setLastFishStick(true);
					//service.shutDownDao();
				}
			} while (!fishstick.isLastFishStick()); 
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
