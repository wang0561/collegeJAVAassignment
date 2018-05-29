/* Description
 * This is an implementation (Impl) of the Remote interface Hello.
 * The implementation can have additional methods but only those
 * methods defined in the Remote interface are accessible to the Client.
 * 
 * This class also extends UnicastRemoteObject, the constructor places
 * a call to the super-class constructor which will cause this instance
 * to be exported to the rmi registry. 
 */
package server;
import java.rmi.*;
import java.rmi.server.*;

import remoteinterface.Hello;
/**
 * Remote Class for the "Hello, world!" example.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {
  private String message;
  /**
   * Construct a remote object
   * @param msg the message of the remote object, such as "Hello, world!".
   * @exception RemoteException if the object handle cannot be constructed.
   */
  public HelloImpl (String msg) throws RemoteException {
	super(); // this call to super-class constructor happens even if you omit super();
    message = msg;
  }
  /**
   * Implementation of the remotely invocable method.
   * @return the message of the remote object, such as "Hello, world!".
   * @exception RemoteException if the remote invocation fails.
   */
  public String say() throws RemoteException {
    return message;
  }
}

