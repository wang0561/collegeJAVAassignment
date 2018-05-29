/* File: EchoClient.java
 * Author: Todd Kelley
 * Modified By: Stanley Pieda
 * Modified Date: Sept, 2017
 * Description: Simple echo client.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author Todd
 */
public class EchoClient {

	private Socket connection;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverName ;
	private int portNum ;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		switch (args.length){
		case 2:
			(new EchoClient(args[1],Integer.parseInt(args[2]))).runClient();
			break;
		case 1:
			(new EchoClient("localhost",Integer.parseInt(args[1]))).runClient();
			break;
		default:
			(new EchoClient("localhost",11111)).runClient();
		}

	}
	public EchoClient(String serverName, int portNum){
		this.serverName = serverName;
		this.portNum = portNum;
	}
	public void runClient(){
		String myHostName = null;
		try {
			InetAddress myHost = Inet4Address.getLocalHost();
			myHostName = myHost.getHostName();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		try {
			connection = new Socket(InetAddress.getByName(serverName), portNum);
			output = new ObjectOutputStream (connection.getOutputStream());
			input = new ObjectInputStream( connection.getInputStream());               
			do {
				System.out.print("Input> ");
				message = br.readLine();
				if (message == null || message.isEmpty()) {
					message = null; // do not append host name, send null to server to start disconnect.
				}
				else {
					message = myHostName + ": " + message;
				}
				output.writeObject(message);
				output.flush();
				message = (String) input.readObject();
				System.out.println(message);
			} while (message != null);
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		} 
		finally{
			try{if(input != null){input.close();}}catch(IOException ex){
				System.out.println(ex.getMessage());}
			try{if(output != null){output.flush(); output.close();}}catch(IOException ex){
				System.out.println(ex.getMessage());}
			try{if(connection != null){connection.close();}}catch(IOException ex){
				System.out.println(ex.getMessage());}
		}
	}
}
