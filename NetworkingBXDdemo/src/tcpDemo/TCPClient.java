package tcpDemo;
import java.net.*;
import static java.lang.System.*;
import java.io.*;
/*send a String to server*/
public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		//create client-side client service, stream opened.
		try {
			Socket socket = new Socket("192.168.2.11",12000);
			//get the socket stream
			OutputStream output = socket.getOutputStream();
			output.write("This is TCP client".getBytes());
			
			//close socket, don't need close the stream
			socket.close();
		} catch (UnknownHostException e) {
			out.println("unknow host");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			out.println("IO exception");
		}
		
	
	}

}
