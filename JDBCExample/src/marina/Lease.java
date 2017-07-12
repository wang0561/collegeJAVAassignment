/*
 *  @(#)Lease.java
 *
 *
 */

package	marina;

import java.util.ArrayList;
import java.sql.Date;
import sql.DAOSysException;
import sql.NoSuchEntityException;
import sql.DAOFactory;


/**
 * Lease class 
 *		Abstact initial Lease class to extend with abstract method
 *			plus Slip and Customer reference attributes and accessors
 */
public abstract class Lease		{
	/* REMOVERS	-----------------------------------------------------	*/
	/**
	 *	Remove a lease by primary key.
	 *	@param	primarykey	The primary key for the lease to find.
	 *	@throws	ObjectNotFoundException
	 */
	private static int removeByPrimarykey(LeasePK primarykey)
								throws	DAOSysException, NoSuchEntityException	{
		int rc = 0;
		LeaseDAO dao = null;
		dao = getDAO();
		rc = dao.dbRemove(primarykey);
		
		return rc;
	}

	
	/* CONSTRUCTORS	-----------------------------------------------	*/
	/**
	 *	Parameterized constructor.
	 *	@param	startDate	The starting date for this lease.
	 */
	public Lease(String number, Date startDate)			{
		setPrimaryKey(new LeasePK(number));
		setStartDate(startDate);
		setEndDate(null);
		setAmount(0);

		/*	no customer or slip yet						*/
		setCustomer(null);
		setSlip(null);
	}

	/**
	 *	Parameterized constructor.
	 *	@param	startDate	The starting date for this lease.
	 */
	public Lease(LeaseModel model)			{
		setModel(model);

		/*	no customer or slip yet						*/
		setCustomer(null);
		setSlip(null);
	}


	/* ACCESSORS	--------------------------------------------------	*/
	public LeaseModel getModel()		{ return model;									}
	public LeasePK getPrimaryKey()	{ return getModel().getPrimarykey();		}
	public String getNumber()			{ return getPrimaryKey().getNumber();		}
	public double getAmount()			{ return getModel().getAmount(); 			}
	public Date getStartDate()			{ return getModel().getStartDate(); 		}
	public Date getEndDate()			{ return getModel().getEndDate(); 			}

	public Customer getCustomer()		{ return customer;								}
	public Slip getSlip()				{ return slip;										}



	/* MODIFIERS	--------------------------------------------------	*/
	protected void setModel(LeaseModel model)					{ this.model = model;							}
	protected void setPrimaryKey(LeasePK pk)					{ getModel().setPrimarykey(pk);				}
	public void setAmount(double amount)						{ getModel().setAmount(amount);				}
	public void setStartDate(java.sql.Date startDate)		{ getModel().setStartDate(startDate);		}
	public void setEndDate(java.sql.Date endDate)			{ getModel().setEndDate(endDate);			}
	public void setCustomer(Customer customer)	{
		this.customer = customer;
		if (customer != null)	getModel().setCustomerPrimarykey(customer.getPrimaryKey());
	}	

	public void setSlip(Slip slip)					{ 
		this.slip = slip;
		if (slip != null)	getModel().setSlipPrimarykey(slip.getPrimarykey());
	}
		


	/* BEHAVIOR	-----------------------------------------------------	*/
	/**
	 *	Custom method to assign a Lease to a customer and slip.
	 *	@param	customer	The customer that owns this boat.
	 */
	public void assignToCustomer(Customer customer, Slip slip)		{
		if (isDebugging())	System.out.println("L:assignToCustomer("
													+ customer.getPrimaryKey()
													+ ", " + slip.getPrimarykey() + ")"
												);
		try	{
			/* Update the LeaseSlip table with this association			*/
			
			/*	Tell lease to set it's slip to this slip						*/
			setSlip(slip);
			/*	tell lease to set its customer									*/
			setCustomer(customer);
			
		} catch (Exception ex)	{

		}
	}

	public String toString()	{ return this.toString(", ");	}
	public String toString(String sep)	{
		return "number=" + getNumber()
				+ sep + "amount=" + getAmount()
				+ sep + "startDate=" + getStartDate()
				+ sep + "endDate=" + getEndDate()
				+ sep + "customer=" + ((getCustomer() != null) ? getCustomer().getName() : getCustomer())
				+ sep + "slip=" +  ((getSlip() != null) ? getSlip().getNumber() : getSlip())
			;
	}

	/**
	 *	Calculate the fee for this lease.
	 *	Must be overridden by the concrete class.
	 *	@param	length	The length of the boat.
	 */
	public abstract double calculateFee(int length);

	/**
	 *	Remove a customer from the data store (by primary key).
	 *	@param	primarykey	The primary key for the customer to find.
	 *	@throws	ObjectNotFoundException
	 */
	public Lease remove()	throws NoSuchEntityException, DAOSysException	{
		Lease l = null;
		if (removeByPrimarykey(getPrimaryKey()) > 0)	{
			l = this;
		}

		return l;
	}

	/**
	 * Invoke this method to refresh the cached attribute values
	 * from the database.
	 */
	private void load() throws DAOSysException		{
		if (_debug) System.out.println("L:load()");
		LeaseDAO dao = null;
		try	{
			dao = getDAO();
			setModel((LeaseModel)dao.dbLoad(getPrimaryKey()));

		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}


	/**
	 * Invoke this method to save the cached attribute values to the datastore.
	 */
	private void store()	throws DAOSysException		{
		if (_debug) System.out.println("L:store()");
		LeaseDAO dao = null;
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
	private static LeaseDAO getDAO() throws DAOSysException {
		if (dao == null)	{
			dao = (LeaseDAO) DAOFactory.getDAO("marina.Lease");
		}

		return dao;
	}

	
	private static boolean isDebugging()	{ return _debug;	}

	/* ATTRIBUTES	--------------------------------------------------	*/
	private static final boolean _debug = true;
	
	/** Persistence model for a lease.											*/
	private LeaseModel model;

	/** Data access object for a customer.										*/
	private static LeaseDAO dao;

	

	/* REFERENCE ATTRIBUTES	-----------------------------------------	*/
	/** References to the customer												*/
	private Customer customer;
	/** Reference to the slip.														*/
	private Slip slip;
	
}	/*	End of CLASS:	Lease.java				*/