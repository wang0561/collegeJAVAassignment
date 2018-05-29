package UDPdatagramDemo;

import java.net.InetAddress;
import static java.lang.System.*;

public class IPAddressDemo {

	public static void main(String[] args) throws Exception {
		
		InetAddress i = InetAddress.getLocalHost();
		out.println(i.toString());
		out.println("ip address:"+i.getHostAddress());
		out.println("host name:"+i.getHostName());

	
		InetAddress ia=InetAddress.getByName("google.ca");
		out.println(ia.toString());
		out.println("ip address:"+ia.getHostAddress());
		out.println("host name:"+ia.getHostName());

        InetAddress[] array=InetAddress.getAllByName("google.ca");
        for(InetAddress a : array)
        	out.println(a.toString());

	}

}
