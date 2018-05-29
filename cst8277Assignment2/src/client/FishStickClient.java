package client;
/* File: FishStickClient.java
 * Author: Stanley Pieda, based on course example by Todd Kelley
 * Modified Date: Jan 2018
 * Description: Networking client that uses simple protocol to send and receive transfer objects.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.UUID;

import datatransfer.FishStick;
import datatransfer.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.lang.System.out;

/**
 * class for implementing the client side socket, allow users input and received information for server.
 * @author Tao Wang 
 * @author Min Luo
 * Date: Feb 2018
 */
public class FishStickClient {

	/**client side socket*/
	private Socket connection;
	/**output stream from socket*/
	private ObjectOutputStream output;
	/**input stream from socket*/
	private ObjectInputStream input;
	/**message object*/
	private Message message ;
	/**FishStick reference*/
	private FishStick fishStick;
	/**command to and from server*/
	private String command;
	/**server name*/
	private String serverName;
	/**port number */
	private int portNum;
	/**user input buffer*/
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/**verify if insert another Message*/
	private boolean again = true;


	/**Method for entry point for client side
	 *@param String[] args 
	 */
	public static void main(String[] args) {
		//print current time and authors
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
		out.printf("FishStickClient by: Tao Wang & Min Luo run on %s%n",dateTime.format(format));

		//verify user's params
		switch (args.length){
		case 2:
			(new FishStickClient(args[1],Integer.parseInt(args[2]))).runClient();
			break;
		case 1:
			(new FishStickClient("localhost",Integer.parseInt(args[1]))).runClient();
			break;
		default:
			(new FishStickClient("localhost",8081)).runClient();
		}

	}

	/**
	 * Constructor of the client
	 * @param String serverName,
	 * @param int portNum
	 * */
	public FishStickClient(String serverName, int portNum){
		this.serverName = serverName;
		this.portNum = portNum;
	}

	/**
	 * Method for running the client program
	 * */
	public void runClient(){

		try {
			InetAddress myHost = Inet4Address.getLocalHost();
			String myHostName = myHost.getHostName();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		try {
			//connect to server
			connection = new Socket(InetAddress.getByName(serverName), portNum);
			output = new ObjectOutputStream (connection.getOutputStream());
			input = new ObjectInputStream( connection.getInputStream());
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
				fishStick = new FishStick();
				while(true) {
					try {
						fishStick.setRecordNumber(Integer.parseInt(record));
						break;
					}
					catch(NumberFormatException e) {
						out.println("record number must be a number, enter again: ");
						record = br.readLine();
					}
				}
				fishStick.setOmega(omega);
				fishStick.setLambda(lambda);
				fishStick.setUUID(uuid);
				//out.println(fishStick.toString());
				command="add";
				//Send message to server
				message=new Message(command, fishStick);
				output.writeObject(message);
				output.flush();

				//message from server
				message = (Message) input.readObject();

				//parsing the message from server
				if(message !=null) {
					command = message.getCommand();
					fishStick=message.getFishStick();
					switch(command) {
					case "command_work": out.println("command: "+command+", sucess returned FishStick: "+message.getFishStick().toString());
					break;
					case "command_failed": out.println("server failed to perform request operations\nshutting down server connection");
					System.exit(0);
					break;
					case "disconnect": out.println("server failed to perform request operations\nshutting down server connection");
					System.exit(0);
					break;
					}

					//prompt user to insert another FishStick or not
					out.println("Do you want insert another FishStick? (y or n): \n");
					String yesORno=br.readLine();
					if(yesORno.equalsIgnoreCase("y") || yesORno.equalsIgnoreCase("yes")) {
						again =true;
					}else {
						//not insert another FishStick
						again=false;
						command="disconnect";
						message= new Message(command);
						output.writeObject(message);
						output.flush();
						out.println("\nshutting down server connection");
					}
				}
			} while (again);
		} catch (IOException exception) {
			//if server disconnect in accident.
			System.out.println("disconnect from server...");

		}catch (ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
		finally{
			//close all resources of system.
			try{if(input != null){input.close();}}catch(IOException ex){
				System.out.println(ex.getMessage());}
			try{if(output != null){output.flush(); output.close();}}catch(IOException ex){
				System.out.println(ex.getMessage());}
			try{if(connection != null){connection.close();}}catch(IOException ex){
				System.out.println(ex.getMessage());}
		}
	}

}
