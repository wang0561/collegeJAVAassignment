/*
 * CustomerDAO.java
 *
 * Created on July 2, 2005, 3:08 PM
 */

package marina;

import java.util.*;
import java.sql.*;

import sql.CoreDAOImpl;
import sql.CreateException;
import sql.CoreDAO;
import sql.DAOSysException;
import sql.NoSuchEntityException;

/**
 *	Data access object for customer data.  This class bridges the
 *	object to non-object datastore layer.
 * @author Reg
 */
public class CustomerDAO extends CoreDAOImpl	{
	/**
	 * Creates a new instance of CustomerDAO
	 */
	public CustomerDAO() { this(CoreDAO.DRIVER_NAME, CoreDAO.URL, CoreDAO.USER, CoreDAO.PASSWORD);		}

	/**
	 *	Parameterized constructor.  When extending this class the
	 *	derived class must invoke one of this classes constructors
	 *	for proper initialization.
	 *	@param	driver	Database driver.
	 *	@param	url		Database URL.
	 *	@param	user		Database user name.
	 *	@param	password	Database password for access.
	 *	@param	stm		SQL Statement for this intantiation.
	 *	@throws	SQLException when a SQL error has occured.
	 */
	public CustomerDAO(String drivername,
						String url,
						String user,
						String password)	{
		super(drivername, url, user, password);
	}

	
	/* ACCESSORS	-----------------------------------------------	*/

	
	/* MUTATORS	--------------------------------------------------	*/



	
	/* BEHAVIOR	--------------------------------------------------------	*/
	/**
	 * Called by create() to insert entity state into the data store for a new entity.
	 *	@param	data	Persistence data model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object data)	throws DAOSysException {
		String insertStatement = "INSERT INTO "
										+ "Customer"
										+ " VALUES "
										+ "( ?, ?, ?, ? )";
		dbInsert(data, insertStatement);
	}
	
	/**
	 * Called by create() to insert entity state into the data store for a new entity.
	 *	@param	data	Persistence data model for the entity.
	 *	@param	insertStm	Data store statement for inserting into the data store.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object data, String insertStm) throws DAOSysException		{
		CustomerModel model = (CustomerModel) data;
		PreparedStatement preparedStm = null;
		Connection connection = null;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(insertStm);
			preparedStm.setString(1, model.getNumber());
			preparedStm.setString(2, model.getName());
			preparedStm.setString(3, model.getAddress());
			preparedStm.setString(4, model.getPhoneNo());
			preparedStm.executeUpdate();

		}	catch (SQLException sex)	{
			throw new DAOSysException("Error adding customer <" + model.getNumber() + "> " + sex.getMessage());

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}
	}

	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey)
				throws DAOSysException, NoSuchEntityException {
//		if (_debug)	System.out.println("CDAO:dbSelectByPrimaryKey(" + primarykey + ")");
		return dbSelectByPrimaryKey(primarykey, new CustomerModel());
	}
	
	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@param	model	The persistence model to be populated.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, Object model)
				throws DAOSysException, NoSuchEntityException	{
//		if (_debug)	System.out.println("CDAO:dbSelectByPrimaryKey(key, model)");
		String selectStm = "SELECT "
								+ " number, "
								+ " name, "
								+ " address, "
								+ " phoneNo "
								+ " FROM CUSTOMER "
								+ " WHERE number = ?";
		return dbSelectByPrimaryKey(primarykey, selectStm, model);
	}
		

	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@param	selectStm	Data store statement to get the entity.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, String selectStm, Object model)
				throws DAOSysException, NoSuchEntityException	{
		if (_debug)	System.out.println("CDAO:dbSelectByPrimaryKey(key, stm, model)");
		CustomerPK pk = (CustomerPK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		boolean result = false;
		CustomerModel persistenceModel = (CustomerModel) model;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			preparedStm.setString(1, pk.getNumber());
			rs = preparedStm.executeQuery();

			result = rs.next();
			if (result)	{
				persistenceModel.setPrimaryKey(new CustomerPK(rs.getString(1)));
				persistenceModel.setName(rs.getString(2));
				persistenceModel.setAddress(rs.getString(3));
				persistenceModel.setPhoneNo(rs.getString(4));

//				persistenceModel = new CustomerModel(rs.getString(1),
//																rs.getString(2),
//																rs.getString(3),
//																rs.getString(4)
//															);
			}	else	{
				throw new NoSuchEntityException("Customer ID for <"
						+ primarykey + "> not found in the database.");
			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
				"dbSelectByPrimaryKey() SQL Exception\n"
				+ sex.getMessage());

		}	finally	{
			try	{
				releaseAll(rs, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}

		return persistenceModel;

	}

	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@return	A collection of primary keys representing all of the entities.
	 *	@throws	SQLException
	 */
	public Collection dbSelectAll()	throws DAOSysException {
		String selectStm = "SELECT DISTINCT number "
								+ "FROM " + "Customer";
		return dbSelectAll(selectStm);
	}
	
	
	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@return	A collection of primary keys representing all of the entities.
	 *	@throws	SQLException
	 */
	public Collection dbSelectAll(String selectStm)	throws DAOSysException {
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		ArrayList<CustomerPK> list = null;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			rs = preparedStm.executeQuery();

			list = new ArrayList<CustomerPK>();
			while (rs.next())	{
				list.add(new CustomerPK(rs.getString(1)));
			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
						"dbSelectAll() SQL Exception\n"
						+ sex.getMessage());
		}	finally	{
			try	{
				releaseAll(rs, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}

		return list;
	}


	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data)	throws DAOSysException	{
		String updateStm = "UPDATE " + "Customer"
								+ " SET "
								+ "name = ? "
								+ "address = ? "
								+ "phoneNo = ? "
								+ "where number = ?";
		dbUpdate(data, updateStm);
	}

	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@param	updateStm	Data store update statement.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data, String updateStm)	throws DAOSysException {
		CustomerModel model = (CustomerModel) data;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(updateStm);

			/*	Grab values from persistent fields to store in database	*/
			preparedStm.setString(1, model.getName());
			preparedStm.setString(2, model.getAddress());
			preparedStm.setString(3, model.getPhoneNo());
			preparedStm.setString(4, model.getNumber());
			
 			int rowCount = preparedStm.executeUpdate();
			if (rowCount == 0)	{
 				throw new DAOSysException(
 					"Failed to store state for Customer <"
 					+ model.getNumber() + ">");
 			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
					"dbUpdate() SQL Exception <"
					+ sex.getMessage() + ">");

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}
	}

	/**
	 * Called by remove() to remove the state for an entity from the data store.
	 *	@param	primarykey	The primary key of the entity to be removed.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey)	throws DAOSysException	{
		String deleteStm = "DELETE FROM " + "Customer"
								+ " WHERE number = ?";
		return dbRemove(primarykey, deleteStm);
	}
	
	/**
	 * Called by remove() to remove the state for a Customer entity from the database.
	 *	@param	primarykey	The primary key of the Customer entity
	 *	to be removed from the data store.
	 *	@param	deleteStm	Statement to remove entity data from the data store.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey, String deleteStm)	throws DAOSysException	{
		CustomerPK pk = (CustomerPK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		int result = 0;
		
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(deleteStm);
			preparedStm.setString(1, pk.getNumber());
			result = preparedStm.executeUpdate();

			if (result == 0)	{
				throw new SQLException(
						"Failed to remove Customer <"
						+ pk.toString() + ">.");
			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
					"dbRemove() SQL Exception <" + pk.toString() + "> " + sex.getMessage());

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (SQLException sqlex)	{
				throw new DAOSysException(sqlex.toString());
			}
		}

		return result;
	}


	/**
	 * Called by getTotalEntities().
	 *	@return	The total number of entities in the data store.
	 *	@throws	DAOSysException
	 */
	public int dbCountTotalEntities()	throws DAOSysException	{
		String selectStm = "SELECT DISTINCT number FROM "
							+ "Customer";
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		int count = 0;

		try	{
			connection = connectToDB();
			/*	Request a resultset that is scrollable to easily count rows	*/
			preparedStm = connection.prepareStatement(
										selectStm,
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);
			rs = preparedStm.executeQuery();

			/*	Go to the last row and get its row number							*/
			rs.last();
			count = rs.getRow();

		}	catch (SQLException sex)	{
			throw new DAOSysException(
						"dbCountTotalCustomers() SQL Exception\n"
						+ sex.getMessage());

		}	finally	{
			try	{
				releaseAll(rs, preparedStm, connection);
			} catch	(SQLException sqlex)	{
				throw new DAOSysException(sqlex.toString());
			}
		}

		return count;
	}

	
	
	
	/**
	 * Called by store() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@param	storeStm	Statement to store the data in the data store.
	 *	@throws	DAOSysException
	 */
	public void dbStore(Object data, String storeStm)	throws DAOSysException {
		dbUpdate(data, storeStm);
	}

	/**
	 * Called by store() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbStore(Object data)	throws DAOSysException {
		dbUpdate(data);
	}

	
	/* ATTRIBUTES	-----------------------------------------------	*/
	private final static boolean _debug = false;
	
}	/*	End of Class:	CustomerDAO.java				*/
