/* File: EchoServer.java
 * Author: Todd Kelley
 * Modified By: Stanley Pieda
 * Modified Date: Sept, 2017
 * Description: Simple echo server.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
/**
 *
 * @author Todd
 */
public class EchoServer {

private Socket connection;
private ServerSocket server;
private ObjectOutputStream output;
private ObjectInputStream input;
private String message = "";
private int messagenum;
private int portNum = 8081;
   
    public static void main(String[] args) {
        if(args.length > 0){
            (new EchoServer(Integer.parseInt(args[1]))).runServer();
        }else{
            (new EchoServer(8081)).runServer();
        }
    }
    public EchoServer(int portNum){
        this.portNum = portNum;
    }
    public void runServer(){
        try {
            server = new ServerSocket(portNum);
            connection = server.accept();
            output = new ObjectOutputStream (connection.getOutputStream());
            input = new ObjectInputStream( connection.getInputStream());         
            do {
                message = (String) input.readObject();
                if(message == null || message.isEmpty()) {
					message = null;
				}
				else {
					message = messagenum++ + " Output> " + message;
				}
				output.writeObject(message);
				output.flush();
			} while (message != null);
//            input.close();
//            output.close();
//            connection.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }catch (ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
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
}
