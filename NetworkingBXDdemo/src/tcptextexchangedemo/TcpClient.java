package tcptextexchangedemo;
import java.net.*;
import java.io.*;
/*
 * 
 *client send a text to server and get the capital case string back 
 */
public class TcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

	Socket s = new Socket("192.168.2.11",10005);
	
	BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
	
	// we could use PrintWriter instead of BufferedWriter. because printWriter dont need end flag
	BufferedWriter netWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	
	BufferedReader netReader = new BufferedReader(new InputStreamReader((s.getInputStream())));
	
	String line = null;
	
	while((line=userInput.readLine())!=null) {
		if("quit".equals(line))
			break;
		netWriter.write(line);
		//very important, end flag
		netWriter.newLine();
		netWriter.flush();
		
		String strFromServer = netReader.readLine();
		System.out.println("server said: "+strFromServer);
	}
		
	userInput.close();
	s.close();
		
		
		
		
	}

}
