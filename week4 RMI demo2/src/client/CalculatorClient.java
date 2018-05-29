/* Description
 * This client attempts to obtain a reference or stub to the
 * remote object on server's rmi registry with name "CalculatorService"
 */
package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Random;

import remoteinterface.Calculator;
import java.net.*;
import java.rmi.NotBoundException;



public class CalculatorClient {

    public static void main(String[] args) {
    	Random random = new Random();
    	String myHostName = "localhost";
    	try {
			InetAddress myHost = Inet4Address.getLocalHost();
			myHostName = myHost.getHostName();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	int port = 1099;
    	String serverName = new String("localhost");
        switch (args.length) {
        case 0:
            break;
        case 1: 
        	serverName = args[0];
        	break;
        case 2:
        	serverName = args[0];
        	port = Integer.parseInt(args[1]);
        	break;
        default:
        	System.out.println("usage: CalculatorClient [hostname] [port]");
        	break;
        }  
        try {
        	System.out.println("Attempting to connect to rmi://"+serverName+":"+port+"/CalculatorService");
            Calculator c = (Calculator) 
                          Naming.lookup(
                "rmi://"+serverName+":"+port+"/CalculatorService");
            while (true){
            	int operand1 = random.nextInt(10) + 1; // 1 to 10
            	int operand2 = random.nextInt(10) + 1; // 1 to 10
            	System.out.printf("What is %d subtract %d? Server says: %d%n",
            			operand1, operand2, c.subtract(operand1, operand2,myHostName));
            	System.out.printf("What is %d added to %d? Server says: %d%n",
            			operand1, operand2, c.add(operand1, operand2,myHostName));
            	System.out.printf("What is %d multiplied against %d? Server says: %d%n",
            			operand1, operand2, c.multiply(operand1, operand2,myHostName));
            	System.out.printf("What is %d divided by %d? Server says: %d%n",
            			operand1, operand2, c.divide(operand1, operand2,myHostName));
            	System.out.println();
            	try {
            		Thread.sleep(1000);
            	}catch (InterruptedException e){}
            }
        }
        catch (MalformedURLException e) {
            System.out.println();
            System.out.println(
              "MalformedURLException");
            System.out.println(e.getMessage());
        }
        catch (RemoteException e) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(e.getMessage());
        }
        catch (NotBoundException e) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(e.getMessage());
        }
        catch (java.lang.ArithmeticException e) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(e.getMessage());
        }
        catch (java.lang.Exception e) {
            System.out.println();
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
}
