/*
 *  @(#)Lease.java
 *
 *
 */

package	marina;

import java.sql.Date;

import java.util.Calendar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import sql.*;
import marina.Boat;
import marina.LeasePK;

/**
 *	AnnualLease -- subclass of Lease class overrides abstract method
 *	This subclass inherits ability to associate with Slip and AnnualLease
 *	no additional code added beyond Chapter 7 version
 */
public class AnnualLease extends Lease		{
	/* STATIC PRE-OBJECT BEHAVIOR	-----------------------------------	*/
	/* CREATORS	-----------------------------------------------------	*/
	/**
	 *	Create an instance of a new AnnualLease.
	 *	@return	An instance of a AnnualLease entity.
	 *	@param	number	The AnnualLease number.
	 *	@param	name		The name of the AnnualLease. 
	 *	@param	address	The address for this AnnualLease.
	 *	@param	phoneno	The phone number for this AnnualLease.
	 */
	public static AnnualLease create(String number,
											Date startdate,
											double amountdue,
											boolean paymonthly)
								throws CreateException				{
		if (_debug) System.out.println("AL:create:" + number);

		AnnualLeaseModel model = new AnnualLeaseModel(number, amountdue, startdate, null, null, null, 0, paymonthly);
		AnnualLeaseDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbInsert(model);
			/* Initially this AnnualLease has no boats or leases			*/

		} catch (Exception sqlex)	{
			throw new CreateException(sqlex.getMessage());
		}

		return	new AnnualLease(model);
	}
	
	/* FINDERS	-----------------------------------------------------	*/
	/*	Finder methods are used to search for a particular instance
	 *	or a collection of instances, therefore finders either return
	 *	and instance to the entity, or a collection of instances.
	 */
	/**
	 *	Find a AnnualLease by primary key.
	 *	@return	An instance of a AnnualLease entity.
	 *	@param	primarykey	The primary key for the AnnualLease to find.
	 *	@throws	ObjectNotFoundException
	 */
	public static AnnualLease findByPrimarykey(AnnualLeasePK primarykey)
								throws FinderException, NoSuchEntityException			{
		if (_debug) System.out.println("AL:findByPrimarykey(" + primarykey + ")");

		AnnualLeaseModel model = null;
		AnnualLease AnnualLease = null;
		AnnualLeaseDAO dao = null;
		try	{
			dao = getDAO();
			model = (AnnualLeaseModel) dao.dbSelectByPrimaryKey(primarykey);
			AnnualLease = new AnnualLease(model);
		
			
		} catch (Exception sqlex)	{
			throw new FinderException(sqlex.getMessage());
		}

		return AnnualLease;
	}

	/**
	 *	Find all AnnualLease entities.
	 *	@return	A collection of AnnualLease instances.
	 *	@throws	FinderException
	 * @throws	CreateException
	 */
	public static Collection<AnnualLease> findAll() throws FinderException, CreateException			{
		ArrayList<AnnualLease> listOfAnnualLeases = new ArrayList<AnnualLease>();
		AnnualLeaseDAO dao = null;
	
		try	{
			dao = getDAO();
			Collection c = dao.dbSelectAll();
			Iterator itr = c.iterator();
			AnnualLeasePK alpk = null;
			while (itr.hasNext())	{
				alpk = (AnnualLeasePK) itr.next();
				try	{
					AnnualLease annualLease = AnnualLease.findByPrimarykey(alpk);
				
					/* Add this AnnualLease to the list.						*/
					listOfAnnualLeases.add(annualLease);

				} catch (Exception ex)	{
					System.err.println("AnnualLease: Error processing list <" + ex.toString());
				}
			}

		} catch (Exception sqlex)	{
			throw new CreateException(sqlex.getMessage());
		}

		
		return listOfAnnualLeases;
	}
	
	
	/* REMOVERS	-----------------------------------------------------	*/
	/**
	 *	Remove a AnnualLease by primary key.
	 *	@param	primarykey	The primary key for the AnnualLease to find.
	 *	@throws	ObjectNotFoundException
	 */
	private static int removeByPrimarykey(AnnualLeasePK primarykey)
								throws	DAOSysException, NoSuchEntityException	{
		int rc = 0;
		AnnualLeaseDAO dao = null;
		dao = getDAO();
		rc = dao.dbRemove(primarykey);
		
		return rc;
	}

	
	/* CONSTRUCTORS	-----------------------------------------------	*/
	/**
	 *	Paramertized constructor.
	 *	@param	number
	 *	@param	startDate
	 *	@param	width
	 *	@param	isPayMonthly
	 */
	public AnnualLease(AnnualLeaseModel model)		{ super(model);		}

	/**
	 *	Paramertized constructor.
	 *	@param	number
	 *	@param	startDate
	 *	@param	width
	 *	@param	isPayMonthly
	 */
	public AnnualLease(String number,
							Date startDate,
							int slipWidth,
			  				boolean isPayMonthly)		{
		super(new AnnualLeaseModel(number, startDate));
		/*	Calculate the end date for the lease, 1 year period.	*/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.YEAR, 1);
		setEndDate(new Date(calendar.getTime().getTime()));

		/*	Calculate the fee for this slip.								*/
		setAmount(calculateFee(slipWidth));

		/* Set the monthly payment flag.									*/
		setPayMonthly(isPayMonthly);

		if (isPayMonthly())	{
			setBalanceDue(getAmount() - getAmount()/12);
		} else	{
			setBalanceDue(0);
		}

	}


	/* ACCESSORS	--------------------------------------------------	*/
	public AnnualLeaseModel getModel()		{ return (AnnualLeaseModel) super.getModel();		}
	public boolean getPayMonthly()			{ return getModel().getPayMonthly();					}
	public double getBalanceDue()				{ return getModel().getBalanceDue();					}


	/* MODIFIERS	--------------------------------------------------	*/
	public void setModel(AnnualLeaseModel model)		{ super.setModel(model);		}
	public void setPayMonthly(boolean isPayMonthly)	{ getModel().setPayMonthly(isPayMonthly);	}
	public void setBalanceDue(double amount)			{ getModel().setBalanceDue(amount);			}



	/* BEHAVIOR	-----------------------------------------------------	*/
	public boolean isPayMonthly()	{ return getModel().getPayMonthly();				}

	/**
	 *	Calculate the lease payment.
	 *	@return	The fee for this lease based on the width.
	 */
	public double calculateFee(int width)		{
		double fee;

		switch(width)	{
			case 10:
				fee = 800;
				break;
			case 12:
				fee = 900;
				break;
			case 14:
				fee = 1100;
				break;
			case 16:
				fee = 1500;
				break;
			default:
				fee = 0;
		}

		return fee;
	}
	

	/**
	 *	Remove a customer from the data store (by primary key).
	 *	@param	primarykey	The primary key for the customer to find.
	 *	@throws	ObjectNotFoundException
	 */
	public AnnualLease remove()	throws NoSuchEntityException, DAOSysException	{
		AnnualLease al = null;
		if (removeByPrimarykey((AnnualLeasePK) getPrimaryKey()) > 0)	{
			al = this;
		}

		return al;
	}

	/**
	 * Invoke this method to refresh the cached attribute values
	 * from the database.
	 */
	private void load() throws DAOSysException		{
		if (_debug) System.out.println("AL:load()");
		AnnualLeaseDAO dao = null;
		try	{
			dao = getDAO();
			setModel((AnnualLeaseModel)dao.dbLoad(getPrimaryKey()));

		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}


	/**
	 * Invoke this method to save the cached attribute values to the datastore.
	 */
	private void store()	throws DAOSysException		{
		if (_debug) System.out.println("AL:store()");
		AnnualLeaseDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbStore(getModel());
		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}

	/**
	 * Get a data access object for the Boat entity.
	 *	@return	A Boat data access object.
	 */
	private static AnnualLeaseDAO getDAO() throws DAOSysException {
		if (dao == null)	{
			dao = (AnnualLeaseDAO) DAOFactory.getDAO("marina.AnnualLease");
		}

		return dao;
	}



	/* ATTRIBUTES	--------------------------------------------------	*/
	private static final boolean _debug = true;
	

	/** Data access object for an Annual lease.								*/
	private static AnnualLeaseDAO dao;

	/* Primary key is in the parent class.										*/

	/* Model is in the parent class.												*/



	/* REFERENCE ATTRIBUTES	-----------------------------------------	*/


}	/*	End of CLASS:	AnnualLease.java				*/