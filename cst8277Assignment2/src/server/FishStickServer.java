package server;
import static java.lang.System.out;

/* File: FishStickServer.java
 * Author: Stanley Pieda, based on course materials by Todd Kelley
 * Modified Date:Jan 2018
 * Description: Networking server that uses simple protocol to send and receive transfer objects.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import datatransfer.FishStick;
import datatransfer.Message;
import dataaccesslayer.FishStickDaoImpl;

/**
 * program for implementing a server side to accept multiple clients connection and receive messages.
 * @author Tao Wang
 * @author Min Luo
 * Date: Feb 2018
 */
public class FishStickServer {
	/**server socket object*/
	private ServerSocket server;
	/**client socket object*/
	private Socket connection;
	/**port number*/
	private int portNum ;
	/**thread pool object for handling mutiple clients*/	
	public static ExecutorService threadExecutor = Executors.newCachedThreadPool();
	/**client number*/
	private static int client_n;
	/**
	 *Main method for the entry point of the program 
	 *@param String args
	 */
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm a");
		out.printf("FishStickServer by: Tao Wang & Min Luo run on %s%n",dateTime.format(format));
		if(args.length > 0){
			(new FishStickServer(Integer.parseInt(args[0]))).runServer();
		}else{
			(new FishStickServer(8081)).runServer();
		}
	}

	/**
	 * constructor for server
	 * @param int portNum
	 */
	public FishStickServer(int portNum){
		this.portNum = portNum;
	}

	/**
	 *Method to accept a client socket and read the message from the client.
	 *@param Socket connection 
	 */
	public void talkToClient(final Socket connection){
		threadExecutor.execute( new Runnable () {

			/**FishStick reference*/
			private FishStick fishStick;
			/**Message reference*/
			private Message message;
			/**command from client*/
			private String command;
			/**UUID of the FishStick from client*/
			private String UUID;
			/**outputStream object*/
			private ObjectOutputStream output = null;
			/**inputStream object*/
			private ObjectInputStream input = null;

			/**run Method for the each thread of client*/
			public void run(){	

				client_n++;
				Thread.currentThread().setName("client"+client_n);
				//waiting for client input
				System.out.println("Got a connection from client"+client_n);
				try {
					//client information and initialize the outputstream, inputstream base on socket.
					SocketAddress remoteAddress = connection.getRemoteSocketAddress();
					String remote = remoteAddress.toString();
					output = new ObjectOutputStream (connection.getOutputStream());
					input = new ObjectInputStream( connection.getInputStream());  

					do {
						//get message from client
						message = (Message) input.readObject();
						//get command from client
						command = message.getCommand();

						if( command.equalsIgnoreCase("add")) {
							//get the fishStick from client and write it into database.
							fishStick = message.getFishStick();
							UUID=fishStick.getUUID();
							System.out.println("From:" + remote + " command: "+command+" FishStick"+message.getFishStick().toString());
							FishStickDaoImpl dao = new FishStickDaoImpl();
							dao.insertFishStick(fishStick);

							// verify if the fishStick inserted successfully.
							fishStick = dao.findByUUID(UUID);
							if(fishStick !=null) {
								//success to insert the fishStick and tell the client it works.
								command = "command_work";
								message=new Message(command,fishStick);
								output.writeObject(message);
								output.flush();
							}
						}else if(command.equalsIgnoreCase("disconnect")) {
							//if the command is disconnect, end current client thread.
							fishStick=message.getFishStick();
							out.println("From:" + remote + " command: "+command+" FishStick: "+fishStick);
							message=null;
						}

					} while (message != null);
					System.out.println(remote + " disconnected via request");
				} catch (IOException exception) {
					//if socket closed in an accident

					System.out.println( connection.getRemoteSocketAddress().toString()+" disconnected via request");
					message = new Message("disconnect");
					try {
						if(output!=null) {
							output.writeObject(message);
							output.flush();}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println(client_n+" disconnect from server caused by exception");
					}

				}catch (ClassNotFoundException exception) {
					System.out.println(exception.getMessage());
					exception.printStackTrace();
				} 
				catch (SQLException e) {
					//if the database connection is closed
					System.out.println(e.getMessage());
					message = new Message("command_failed",null);
					out.println(message.getFishStick());
					try {
						output.writeObject(message);
						output.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 

				finally {
					//close all resources of the system
					try{if(input != null){input.close();}}catch(IOException ex){
						System.out.println(ex.getMessage());}
					try{if(output != null){output.flush(); output.close();}}catch(IOException ex){
						System.out.println(ex.getMessage());}
					try{if(connection != null){connection.close();}}catch(IOException ex){
						System.out.println(ex.getMessage());}
				}
			}
		});
	}

	/**
	 *Method for run the server 
	 * 
	 */
	public void runServer(){
		try {
			server = new ServerSocket(portNum);
		}catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("Listenting for connections...");
		while(true){
			try{
				connection = server.accept();
				talkToClient(connection);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	
	}

}
