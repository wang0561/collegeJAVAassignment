import java.net.*;
import java.io.*;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ServerSocket ss = new ServerSocket(9999);
		Socket socket = ss.accept();
		OutputStream writer = socket.getOutputStream();

		FileInputStream reader = new FileInputStream("C:\\Users\\Wang\\Desktop\\Server.html");
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = reader.read()) >0) {
			writer.write(buffer,0,len);
			System.out.println(len);
		}
		writer.close();
		ss.close();
		socket.close();
	}

}
