/* Description
 * This interface defines the methods a Client can invoke
 * against a remote object. 
 */
package remoteinterface;

import java.rmi.Remote;

public interface EchoService extends Remote {

	public String processMessage(String message) 
			throws java.rmi.RemoteException;
	
}
