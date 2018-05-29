/* Description
 * This is an implementation (Impl) of the Remote interface EchoService.
 * The implementation can have additional methods but only those
 * methods defined in the Remote interface are accessible to the Client.
 * 
 * (This class does not extend UnicastRemoteObject, so additional code 
 * will be needed to export it to the rmi registry when starting up the server.)
 */
package server;

import remoteinterface.EchoService;

/**
 *
 * @author Todd
 */
public class EchoServiceImpl implements EchoService {

	private int messagenum;

    public String processMessage(String message){
    	System.out.printf("From: %s%n", message);
		return String.format("Message number: %d, output> %s", messagenum++, message);
    }
}