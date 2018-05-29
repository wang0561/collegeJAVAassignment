/* File: EchoServerService.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Feb 13, 2018
 * Description: Interface with remote method for clients to use.
 *              Update: Added more programmer comments.
 */
package server;
import java.rmi.Remote;

/** Remote interface for the RMI-based EchoServer
 */
public interface EchoServerService extends Remote {
	// this is a method remote clients can call
	public String processMessage(String hostName, String message) 
			throws java.rmi.RemoteException;
	
	// do not add the shutdown() method from within EchoServerServiceImpl,
	// we do not want remote clients to be able to call shutdown().
}
