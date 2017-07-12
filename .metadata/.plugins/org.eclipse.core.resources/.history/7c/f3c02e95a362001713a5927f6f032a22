/*
 *  @(#)CoreDAO.java   1.0 02/08/20
 *
 *  (c) Copyright 2002, 2003 by Dyer Consulting
 *      Quebec, Canada
 *      All rights reserved.
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 *
 */

package	sql;

import java.util.Collection;


/**
 * Core data access object interface.
 * @author    R. Dyer
 * @version   1.0.0 Aug 2002*/
public interface CoreDAO	{

	public final static String DRIVER_NAME		= "com.mysql.jdbc.Driver";
	public final static String URL				= "jdbc:mysql://localhost/test";
	public final static String USER				= "apptest";
	public final static String PASSWORD			= "test001";

	/**
	 *	Insert state for an entity into the datastore.
	 *	@param	model	The persistence model for the object.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object model) throws DAOSysException;

	/**
	 *	Insert state for an entity into the datastore.
	 *	@param	model	The persistence model for the object.
	 *	@param	insertStm	Statement to retrieve the entity data from the datastore.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object model, String insertStm) throws DAOSysException;

	/**
	 *	Find an entity by its primary key.
	 *	@param	primarykey	The primary key for the entity.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey)
		throws DAOSysException, NoSuchEntityException;

//	/**
//	 *	Find an entity by its primary key.
//	 *	@param	primarykey	The primary key for the entity.
//	 *	@param	selectStm	Statement to retrieve the entity from the datastore.
//	 *	@return	The persistence model for the entity.
//	 *	@throws	DAOSysException
//	 */
//	public Object dbSelectByPrimaryKey(Object primarykey, String selectStm)
//		throws DAOSysException, NoSuchEntityException;

	/**
	 *	Find an entity by its primary key.
	 *	@param	primarykey	The primary key for the entity.
	 *	@param	model	The persistence model to be populated by the select.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 *	@throws	NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, Object model)
		throws DAOSysException, NoSuchEntityException;

	/**
	 *	Find an entity by its primary key.
	 *	@param	primarykey	The primary key for the entity.
	 *	@param	selectStm	Statement to retrieve the entity from the datastore.
	 *	@param	model	The persistence model to be populated by the select.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 *	@throws	NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, String selectStm, Object model)
		throws DAOSysException, NoSuchEntityException;


	
	/**
	 *	Find all entity objects.
	 *	@return	Collection of primary keys for all entity objects.
	 *	@throws	DAOSysException
	 */
	public Collection dbSelectAll()	throws DAOSysException;

	/**
	 *	Find all entity objects.
	 *	@param	Statement to retrieve the entity from the datastore.
	 *	@return	Collection of primary keys for all entity objects.
	 *	@throws	DAOSysException
	 */
	public Collection dbSelectAll(String stm)	throws DAOSysException;

	
	/**
	 * Update state for an entity in the datastore.
	 *	@param	data	Persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data)	throws DAOSysException;

	/**
	 * Update state for an entity in the datastore.
	 *	@param	data	Persistence model for the entity.
	 *	@param	updateStm	Statement to update the entity in the datastore.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data, String updateStm)	throws DAOSysException;

	
	/**
	 *	Remove the state of an entity from the datastore.
	 *	@param	primarykey	The primary key for the object.
	 *	@return	The number of entities removed.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey)		throws DAOSysException;

	/**
	 *	Remove the state of an entity from the datastore.
	 *	@param	primarykey	The primary key for the object.
	 *	@param	deleteStm	Statement to remove the entity from the datastore.
	 *	@return	The number of entities removed.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey, String deleteStm)	throws DAOSysException;

	
	/**
	 *	Count the total number of entities.
	 *	@return	The total number of entities.
	 *	@throws	DAOSysException
	 */
	public int dbCountTotalEntities()	throws DAOSysException;

	
	/**
	 *	Load the entity data from the datastore.
	 *	@param	primarykey	The primary key object for this entity.
	 *	@return	The persistence model for this object.
	 *	@throws	DAOSysException
	 *	@throws	NoSuchEntityException
	 */
	public Object dbLoad(Object primarykey)	throws DAOSysException, NoSuchEntityException;

	/**
	 *	Load the entity data from the datastore.
	 *	@param	primarykey	The primary key object for this entity.
	 *	@param	stm	Statement to load the entity from the datastore.
	 *	@return	The persistence model for this object.
	 *	@throws	DAOSysException
	 *	@throws	NoSuchEntityException
	 */
	public Object dbLoad(Object primarykey, String stm)
			throws DAOSysException, NoSuchEntityException;

	
	/**
	 *	Store the entity data in the datastore.
	 *	@param	data	Persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbStore(Object data)		throws DAOSysException;

	/**
	 *	Store the entity data in the datastore.
	 *	@param	data	Persistence model for the entity.
	 *	@param	stm	Statement to store the entity in the datastore.
	 *	@throws	DAOSysException
	 */
	public void dbStore(Object data, String stm)		throws DAOSysException;

}	/*	End of Interface:	CoreDAO.java				*/
