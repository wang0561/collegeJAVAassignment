package UDPdatagramDemo;

import java.net.*;

public class UDPReceive {

	public static void main(String[] args) {
		
		
		//set 10000 to listening the data
		
		try(DatagramSocket ds = new DatagramSocket(10000)){
		
		while(true) {
		//set received packet
		byte[] buf = new byte[1024*64];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		
		//receive packet
		ds.receive(dp);
		
		//retrieve data from packet
		 String data = new String(dp.getData(),0,dp.getLength());
         int port =dp.getPort();
         String ip= dp.getAddress().getHostAddress();
         
         System.out.println("data received as: "+ data+"\nfrom address:"+ip+
        		 "\n from send port: "+ port+"\n to receive port"+ds.getPort());
         
         if("bye".equals(data))
        	 break;
		}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
         
	}

}
