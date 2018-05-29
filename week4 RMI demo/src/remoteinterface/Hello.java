/* Description
 * This interface defines the methods a Client can invoke
 * against a remote object. 
 */
package remoteinterface;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Remote Interface for the "Hello, world!" example.
 */
public interface Hello extends Remote { // extends java.rmi.Remote
  /**
   * Remotely invocable method.
   * @return the message of the remote object, such as "Hello, world!".
   * @exception RemoteException if the remote invocation fails.
   */
  public String say() throws RemoteException; // this is only method client can use
}