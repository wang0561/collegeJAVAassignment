/*
 *	DAOFactory.java
 *
 * Created on July 3, 2005, 10:54 AM
 */


package sql;

import marina.*;

/**
 * Boat data access object factory.
 * @author    R. Dyer
 * @version   1.0.0 Aug 2002
 */
public class DAOFactory	{
	/**
	 *	Default construtor.
	 */
	private DAOFactory()	{}
	
	/**
	 * Instantiate a subclass that implements the abstract
	 *	BoatDAO interface.
	 */
	public static CoreDAO getDAO(String classname)	throws DAOSysException	{
		CoreDAO dao = null;
		String daoclass = classname + "DAO";

		try {
			/*	Instantiate class, which will provide implementation
			 *	for the CustomerDAO interface
			 */
			dao = (CoreDAO) Class.forName(daoclass).newInstance();

		}	catch (Exception ex)	{
			throw new DAOSysException(
					"DAOFactory.getDAO() "
					+ " Error instantiating DAO object <" + daoclass + "> "	+ ex.getMessage());
		}

		return dao;
	}

	}	/*	End of CLASS:	DAOFactory.java				*/
