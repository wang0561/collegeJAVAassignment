package tcpclientserverDemo;
import java.net.*;
import java.io.*;
import static java.lang.System.*;

public class TCPClient {

	public static void main(String[] args) {
		
		try {
			Socket s = new Socket("192.168.2.11",10004);
			OutputStream op = s.getOutputStream();
			
			op.write("hello, server, this is from client..".getBytes());
			
			InputStream in = s.getInputStream();
			
			byte[] buf = new byte[1024];
			
			int len = in.read(buf);
			
			while(len!=-1)
			System.out.println(new String(buf,0,buf.length));
			
			s.close();
		} catch (UnknownHostException e) {
		 err.println("Unknown host exception....Connect failed");
		} catch (IOException e) {
			err.println("io exception....connect failed");
		}
		

	}

}
