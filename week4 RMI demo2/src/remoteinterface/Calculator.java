/* Description
 * This interface defines the methods a Client can invoke
 * against a remote object. 
 */
package remoteinterface;

public interface Calculator extends java.rmi.Remote {
	
    public long add(long a, long b, String name)
        throws java.rmi.RemoteException;

    public long subtract(long a, long b, String name)
        throws java.rmi.RemoteException;

    public long multiply(long a, long b, String name)
        throws java.rmi.RemoteException;

    public long divide(long a, long b, String name)
        throws java.rmi.RemoteException;
}
