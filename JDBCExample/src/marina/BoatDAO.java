/*
 * BoatDAO.java
 *
 * Created on July 2, 2005, 3:08 PM
 */

package marina;

import java.util.*;
import java.sql.*;

import sql.CoreDAO;
import sql.CoreDAOImpl;
import sql.CreateException;
import sql.DAOSysException;
import sql.NoSuchEntityException;


/**
 *	Data access object for a Boat entity.
 * @author Reg
 */
public class BoatDAO extends CoreDAOImpl		{
	/**
	 * Creates a new instance of BoatDAO
	 */
	public BoatDAO() { this(CoreDAO.DRIVER_NAME, CoreDAO.URL, CoreDAO.USER, CoreDAO.PASSWORD);		}

	/**
	 *	Parameterized constructor.  When extending this class the
	 *	derived class must invoke one of this classes constructors
	 *	for proper initialization.
	 *	@param	driver	Database driver.
	 *	@param	url		Database URL.
	 *	@param	user		Database user name.
	 *	@param	password	Database password for access.
	 *	@throws	SQLException when a SQL error has occured.
	 */
	public BoatDAO(String drivername,
						String url,
						String user,
						String password)	{
		super(drivername, url, user, password);
	}

	
	/* ACCESSORS	-----------------------------------------------	*/

	
	/* MUTATORS	--------------------------------------------------	*/



	/* BEHAVIOR	--------------------------------------------------------	*/

	/**
	 * Called by create() to insert entity state for a new entity.
	 *	@param	data	Persistence data model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object data)	throws DAOSysException {
		dbInsert(data, INSERT_STATEMENT);
	}

	/**
	 * Called by create() to insert entity state for a new entity.
	 *	@param	data	Persistence data model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbInsert(Object data, String insertStm) throws DAOSysException		{
		BoatModel model = (BoatModel) data;
		PreparedStatement preparedStm = null;
		Connection connection = null;
		if (insertStm == null)	insertStm = INSERT_STATEMENT;
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(insertStm);
			preparedStm.setString(1, model.getRegistrationNo());
			preparedStm.setDouble(2, model.getLength());
			preparedStm.setString(3, model.getManufacturer());
			preparedStm.setInt(4, model.getYear());
			preparedStm.setString(5, model.getCustomerPrimarykey().getNumber());
//			preparedStm.setString(6, ((model.getSlipPrimarykey() == null) ? null : model.getSlipPrimarykey().getNumber()));
			preparedStm.executeUpdate();

		}	catch (SQLException sex)	{
			throw new DAOSysException(sex.getMessage());

		}	finally	{
			try	{
				releaseAll(null, preparedStm, connection);
			} catch (Exception ex)	{
				System.err.println("Error releasing resources <" + ex.toString());
			}
		}
	}

	/**
	 * Called by findByPrimaryKey() to retrieve entity data by the primary key.
	 *	@param	primarykey The primary key for the entity.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 * @throws	NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey)
				throws DAOSysException, NoSuchEntityException {
//		if (_debug)	System.out.println("BDAO:dbSelectByPrimaryKey(" + primarykey + ")");
		return dbSelectByPrimaryKey(primarykey, new BoatModel());
	}

	/**
	 * Called by findByPrimaryKey() to retrieve entity data by the primary key.
	 *	@param	primarykey The primary key for the entity.
	 *	@param	selectStm	Statement to retrieved the entity data from the data store.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 * @throws	NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, Object model)
				throws DAOSysException, NoSuchEntityException	{
//		if (_debug)	System.out.println("BDAO:dbSelectByPrimaryKey(key,model)");
		return dbSelectByPrimaryKey(primarykey, SELECT_STATEMENT, model);
	}

	
	/**
	 * Called by findByPrimaryKey() to retrieve entity data by the primary key.
	 *	@param	primarykey The primary key for the entity.
	 *	@param	selectStm	Statement to retrieved the entity data from the data store.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 * @throws	NoSuchEntityException
	 */
	public Object dbSelectByPrimaryKey(Object primarykey, String selectStm, Object model)
				throws DAOSysException, NoSuchEntityException	{
		if (_debug)	System.out.println("BDAO:dbSelectByPrimaryKey(key,stm,model)");
		BoatPK pk = (BoatPK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		boolean result = false;
		if (selectStm == null)	selectStm = SELECT_STATEMENT;
		
		BoatModel persistenceModel = (BoatModel) model;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			preparedStm.setString(1, pk.getRegistrationNo());
			rs = preparedStm.executeQuery();

			result = rs.next();
			if (result)	{
//				CustomerPK cpk = new CustomerPK(rs.getString(5));
//				try	{
//					/* Get the customer 1st for this boat			*/
//					customer = Customer.findByPrimarykey(cpk);
//				} catch	(NoSuchEntityException nseex)	{
//					System.err.println("No customer <" + cpk.toString() + "> for boat <" + primarykey + ">");
//				}
				
				persistenceModel.setPrimarykey(new BoatPK(rs.getString(1)));
				persistenceModel.setLength(rs.getDouble(2));
				persistenceModel.setManufacturer(rs.getString(3));
				persistenceModel.setYear(rs.getInt(4));
				persistenceModel.setCustomerPrimarykey(new CustomerPK(rs.getString(5)));
//				persistenceModel = new BoatModel(rs.getString(1),
//																rs.getDouble(2),
//																rs.getString(3),
//																rs.getInt(4),
//																customer
//																);
			}	else	{
				throw new NoSuchEntityException("Boat ID for <"
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
	 * Called by findByCustomer() to retrieve entity data by the primary key.
	 *	@param	primarykey The primary key for the entity.
	 *	@return	The persistence model for the entity.
	 *	@throws	DAOSysException
	 * @throws	NoSuchEntityException
	 */
	public Collection dbSelectByCustomer(CustomerPK customerPK)
				throws DAOSysException, NoSuchEntityException {
		return dbSelectByCustomer(customerPK, SELECT_BY_CUSTOMER_STATEMENT);
	}
	

	/**
	 * Called by findByCustomer() to retrieve entity data for one customer.
	 *	@param	customer	The customer for searching.
	 *	@param	selectStm	Statement to retrieved the entity data from the data store.
	 *	@return	A collection of primary keys for the query.
	 *	@throws	DAOSysException 
	 * @throws	NoSuchEntityException
	 */
	public Collection dbSelectByCustomer(CustomerPK customerPK, String selectStm)
				throws DAOSysException, NoSuchEntityException	{
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		ArrayList<BoatPK> list = null;
		if (selectStm == null)	selectStm = SELECT_BY_CUSTOMER_STATEMENT;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			preparedStm.setString(1, customerPK.getNumber());
			rs = preparedStm.executeQuery();

			list = new ArrayList<BoatPK>();
			while (rs.next())	{
				list.add(new BoatPK(rs.getString(1)));
			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
						"dbSelectByCustomer() SQL Exception\n"
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
	 * Called by findAll() to find all entities in the data store.
	 *	@return	A collection of primary keys representing all of the entities.
	 *	@throws	DAOSysException
	 */
	public Collection dbSelectAll()	throws DAOSysException {
		return dbSelectAll(SELECT_DISTINCT_STATEMENT);
	}
	
	/**
	 * Called by findAll() to find all entities.
	 *	@return	A collection of primary keys representing all of the entities.
	 *	@throws	DAOSysException
	 */
	public Collection dbSelectAll(String selectStm)	throws DAOSysException {
		Connection connection = null;
		PreparedStatement preparedStm = null;
		ResultSet rs = null;
		ArrayList<BoatPK> list = null;
		if (selectStm == null)	selectStm = SELECT_DISTINCT_STATEMENT;

		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(selectStm);
			rs = preparedStm.executeQuery();

			list = new ArrayList<BoatPK>();
			while (rs.next())	{
				list.add(new BoatPK(rs.getString(1)));
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
	 * Called by update() to update state for an entity in the datastore.
	 *	@param	data	Persistence model for the entity.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data)	throws DAOSysException	{
		dbUpdate(data, UPDATE_STATEMENT);
	}

	/**
	 * Called by update() to update state for an entity in the database.
	 *	@param	data	Persistence model for the entity.
	 *	@param	updateStm	Data store update statement.
	 *	@throws	DAOSysException
	 */
	public void dbUpdate(Object data, String updateStm)	throws DAOSysException {
		BoatModel model = (BoatModel) data;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		if (updateStm == null)	updateStm = UPDATE_STATEMENT;
		
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(updateStm);

			/*	Grab values from persistent fields to store in datastore	*/
			preparedStm.setDouble(1, model.getLength());
			preparedStm.setString(2, model.getManufacturer());
			preparedStm.setInt(3, model.getYear());
			preparedStm.setString(4, model.getCustomerPrimarykey().getNumber());
			preparedStm.setString(5, model.getRegistrationNo());
			
 			int rowCount = preparedStm.executeUpdate();
			if (rowCount == 0)	{
 				throw new DAOSysException(
 					"Failed to store state for Boat <"
 					+ model.getRegistrationNo() + ">");
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
		return dbRemove(primarykey, DELETE_STATEMENT);
	}

	/**
	 * Called by remove() to remove the state for a Boat entity from the database.
	 *	@param	primarykey	The primary key of the Boat entity
	 *	to be removed from the data store.
	 *	@throws	DAOSysException
	 */
	public int dbRemove(Object primarykey, String deleteStm)	throws DAOSysException	{
		BoatPK pk = (BoatPK) primarykey;
		Connection connection = null;
		PreparedStatement preparedStm = null;
		int result = 0;
		if (deleteStm == null)	deleteStm = DELETE_STATEMENT;
		
		try	{
			connection = connectToDB();
			preparedStm = connection.prepareStatement(deleteStm);
			preparedStm.setString(1, pk.getRegistrationNo());
			result = preparedStm.executeUpdate();

			if (result == 0)	{
				throw new SQLException(
						"Failed to remove Boat <"
						+ pk.toString() + ">.");
			}

		}	catch (SQLException sex)	{
			throw new DAOSysException(
					"dbRemoveBoat() SQL Exception\n"
					+ sex.getMessage());

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
	 * Called by getTotalBoats(). A select query to count the number of records in the
	 * database (the number of Boats).
	 *	@throws	SQLException
	 */
	public int dbCountTotalEntities()
				throws DAOSysException	{
		String selectStm = SELECT_DISTINCT_STATEMENT;

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
						"dbCountTotalBoats() SQL Exception\n"
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



	/* ATTRIBUTES	-----------------------------------------------	*/
	private final static String DELETE_STATEMENT = "DELETE FROM "
								+ "Boat"
								+ " WHERE registrationNo = ?";
	private final static String UPDATE_STATEMENT = "UPDATE "
								+ "Boat"
								+ " SET "
								+ "length = ?, "
								+ "manufacturer = ?, "
								+ "year = ?, "
								+ "customerNumber = ? "
								+ "where registrationNo = ?";
	private final static String SELECT_DISTINCT_STATEMENT = "SELECT DISTINCT "
								+ "registrationNo "
								+ "FROM "
								+ "Boat";
	private final static String SELECT_BY_CUSTOMER_STATEMENT = "SELECT "
								+ "registrationNo "
								+ "FROM "
								+ "Boat"
								+ " WHERE customerNumber = ? ";
	
	private final static String SELECT_STATEMENT = "SELECT "
							+ "registrationNo, "
							+ "length, "
							+ "manufacturer,"
							+ " year, "
							+ "customerNumber "
							+ "FROM " + "Boat"
							+ " WHERE registrationNo = ? ";

	private final static String INSERT_STATEMENT = "INSERT INTO "
										+ "Boat"
										+ " VALUES "
										+ "( ?, ?, ?, ?, ? )";
	

	private final static boolean _debug = false;


}	/*	End of Class:	BoatDAO.java				*/
