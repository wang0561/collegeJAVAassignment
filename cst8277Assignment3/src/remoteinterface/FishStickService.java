/* File FishStickService.java
 * Author: Stanley Pieda
 * Modified By: Stanley Pieda
 * Modifed On: Sept 25, 2017
 * Description: Remote (RMI) interface for a Remote Object
 *              that will allow Cabbage objects to be inserted
 *              and searched by uuid String.
 */
package remoteinterface;

import java.rmi.Remote;
import datatransfer.FishStick;

/**
 * Methods for use by remote clients are listed here
 * @author Stanley Pieda
 */
public interface FishStickService extends Remote {
	
	/**
	 * Should allow remote client to insert a FishStick into data store
	 * @param fishStick the FishStick to be inserted
	 * @throws java.rmi.RemoteException
	 */
	public void insert(FishStick fishStick) throws java.rmi.RemoteException;
	
	/**
	 * Should allow remote client to lookup a FishStick based on UUID
	 * @param uuid A String based UUID
	 * @return A FishStick object, retrieved with given uuid, or null if uuid not in database
	 * @throws java.rmi.RemoteException
	 */
	public FishStick findByUUID(String uuid) throws java.rmi.RemoteException;
	
	
}
