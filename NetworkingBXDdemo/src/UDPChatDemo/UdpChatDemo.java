package UDPChatDemo;

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class UdpChatDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
      
        DatagramSocket socket=new DatagramSocket(10008);
        

        
        new Thread(new Send(socket)).start();
        new Thread(new Rece(socket)).start();


	}

}

class Send implements Runnable{
	private DatagramSocket ds;
	public Send(DatagramSocket ds) {
		this.ds=ds;
	}
	@Override
	public void run() {
		try (BufferedReader br
				=new BufferedReader(new InputStreamReader(System.in)))
		{	
			String line=null;
			while((line=br.readLine())!=null ){

				byte[] buff= line.getBytes();
				DatagramPacket dp=
						new DatagramPacket(buff,buff.length,InetAddress.getByName("192.168.2.255"),10009);
				ds.send(dp);
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}

	}
}

class Rece implements Runnable{

	private DatagramSocket ds;
	public Rece(DatagramSocket ds) {
		this.ds=ds;
	}
	@Override
	public void run() {
		try (BufferedReader br
				=new BufferedReader(new InputStreamReader(System.in)))
		{	
			while(true) {
				byte [] buff = new byte[1024*64];
				DatagramPacket dp = new DatagramPacket(buff,buff.length);
				
				ds.receive(dp);
				
				String data = new String(dp.getData(),0,dp.getLength());
				int port =dp.getPort();
				String ip= dp.getAddress().getHostAddress();

				System.out.println("data received as: "+ data+"\nfrom address:"+ip+
						"\n from send port: "+ port+"\n to receive port"+ds.getPort());

			}

		
	}catch(Exception e1) {
		System.err.println(e1.getMessage());
	}
	}
}

