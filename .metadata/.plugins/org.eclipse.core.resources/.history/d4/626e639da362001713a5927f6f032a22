/*
 *  @(#)Slip.java
 *
 *
 */

package	marina;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import java.sql.Date;
import sql.*;


/**
 *	Slip class 
 *		with Lease reference
 *		plus leaseAnnualSlip method that does
 *		much processing to create an AnnualLease
 */
public class Slip			{
	/* STATIC PRE-OBJECT BEHAVIOR	-----------------------------------	*/
	/* CREATORS	-----------------------------------------------------	*/
	/**
	 *	Create an instance of a new Slip.
	 *	@return	An instance of a Slip entity.
	 *	@param	number	The Slip number.
	 *	@param	name		The name of the Slip. 
	 *	@param	address	The address for this Slip.
	 *	@param	phoneno	The phone number for this Slip.
	 */
	public static Slip create(String number,
									double length,
									int width,
									Boat boat)
								throws CreateException				{
		if (_debug) System.out.println("Slip.create:" + number);

		SlipModel model = new SlipModel(number, length, width,
										((boat == null) ? null : boat.getPrimaryKey())
										);
		SlipDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbInsert(model);
			/* Initially this Slip has no boats or leases			*/

		} catch (Exception sqlex)	{
			sqlex.printStackTrace(System.out);
			throw new CreateException(sqlex.getMessage());
		}

		Slip s = new Slip(model);
		if (_debug) System.out.println("Slip.create: ---------- completed for slip #" + number);
		return	s;
	}
	
	/* FINDERS	-----------------------------------------------------	*/
	/*	Finder methods are used to search for a particular instance
	 *	or a collection of instances, therefore finders either return
	 *	and instance to the entity, or a collection of instances.
	 */
	/**
	 *	Find a Slip by primary key.
	 *	@return	An instance of a slip entity.
	 *	@param	primarykey	The primary key for the Slip to find.
	 *	@throws	ObjectNotFoundException
	 */
	public static Slip findByPrimarykey(SlipPK primarykey)
								throws FinderException, NoSuchEntityException			{
		if (_debug) System.out.println("Slip.findByPrimarykey(" + primarykey + ")");

		SlipModel model = null;
		Slip slip = null;
		SlipDAO dao = null;
		try	{
			dao = getDAO();
			model = (SlipModel) dao.dbSelectByPrimaryKey(primarykey);
			slip = new Slip(model);
			
		} catch (Exception sqlex)	{
			throw new FinderException(sqlex.getMessage());
		}

		return slip;
	}

	/**
	 *	Find all Slip entities.
	 *	@return	A collection of Slip instances.
	 *	@throws	FinderException
	 * @throws	CreateException
	 */
	public static Collection<Slip> findAll() throws FinderException, CreateException			{
		if (_debug) System.out.println("Slip.findByAll()");
		ArrayList<Slip> listOfSlips = new ArrayList<Slip>();
		SlipDAO dao = null;
	
		try	{
			dao = getDAO();
			Collection c = dao.dbSelectAll();
			Iterator itr = c.iterator();
			while (itr.hasNext())	{
				SlipPK spk = (SlipPK) itr.next();
				try	{
					Slip slip = Slip.findByPrimarykey(spk);
					listOfSlips.add(slip);

				} catch (Exception ex)	{
					System.err.println("Slip: Error processing list <" + ex.toString());
				}
			}

		} catch (Exception sqlex)	{
			throw new CreateException(sqlex.getMessage());
		}

		
		return listOfSlips;
	}
	
	
	/* REMOVERS	-----------------------------------------------------	*/
	/**
	 *	Remove a Slip by primary key.
	 *	@param	primarykey	The primary key for the Slip to find.
	 *	@throws	ObjectNotFoundException
	 */
	private static int removeByPrimarykey(SlipPK primarykey)
								throws	DAOSysException, NoSuchEntityException	{
		if (_debug) System.out.println("Slip.removeByPrimarykey(" + primarykey + ")");
		int rc = 0;
		SlipDAO dao = null;
		dao = getDAO();
		rc = dao.dbRemove(primarykey);
		
		return rc;
	}

	
	/* CONSTRUCTORS	-----------------------------------------------	*/
	/**
	 *	Parameterized constructor
	 *	@param	no
	 *	@param	length
	 *	@param	width
	 */
	public Slip(String no, double length,  int width)		{
		this(new SlipModel(no, length, width, null));
  	}

	/**
	 *	Parameterized constructor
	 *	@param	model	Persistence model for a slip enity.
	 */
	public Slip(SlipModel model)	{
		super();
		setModel(model);
	}


	/* ACCESSORS	--------------------------------------------------	*/
	public SlipModel getModel()			{ return model;								}
	public SlipPK getPrimarykey()			{ return getModel().getPrimarykey();	}

	public String getNumber()				{ return getPrimarykey().getNumber();	}
	public double getLength()				{ return getModel().getLength();			}
	public int getWidth()					{ return getModel().getWidth();			}

	public Boat getBoat()					{ return boat; 								}
	public Lease getLease()					{ return lease; 								}


	/* MODIFIERS	--------------------------------------------------	*/
	public void setModel(SlipModel model)		{ this.model = model;				}
	public void setPrimaryKey(SlipPK pk)		{ getModel().setPrimarykey(pk);	}
	public void setLength(double length)		{ getModel().setLength(length);	}
	public void setWidth(int width) 				{ getModel().setWidth(width); 	}

	private void setBoat(Boat boat)				{ this.boat = boat;					}
	private void setLease(Lease lease)			{ this.lease = lease;				}

	
	/* BEHAVIOR	-----------------------------------------------------	*/
	/**
	 *	Assign a Boat to a Slip
	 *	@param	boat	The boat to assign this slip to.
	 */
	public void assignToBoat(Boat boat) throws DAOSysException		{
		if (isDebugging())	System.out.println("S:assignToBoat:" + boat.getRegistrationNo());
		getModel().setBoatPrimarykey(boat.getPrimaryKey());
		setBoat(boat);
		update();
	}
	
	/**
	 *	Create an annual lease.
	 *	note: slip takes responsibility for much processing
	 */
	public void leaseAnnually(Customer customer,
										Date startDate,
										boolean isPayMonthly)		{
		if (_debug) System.out.println("S:leaseAnnually(" + customer.getPrimaryKey() + ", " + startDate + ", " + isPayMonthly + ")");
		/*	create AnnualLease instance and assign it to lease
		 *	which is an attribute of this slip
		 */
//		lease = new AnnualLease("L1234", startDate, getWidth(), isPayMonthly);
		try	{
			lease = AnnualLease.create("L1234", startDate, getWidth(), isPayMonthly);

			lease.assignToCustomer(customer, this);

//			/*	Tell lease to set it's slip to this slip						*/
//			lease.setSlip(this);
//			/*	tell lease to set its customer									*/
//			lease.setCustomer(customer);

			/*	tell customer to set its lease									*/
			customer.addLease(lease);
			
		} catch (Exception ex)	{
			
		}

	}

	/**
	 *	Lease expired.
	 *	note: slip takes responsibility for much processing
	 */
	public void leaseExpired(Customer customer,
										Date startDate)		{
		if (_debug) System.out.println("S:leaseExpired(" + customer.getPrimaryKey() + ", " + startDate + ")");
		/*	create AnnualLease instance and assign it to lease
		 *	which is an attribute of this slip
		 */
		try	{
			/* Get lease for this customer and the passed start date		*/
//			customer.removeLease();
//			lease.removeCustomer();
//			lease.remove();
			
		} catch (Exception ex)	{
			
		}

	}

	/**
	 *
	 */
	public String toString()	{ return this.toString(", ");		}
	public String toString(String sep)	{
		return "number=" + getNumber()
					+ sep + "width=" + getWidth()
					+ sep + "length=" + getLength()
					+ sep + ((getBoat() != null) ? getBoat().toString(sep + "\t") : getBoat())
					+ sep + ((getLease() != null) ? getLease().toString(sep + "\t") : getLease())
				;
				
	}


	/**
	 *	Remove a Slip from the data store (by primary key).
	 *	@param	primarykey	The primary key for the Slip to find.
	 *	@throws	ObjectNotFoundException
	 */
	public Slip remove()	throws NoSuchEntityException, DAOSysException	{
		Slip c = null;
		if (removeByPrimarykey(getPrimarykey()) > 0)	{
			c = this;
		}

		return c;
	}

	/**
	 * Invoke this method to refresh the cached attribute values
	 * from the database.
	 */
	private void load() throws DAOSysException		{
		if (_debug) System.out.println("S:load()");
		SlipDAO dao = null;
		try	{
			dao = getDAO();
			setModel((SlipModel)dao.dbLoad(getPrimarykey()));

		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}

	private void update()	throws DAOSysException	{ store();	}

	/**
	 * Invoke this method to save the cached attribute values to the datastore.
	 */
	private void store()	throws DAOSysException		{
		if (_debug) System.out.println("S:store()");
		SlipDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbStore(getModel());
		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}

	/**
	 * Get a data access object for the Slip entity.
	 *	@return	A Slip data access object.
	 */
	private static SlipDAO getDAO() throws DAOSysException {
		if (dao == null)	{
			dao = (SlipDAO) DAOFactory.getDAO("marina.Slip");
		}

		return dao;
	}

	
	private static boolean isDebugging()	{ return _debug;		}

	/* ATTRIBUTES	--------------------------------------------------	*/
	private static final boolean _debug = true;
	
	/** Persistence model for a Slip object.								*/
	private SlipModel model;

	/** Data access object for a Slip.										*/
	private static SlipDAO dao;

	/* REFERENCE ATTRIBUTES	-----------------------------------------	*/
	/** Boat assigned to this slip.												*/
	private Boat boat;

	/** Lease assigned to this slip.												*/
	private Lease lease;


}	/*	End of CLASS:	Slip.java							*/