package tcptextexchangedemo;
import java.net.*;
import java.io.*;
/*
 * client send a text to server and get the capital case string back
 * */
public class TcpServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(10005);
        
		Socket s = ss.accept();
		
		BufferedReader netReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		// we could use PrintWriter instead of BufferedWriter. because printWriter dont need end flag

		BufferedWriter netWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

		String line = null;
		
		while((line=netReader.readLine())!=null) {
			
			System.out.println("client said: "+line);
			netWriter.write(line.toUpperCase());
			//very important
			netWriter.newLine();
			netWriter.flush();
			
		}
		s.close();
		ss.close();
	}

}
