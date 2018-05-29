/* Description
 * This is an implementation (Impl) of the Remote interface Calculator.
 * The implementation can have additional methods but only those
 * methods defined in the Remote interface are accessible to the Client.
 * 
 * (This class does not extend UnicastRemoteObject, so additional code 
 * will be needed to export it to the rmi registry when starting up the server.)
 */
package server;

import remoteinterface.Calculator;

public class CalculatorImpl implements Calculator {

    public long add(long a, long b, String hostName)
        throws java.rmi.RemoteException {
    	System.out.println("adding "+a+" plus "+ b + " for " + hostName);
        return a + b;
    }

    public long subtract(long a, long b, String hostName)
        throws java.rmi.RemoteException {
    	System.out.println("subtracting "+a+" minus "+ b+ " for " + hostName);
        return a - b;
    }

    public long multiply(long a, long b, String hostName)
        throws java.rmi.RemoteException {
    	System.out.println("multiplying "+a+" times "+ b+ " for " + hostName);
        return a * b;
    }

    public long divide(long a, long b, String hostName)
        throws java.rmi.RemoteException {
    	System.out.println("dividing "+a+" by "+ b+ " for " + hostName);
        return a / b;
    }
}
