package tcpclientserverDemo;

import java.net.*;
import java.io.*;
import static java.lang.System.*;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(10004);
         
		Socket s = ss.accept();
		
		InputStream in =s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		while(len!=-1)
		out.println(new String(buf,0,buf.length));
		
		OutputStream op = s.getOutputStream();
		
		op.write("hello, this is server".getBytes());
		
		s.close();
		ss.close();
	}

}
