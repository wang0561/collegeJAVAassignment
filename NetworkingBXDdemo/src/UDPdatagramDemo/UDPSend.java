package UDPdatagramDemo;

import java.net.*;
import java.io.*;



public class UDPSend {

	public static void main(String[] args) throws Exception{
		
		DatagramSocket ds = new DatagramSocket(65431);
	      //keyboard entry
		BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while( (line=bufr.readLine())!=null) {
			
			if("bye".equals(line))
				break;
			byte[] buf=line.getBytes();
			
			DatagramPacket dp=new DatagramPacket(buf,buf.length,
					InetAddress.getByName("192.168.2.11"),10000);
			
			ds.send(dp);
		
		
		}
	     ds.close();
	
	}

}
