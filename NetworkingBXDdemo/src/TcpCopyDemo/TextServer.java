package TcpCopyDemo;
import java.net.*;
import java.io.*;


public class TextServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		try {
			ServerSocket ss = new ServerSocket(10006);
			
			Socket s = ss.accept();
					
			BufferedReader fileFromClient =
					new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);
			
			String line = null;
			
			while((line=fileFromClient.readLine())!=null)
			       out.println(line);
			
			PrintWriter netWriter = new PrintWriter(s.getOutputStream(),true);
			
			netWriter.println("upload success....");
			
			out.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("failed to build server port listening..");
		}
		
		
		
	}

}
