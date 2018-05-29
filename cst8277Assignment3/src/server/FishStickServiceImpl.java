/* File FishStickServiceImpl.java
 * Author: Stanley Pieda
 * Modified By: 
 * Modifed On: Jan 2018
 * Description: Remote Object that permits clients to insert
 *              FishStick records into a database, as well as
 *              retrieve them using String based uuid.
 */
package server;

import java.rmi.RemoteException;

import datatransfer.FishStick;

import dataaccesslayer.FishStickDao;
import dataaccesslayer.FishStickDaoImpl;

import remoteinterface.FishStickService;
/**
 * Ensure that all classes have Javadoc comments with your name
 * @author Tao Wang & Min Luo
 */
public class FishStickServiceImpl implements FishStickService  {
	/** Dao object*/
	private final FishStickDaoImpl dao;
	
	/**constructor for FishstickserviceImp*/
	public FishStickServiceImpl() {
		dao = FishStickDaoImpl.INSTANCE;
	}
	
	/**
	 *@param FishStick fishStick
	 *Method for inserting fishstick object 
	 */
	@Override
	public void insert(FishStick fishStick) throws RemoteException {
		// code to use the FishStickDaoImpl to insert a record
		dao.insertFishStick(fishStick);
		//System.out.println("From "+clientName+" >"+fishStick.toString());
	}
	/**
	 *@param String uuid
	 *@return FishStick 
	 * 
	 */
	@Override
	public FishStick findByUUID(String uuid) throws RemoteException {
		// code to use the FishStickDaoImpl to lookup and return a FishStick
		return dao.findByUUID(uuid);
	}
	
	// Do not place this method into remote interface. i.e. no @Override
	/**
	 * Method for shutdown the dao resources.
	 * */
	public void shutDownDao() {
		dao.shutdown();
	}
}
