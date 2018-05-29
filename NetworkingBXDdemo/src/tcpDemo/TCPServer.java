package tcpDemo;
import java.net.*;
import java.io.*;
import static java.lang.System.*;
public class TCPServer {

	public static void main(String[] args) {
		
   
	
	  try {
		  //create server and listening a port
		ServerSocket ss = new ServerSocket(12000);
		
		//get client-side socket connection
		Socket socket = ss.accept();
		
		//get socket stream object
		InputStream in = socket.getInputStream();
		
		byte [] buf = new byte[1024];
		int len=in.read(buf);
		out.println("connected successful....");
		out.println(new String(buf,0,buf.length));
		
		//close the client connection
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		out.println("CONNECTING FAILED....");
	}
		
	}

}
