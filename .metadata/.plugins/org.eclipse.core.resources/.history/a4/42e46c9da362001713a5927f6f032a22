/*
 * LeaseDAO.java
 *
 * Created on July 9, 2005, 4:14 PM
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
 *	Data access object for Lease data.  This class bridges the
 *	object to non-object datastore layer.
 * @author Reg
 */
public class LeaseDAO extends CoreDAOImpl	{
	/**
	 * Creates a new instance of LeaseDAO
	 */
	public LeaseDAO() { this(CoreDAO.DRIVER_NAME, CoreDAO.URL, CoreDAO.USER, CoreDAO.PASSWORD);		}

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
	public LeaseDAO(String drivername,
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
		if (isDebugging())	System.out.println("LDAO:dbInser(" + data + ")");
		LeaseDAO d = (LeaseDAO) this;
		this.dbInsert((Object) data, INSERT_STATEMENT);
	}
	
	/**
	 * Called by create() to insert entity state into the data store for a new entity.
	 *	@param	data	Persistence data model for the entity.
	 *	@param	insertStm	Data store statement for inserting into the data store.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object data, String insertStm) throws DAOSysException		{
		if (isDebugging())	System.out.println("LDAO:dbinsert(" + data + ", stm)");
		PreparedStatement preparedStm = null;
		Connection connection = null;
		if (insertStm == null) insertStm = INSERT_STATEMENT;
		LeaseModel model = (LeaseModel) data;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(insertStm);
			preparedStm.setString(1, model.getNumber());
			preparedStm.setDouble(2, model.getAmount());
			preparedStm.setDate(3, model.getStartDate());
			preparedStm.setDate(4, model.getEndDate());
			preparedStm.setString(5,
					  ((model.getCustomerPrimarykey() != null) ? model.getCustomerPrimarykey().getNumber() : null) );
			preparedStm.setString(6,
					  ((model.getSlipPrimarykey() != null) ? model.getSlipPrimarykey().getNumber() : null) );
			preparedStm.executeUpdate();

		}	catch (SQLException sex)	{
			throw new DAOSysException("Error adding Lease <" + model.getNumber() + "> " + sex.getMessage());

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}

		if (isDebugging())	System.out.println("LDAO:dbinsert(" + data + ", stm) ----- COMPLETE");
	}

	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey)
				throws DAOSysException, NoSuchEntityException {
		if (isDebugging())	System.out.println("LDAO:dbSelectByPrimaryKey(" + primarykey + ")");
		return this.dbSelectByPrimaryKey(primarykey, (Object) new LeaseModel());
	}

	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	Populates the persistence model that is passed as an argument.
	 *	@param	primarykey The primary key for an entity.
	 *	@param	selectStm	Data store statement to get the entity.
	 *	@param	model	The persistence model for a lease.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, Object model)
				throws DAOSysException, NoSuchEntityException	{
		if (isDebugging())	System.out.println("LDAO:dbSelectByPrimaryKey(" + primarykey + ", model)");
		return this.dbSelectByPrimaryKey(primarykey, SELECT_STATEMENT, model);
	}
	
	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	Populates the persistence model that is passed as an argument.
	 *	@param	primarykey The primary key for an entity.
	 *	@param	selectStm	Data store statement to get the entity.
	 *	@param	model	The persistence model for a lease.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, String selectStm, Object model)
				throws DAOSysException, NoSuchEntityException	{
		if (isDebugging())	System.out.println("LDAO:dbSelectByPrimaryKey(" + primarykey + ", stm, model)");
		LeasePK pk = (LeasePK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		boolean result = false;

		if (selectStm == null) selectStm = SELECT_STATEMENT;
		LeaseModel persistenceModel = (LeaseModel) model;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			preparedStm.setString(1, pk.getNumber());
			rs = preparedStm.executeQuery();

			result = rs.next();
			if (result)	{ 
				persistenceModel.setPrimarykey(new LeasePK(rs.getString(1)));
				persistenceModel.setAmount(rs.getDouble(2));
				persistenceModel.setStartDate(rs.getDate(3));
				persistenceModel.setEndDate(rs.getDate(4));
				persistenceModel.setCustomerPrimarykey(new CustomerPK(rs.getString(5)));
				persistenceModel.setSlipPrimarykey(new SlipPK(rs.getString(6)));

			}	else	{
				throw new NoSuchEntityException("Lease ID for <"
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
		if (isDebugging())	System.out.println("LDAO:dbSelectAll()");
		return this.dbSelectAll(SELECT_DISTINCT_STATEMENT);
	}	

	

	/**
	 * Called by findAll() to find all entities in the data store.
	 *	@return	A collection of primary keys representing all of the entities.
	 *	@throws	SQLException
	 */
	public Collection dbSelectAll(String selectStm)	throws DAOSysException {
		if (isDebugging())	System.out.println("LDAO:dbSelectAll(stm)");
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		ArrayList<LeasePK> list = null;
		if (selectStm == null) selectStm = SELECT_DISTINCT_STATEMENT;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			rs = preparedStm.executeQuery();

			list = new ArrayList<LeasePK>();
			while (rs.next())	{
				list.add(new LeasePK(rs.getString(1)));
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
		if (isDebugging())	System.out.println("LDAO:dbUpdate(" + data + ")");
		this.dbUpdate(data, UPDATE_STATEMENT);
	}


	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@param	updateStm	Data store update statement.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data, String updateStm)	throws DAOSysException {
		if (isDebugging())	System.out.println("LDAO:dbUpdate(" + data + ", stm)");
		LeaseModel model = (LeaseModel) data;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(updateStm);

			/*	Grab values from persistent fields to store in database	*/
			preparedStm.setDouble(1, model.getAmount());
			preparedStm.setDate(2, model.getStartDate());
			preparedStm.setDate(3, model.getEndDate());
			preparedStm.setString(4,
					  ((model.getCustomerPrimarykey() != null) ? model.getCustomerPrimarykey().getNumber() : null) );
			preparedStm.setString(5,
					  ((model.getSlipPrimarykey() != null) ? model.getSlipPrimarykey().getNumber() : null) );
			preparedStm.setString(6, model.getNumber());
			
 			int rowCount = preparedStm.executeUpdate();
			if (rowCount == 0)	{
 				throw new DAOSysException(
 					"Failed to store state for Lease <"
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
		if (isDebugging())	System.out.println("LDAO:dbRemove(" + primarykey + ")");
		return this.dbRemove(primarykey, DELETE_STATEMENT);
	}
	
	/**
	 * Called by remove() to remove the state for a Lease entity from the database.
	 *	@param	primarykey	The primary key of the Lease entity
	 *	to be removed from the data store.
	 *	@param	deleteStm	Statement to remove entity data from the data store.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey, String deleteStm)	throws DAOSysException	{
		if (isDebugging())	System.out.println("LDAO:dbRemove(" + primarykey + ", stm)");
		LeasePK pk = (LeasePK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		int result = 0;
		if (deleteStm == null) deleteStm = DELETE_STATEMENT;
		
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(deleteStm);
			preparedStm.setString(1, pk.getNumber());
			result = preparedStm.executeUpdate();

			if (result == 0)	{
				throw new SQLException(
						"Failed to remove Lease <"
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
		if (isDebugging())	System.out.println("LDAO:dbCountTotalEntities()");
		String selectStm = "SELECT DISTINCT number FROM "
							+ "Lease";
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
						"dbCountTotalLeases() SQL Exception\n"
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

	public boolean isDebugging()	{ return _debug;	}

	
	/* ATTRIBUTES	-----------------------------------------------	*/
	private final static String INSERT_STATEMENT = "INSERT INTO "
										+ "Lease"
										+ " VALUES "
										+ "( ?, ?, ?, ?, ?, ? )";
	private final static String SELECT_STATEMENT = "SELECT "
								+ " number, "
								+ " amount, "
								+ " startDate, "
								+ " endDate, "
								+ " customerNumber, "
								+ " slipNumber "
								+ " FROM Lease "
								+ " WHERE number = ?";
	private final static String SELECT_DISTINCT_STATEMENT = "SELECT DISTINCT "
								+ " number "
								+ "FROM "
								+ "Lease";
	private final static String UPDATE_STATEMENT = "UPDATE "
								+ "Lease"
								+ " SET "
								+ "amount = ? "
								+ "startDate = ? "
								+ "endDate = ? "
								+ "customerNumber = ? "
								+ "slipNumber = ? "
								+ "where number = ?";
	private final static String DELETE_STATEMENT = "DELETE FROM "
								+ "Lease"
								+ " WHERE number = ?";

	private final static boolean _debug = true;
	
	
}	/*	End of Class:	LeaseDAO.java				*/
