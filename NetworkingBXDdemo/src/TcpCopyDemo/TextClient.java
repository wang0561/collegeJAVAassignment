package TcpCopyDemo;
import java.net.*;
import java.io.*;

public class TextClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
      
		Socket s = new Socket("192.168.2.11",10006);
		
		BufferedReader sourceFile = new BufferedReader(new FileReader("toserver.txt"));
	
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		
		while((line=sourceFile.readLine())!=null) {
			
			out.println(line);
		}
		
		s.shutdownOutput();
	
	    BufferedReader fromServer = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    
	    String echofromServer = fromServer.readLine();
	    
	    System.out.println(echofromServer);
	    
	    sourceFile.close();
	    
	    s.close();
	}

}
