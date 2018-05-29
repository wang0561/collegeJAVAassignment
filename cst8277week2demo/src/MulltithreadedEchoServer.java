/* File: MulltithreadedEchoServer.java
 * Author: Todd Kelley
 * Modified By: Stanley Pieda
 * Modified Date: Sept, 2017
 * Description: Multithreaded Echo Server.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MulltithreadedEchoServer {

	private ServerSocket server;
	private Socket connection;
	private int messagenum;
	private int portNum ;
	public static ExecutorService threadExecutor = Executors.newCachedThreadPool();

	public static void main(String[] args) {
		if(args.length > 0){
			(new MulltithreadedEchoServer(Integer.parseInt(args[0]))).runServer();
		}else{
			(new MulltithreadedEchoServer(11111)).runServer();
		}
	}
	public MulltithreadedEchoServer(int portNum){
		this.portNum = portNum;
	}
	public void talkToClient(final Socket connection){
		threadExecutor.execute( new Runnable () {
			public void run(){	
				ObjectOutputStream output = null;
				ObjectInputStream input = null;
				String message = "";
				System.out.println("Got a connection");
				try {
					SocketAddress remoteAddress = connection.getRemoteSocketAddress();
					String remote = remoteAddress.toString();
					output = new ObjectOutputStream (connection.getOutputStream());
					input = new ObjectInputStream( connection.getInputStream());                 
					do {
						message = (String) input.readObject();
						System.out.println("From:" + remote + ">"+message);
						if(message == null || message.isEmpty()) {
							message = null;
						}
						else {
							message = messagenum++ + " Output> " + message;
						}
						output.writeObject(message);
						output.flush();
					} while (message != null);
					System.out.println(remote + " disconnected via request");
		        } catch (IOException exception) {
		            System.err.println(exception.getMessage());
		            exception.printStackTrace();
		        }catch (ClassNotFoundException exception) {
		            System.out.println(exception.getMessage());
		            exception.printStackTrace();
		        } 
				finally {
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
