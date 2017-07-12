/*
 * AnnualLeaseDAO.java
 *
 * Created on July 9, 2005, 4:14 PM
 */

package marina;

import java.util.*;
import java.sql.*;

import sql.DAOFactory;
import sql.CoreDAOImpl;
import sql.CreateException;
import sql.CoreDAO;
import sql.DAOSysException;
import sql.NoSuchEntityException;

/**
 *	Data access object for AnnualLease data.  This class bridges the
 *	object to non-object datastore layer.
 * @author Reg
 */
public class AnnualLeaseDAO extends LeaseDAO		{
	/**
	 * Creates a new instance of AnnualLeaseDAO
	 */
	public AnnualLeaseDAO() { this(CoreDAO.DRIVER_NAME, CoreDAO.URL, CoreDAO.USER, CoreDAO.PASSWORD);		}

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
	public AnnualLeaseDAO(String drivername,
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
		if (isDebugging())	System.out.println("ALDAO:dbInsert(" + data + ")");
		dbInsert(data, INSERT_STATEMENT);
	}

	
	/**
	 * Called by create() to insert entity state into the data store for a new entity.
	 *	@param	data	Persistence data model for the entity.
	 *	@param	insertStm	Data store statement for inserting into the data store.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object data, String insertStm) throws DAOSysException		{
		if (isDebugging())	System.out.println("ALDAO:dbInsert(" + data + ", stm)");
		/*	Insert into the lease data store first.						*/
		super.dbInsert(data, null);

		AnnualLeaseModel model = (AnnualLeaseModel) data;
		PreparedStatement preparedStm = null;
		Connection connection = null;
		if (insertStm == null)	insertStm = INSERT_STATEMENT;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(insertStm);
			preparedStm.setString(1, model.getNumber());
			preparedStm.setDouble(2, model.getBalanceDue());
			preparedStm.setInt(3, (model.getPayMonthly() ? 1 : 0));
			preparedStm.executeUpdate();

		}	catch (SQLException sex)	{
			throw new DAOSysException("Error adding AnnualLease <" + model.getNumber() + "> " + sex.getMessage());

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
		if (isDebugging())	System.out.println("ALDAO:dbSelectByPrimaryKey(" + primarykey + ")");
		return dbSelectByPrimaryKey(primarykey, new AnnualLeaseModel());
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
		if (isDebugging())	System.out.println("ALDAO:dbSelectByPrimaryKey(" + primarykey + ")");
		String selectStm = "SELECT "
								+ " number, "
								+ " balanceDue, "
								+ " payMonthly "
								+ " FROM AnnualLease "
								+ " WHERE number = ?";
		return dbSelectByPrimaryKey(primarykey, selectStm, model);
	}


	/**
	 * Called by findByPrimaryKey() to retrieve an entity by the primary key.
	 *	@param	primarykey The primary key for an entity.
	 *	@param	selectStm	Data store statement to get the entity.
	 *	@param	model	The persistence model to be populated.
	 *	@return	The persistence model for the entity, else null entity data is not found.
	 *	@throws	DAOSysException, NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, String selectStm, Object model)
				throws DAOSysException, NoSuchEntityException	{
		model = super.dbSelectByPrimaryKey(primarykey, model);
		AnnualLeasePK pk = (AnnualLeasePK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		boolean result = false;
		if (selectStm == null)	selectStm = SELECT_STATEMENT;
		AnnualLeaseModel persistenceModel = (AnnualLeaseModel) model;

		try	{
			/* Build the parent Lease model first				*/
			LeaseDAO dao = (LeaseDAO) DAOFactory.getDAO("marina.Lease");
			model = dao.dbSelectByPrimaryKey(primarykey, model);

			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			preparedStm.setString(1, pk.getNumber());
			rs = preparedStm.executeQuery();

			result = rs.next();
			if (result)	{ 
				persistenceModel.setBalanceDue(rs.getDouble(2));
				persistenceModel.setPayMonthly( ((rs.getInt(3) == 0) ? false : true));
//				persistenceModel = new AnnualLeaseModel(rs.getString(1),
//															rs.getDouble(2),
//															((rs.getInt(3) == 0) ? false : true)
//														);
			}	else	{
				throw new NoSuchEntityException("AnnualLease ID for <"
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
		return dbSelectAll(SELECT_DISTINCT_STATEMENT);
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
		ArrayList<AnnualLeasePK> list = null;
		if (selectStm == null)	selectStm = SELECT_DISTINCT_STATEMENT;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			rs = preparedStm.executeQuery();

			list = new ArrayList<AnnualLeasePK>();
			while (rs.next())	{
				list.add(new AnnualLeasePK(rs.getString(1)));
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
		super.dbUpdate(data);
		dbUpdate(data, UPDATE_STATEMENT);
	}

	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@param	updateStm	Data store update statement.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data, String updateStm)	throws DAOSysException {
		AnnualLeaseModel model = (AnnualLeaseModel) data;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		if (updateStm == null)	updateStm = UPDATE_STATEMENT;
		
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(updateStm);

			/*	Grab values from persistent fields to store in database	*/
			preparedStm.setDouble(1, model.getBalanceDue());
			preparedStm.setInt(2, ((model.getPayMonthly()) ? 1 : 0));
			preparedStm.setString(3, model.getNumber());
			
 			int rowCount = preparedStm.executeUpdate();
			if (rowCount == 0)	{
 				throw new DAOSysException(
 					"Failed to store state for AnnualLease <"
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
		int delcount = dbRemove(primarykey, DELETE_STATEMENT);
		return delcount;
	}
	
	/**
	 * Called by remove() to remove the state for a AnnualLease entity from the database.
	 *	@param	primarykey	The primary key of the AnnualLease entity
	 *	to be removed from the data store.
	 *	@param	deleteStm	Statement to remove entity data from the data store.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey, String deleteStm)	throws DAOSysException	{
		AnnualLeasePK pk = (AnnualLeasePK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		int result = 0;
		if (deleteStm == null)	deleteStm = DELETE_STATEMENT;
		
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(deleteStm);
			preparedStm.setString(1, pk.getNumber());
			result = preparedStm.executeUpdate();

			if (result == 0)	{
				throw new SQLException(
						"Failed to remove AnnualLease <"
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

		result =+ super.dbRemove(primarykey, null);
		return result;
	}


	/**
	 * Called by getTotalEntities().
	 *	@return	The total number of entities in the data store.
	 *	@throws	DAOSysException
	 */
	public int dbCountTotalEntities()	throws DAOSysException	{
		int lcount = super.dbCountTotalEntities();
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		int count = 0;
		String selectStm = SELECT_DISTINCT_STATEMENT;

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
						"dbCountTotalAnnualLeases() SQL Exception\n"
						+ sex.getMessage());

		}	finally	{
			try	{
				releaseAll(rs, preparedStm, connection);
			} catch	(SQLException sqlex)	{
				throw new DAOSysException(sqlex.toString());
			}
		}

		return count + lcount;
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
	private final static String SELECT_STATEMENT = "SELECT "
								+ " number, "
								+ " balanceDue, "
								+ " payMonthly "
								+ " FROM AnnualLease "
								+ " WHERE number = ?";
	
	private final static String INSERT_STATEMENT = "INSERT INTO "
										+ "AnnualLease"
										+ " VALUES "
										+ "( ?, ?, ? )";
	private final static String SELECT_DISTINCT_STATEMENT = "SELECT DISTINCT "
								+ " number "
								+ "FROM "
								+ "AnnualLease";
	private final static String UPDATE_STATEMENT = "UPDATE "
								+ "AnnualLease"
								+ " SET "
								+ "balanceDue = ? "
								+ "payMonthly = ? "
								+ "where number = ?";
	private final static String DELETE_STATEMENT = "DELETE FROM "
								+ "AnnualLease"
								+ " WHERE number = ?";

	
}	/*	End of Class:	AnnualLeaseDAO.java				*/
