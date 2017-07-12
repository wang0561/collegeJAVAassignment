/*
 *  @(#)Boat.java
 *
 *
 */

package	marina;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import java.sql.SQLException;
import sql.DAOSysException;
import sql.CreateException;
import sql.DAOFactory;
import sql.NoSuchEntityException;
import sql.FinderException;
import java.sql.Date;
import marina.LeasePK;

/**
 * Boat class
 *		with Customer reference variable and methods 
 *		adding Slip reference variable
 */
public class Boat		{
	/* STATIC PRE-OBJECT BEHAVIOR	-----------------------------------	*/
	/* CREATORS	-----------------------------------------------------	*/
	/**
	 *	Create an instance of a new boat.
	 *	@return	An instance of a boat entity.
	 *	@param	number	The customer number.
	 *	@param	name		The name of the customer.
	 *	@param	address	The address for this customer.
	 *	@param	phoneno	The phone number for this customer.
	 */
	public static Boat create(String registrationNo,
									double length,
									String manufacturer,
									int year,
									Customer customer) throws CreateException		{
		if (isDebugging()) System.out.println("Boat.create:" + registrationNo);
		if (customer == null) throw new CreateException ("Invalid Customer <" + customer + ">");

		BoatModel model = new BoatModel(registrationNo, length, manufacturer, year, customer.getPrimaryKey(), null);
		BoatDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbInsert(model);

		} catch (Exception ex)	{
			System.out.println("B: Error inserting boat <" + registrationNo + "> " + ex);
			ex.printStackTrace();
			throw new CreateException(ex.getMessage());
		}

		Boat b = new Boat(model, customer);
		if (isDebugging()) System.out.println("Boat.create: ---------- complete for boat:" + registrationNo);
		return	b;
	}

	
	/* FINDERS	-----------------------------------------------------	*/
	/*	Finder methods are used to search for a particular instance
	 *	or a collection of instances, therefore finders either return
	 *	and instance to the entity, or a collection of instances.
	 */
	/**
	 *	Find a boat by primary key.
	 *	@return	An instance of a boat entity.
	 *	@param	primarykey	The primary key for entity to find.
	 *	@throws	ObjectNotFoundException
	 */
	public static Boat findByPrimarykey(BoatPK primarykey)
								throws FinderException, NoSuchEntityException			{
		return Boat.findByPrimarykey(primarykey, null);
	}

	/**
	 *	Find a boat by primary key.
	 *	@return	An instance of a boat entity.
	 *	@param	primarykey	The primary key for entity to find.
	 *	@param	customer	The customer who owns the boat.
	 *	@throws	ObjectNotFoundException
	 */
	public static Boat findByPrimarykey(BoatPK primarykey, Customer customer)
								throws FinderException, NoSuchEntityException			{
		if (isDebugging()) System.out.println("Boat.findByPrimarykey(" + primarykey + ", " + customer.getPrimaryKey() + ")");

		BoatModel model = null;
		Boat boat = null;
		BoatDAO dao = null;
		try	{
			dao = getDAO();
			model = (BoatModel) dao.dbSelectByPrimaryKey(primarykey);
			if (customer == null)	{
				boat = new Boat(model);
			} else	{
				boat = new Boat(model, customer);
			}
			
			
			
			
		} catch (Exception ex)	{
			if (isDebugging())	{
				System.out.println("Boat.findByPrimarykey(" + primarykey
						  + ", " + customer.getPrimaryKey() + ")"
						  + "\n\t" + ex.toString()
						  );
				ex.printStackTrace(System.out);
			}
			throw new FinderException(ex.getMessage());
		}

		return boat;
	}

	/**
	 *	Find all boat entities for a particular customer.
	 *	@return	A collection of boat instances.
	 *	@throws	FinderException
	 * @throws	CreateException
	 */
	public static Collection<Boat> findByCustomer(Customer customer)
			throws FinderException {
		if (isDebugging()) System.out.println("--------------------"
									+ "Boat.findByCustomer <" + customer.getPrimaryKey() + ">");

		ArrayList<Boat> listOfBoats = new ArrayList<Boat>();
		BoatDAO dao = null;
	
		try	{
			dao = getDAO();
			Collection boats = dao.dbSelectByCustomer(customer.getPrimaryKey());

			Iterator itr = boats.iterator();
			if (isDebugging()) System.out.println("Boats for Customer <" + customer.getPrimaryKey() + ">");

			while (itr.hasNext())	{
				BoatPK bpk = new BoatPK(((BoatPK) itr.next()).getRegistrationNo());
				if (isDebugging()) System.out.println("Boat.findByCustomer(" + customer.getPrimaryKey() + "):"
											+ "processing list-boat:" + bpk);
	
				try	{
					listOfBoats.add(Boat.findByPrimarykey(bpk, customer));
				} catch (Exception ex)	{
					System.out.println("Boat: Error processing list <" + ex.toString() + ">");
					ex.printStackTrace(System.out);
				}

				if (isDebugging()) System.out.println("Boat.findByCustomer(" + customer.getPrimaryKey() + "):"
											+ "Finished for boat:" + bpk);

			}

		} catch (Exception ex)	{
			ex.printStackTrace(System.out);
			throw new FinderException(ex.getMessage());
		}

		if (isDebugging()) System.out.println("--------------------"
									+ "Boat.findByCustomer complete <" + customer.getPrimaryKey() + ">");

		return listOfBoats;
	}

	
	/**
	 *	Find all boat entities.
	 *	@return	A collection of boat instances.
	 *	@throws	FinderException
	 * @throws	CreateException
	 */
	public static Collection<Boat> findAll() throws FinderException, CreateException			{
		ArrayList<Boat> listOfBoats = new ArrayList<Boat>();
		BoatDAO dao = null;
	
		try	{
			dao = getDAO();
			Collection c = dao.dbSelectAll();
			Iterator itr = c.iterator();
			while (itr.hasNext())	{
				BoatPK bpk = (BoatPK) itr.next();
				try	{
					listOfBoats.add(Boat.findByPrimarykey(bpk));
				} catch (Exception ex)	{
					System.err.println("Customer: Error processing list <" + ex.toString());
				}
			}

		} catch (Exception sqlex)	{
			throw new FinderException(sqlex.getMessage());
		}

		return listOfBoats;
	}

	/* REMOVERS	-----------------------------------------------------	*/
	/**
	 *	Remove a boat entity by its primary key.
	 *	@param	primarykey	The primary key for the entity.
	 *	@throws	NoSuchEntityException
	 */
	public static int removeByPrimarykey(BoatPK primarykey)
								throws	NoSuchEntityException, DAOSysException, SQLException	{
//		System.out.println("\tB: removeBypk():" + primarykey);
		BoatDAO dao = getDAO();
		BoatModel m = (BoatModel) dao.dbSelectByPrimaryKey(primarykey);
		Boat b = new Boat(m);
		b.getCustomer().removeBoat(b);
//		System.out.println("\t\tRemoved from customer:" + b);

		return dao.dbRemove(primarykey);
	}

	
	/* CONSTRUCTORS	-----------------------------------------------	*/
	/**
	 *	Parameterized constructor.
	 *	@param	registrationNo
	 *	@param	length 
	 *	@param	manufacturer
	 *	@param	year
	 *	@param	customer
	 */
   public Boat(String registrationNo,
   				double length,
   				String manufacturer,
   				int year,
   				Customer customer)		{
		this(new BoatModel(registrationNo, length, manufacturer, year, customer.getPrimaryKey(), null));
   }

	/**
	 *	Parameterized constructor.
	 *	@param	registrationNo
	 */
   public Boat(BoatModel model)	{
		if (isDebugging()) System.out.println("B: Boat(" + model.getRegistrationNo() + ")");
		setModel(model);

		/*	association between boat and customer done here	*/
		assignToCustomer(model.getCustomerPrimarykey());

		/*	slip is null initially									*/
		setSlip(null);
   }
	
	
	/**
	 *	Parameterized constructor.
	 *	@param	registrationNo
	 */
   public Boat(BoatModel model, Customer customer)	{
		if (isDebugging()) System.out.println("B: Boat(" + model.getRegistrationNo() + ", " + customer.getPrimaryKey() + ")");

		setModel(model);

		/*	association between boat and customer done here	*/
		assignToCustomer(customer);

		/*	slip is null initially									*/
		setSlip(null);
   }


	/* ACCESSORS	--------------------------------------------------	*/
	public BoatModel getModel()				{ return model;													}
	public BoatPK getPrimaryKey()				{ return getModel().getPrimarykey();						}
   public String getRegistrationNo()		{ return getPrimaryKey().getRegistrationNo();			}
   public double getLength()					{ return getModel().getLength();								}
   public String getManufacturer()			{ return getModel().getManufacturer();						}
   public int getYear()							{ return getModel().getYear();								}
   public Customer getCustomer()				{ return customer; /*getCustomer();*/						}
   public Slip getSlip()						{ return slip;														}


	/* MODIFIERS	--------------------------------------------------	*/
	public void setModel(BoatModel m)						{ model = m;										}

	public void setLength(double length)					{
		getModel().setLength(length);
		update();
	}
	
   public void setManufacturer(String manufacturer)	{
		getModel().setManufacturer(manufacturer);
		update();
	}

	public void setYear(int year)								{
		getModel().setYear(year);
		update();
	}

	protected void setCustomer(Customer customer)			{
		this.customer = customer;
		getModel().setCustomerPrimarykey(customer.getPrimaryKey());
//		update();
	}

	protected void setSlip(Slip slip)							{
		this.slip = slip;
		if (slip != null) getModel().setSlipPrimarykey(slip.getPrimarykey());
//		update();
	}

	
	/* BEHAVIOR	-----------------------------------------------------	*/
	/**
	 *	Custom method to assign a Boat to a Customer
	 *	@param	customer	The customer that owns this boat.
	 */
	public void assignToCustomer(CustomerPK pk)		{ 
		if (isDebugging())	System.out.println("B:assignToCustomer(" + pk + ")");
		try	{
			Customer c = Customer.findByPrimarykey(pk);
			assignToCustomer(c);
		} catch (Exception ex)	{

		}
	}
	
	/**
	 *	Custom method to assign a Boat to a Customer
	 *	@param	customer	The customer that owns this boat.
	 */
	public void assignToCustomer(Customer customer)		{ 
		if (isDebugging())	System.out.println("B:assignToCustomer:" + customer.getNumber() + " B:" + getRegistrationNo());
		setCustomer(customer);
		customer.addBoat(this);
		update();
	}

	/**
	 *	Assign a Boat to a Slip
	 *	@param	slip	The slip assigned to this boat.
	 */
	public void assignToSlip(Slip slip) throws DAOSysException		{
		if (isDebugging())	System.out.println("B:assignToSlip:" + slip);

		slip.assignToBoat(this);
//		slip.setBoat(this);
		setSlip(slip);

		//		BoatSlipDAO dao = null;
//		try	{
//			dao = getBSDAO();
//			BoatSlipModel m = new BoatSlipModel(getRegistrationNo(), slip.getNumber());
//			dao.dbInsert(m);
//
//			setSlip(slip);
//			slip.setBoat(this);
//			update();
//
//		} catch (Exception ex)	{
//			throw new DAOSysException(ex.getMessage());
//		}

	}

	/**
	 *	Implemenation of the "object" equals method.  Boat objects are equal
	 *	if their primary key's are equal.
	 *	@return	True if the fields of this primary key object equal the
	 *	contents of the fields from the passed primary key object, otherwise
	 *	false, they are not equal.
	 */
	public boolean equals(Object obj)	{
		return	obj instanceof Boat
			&&	(getRegistrationNo().equals(((Boat) obj).getRegistrationNo())
			);
	}

	/**
	 *	Implementation of the "object"hashCode()" method.
	 * Whenever it is invoked on the same object more than once during
	 * an execution of a Java application, the hashCode method
	 * must consistently return the same integer, provided no information
	 * used in equals comparisons on the object is modified.
	 *	@return	A hash code value for the object.
	 */
	public int hashCode() {
		return	getRegistrationNo().concat(
							Double.toString(getLength())
							+ getManufacturer()
							+ Integer.toString(getYear())
							).hashCode();
	}

	
	/**
	 *	Flush cached attribute values to the datastore.
	 *	Catch and report any errors.
	 */
	public void update()	{
		if (isDebugging()) System.out.println("B:update()");
		try	{
			store();
		} catch (Exception ex)	{
			System.out.println("C: Error in update(), <" + ex.toString() + ">");
		}
	}
	

	/**
	 *	Remove a customer by primary key.
	 *	@param	primarykey	The primary key for the customer to find.
	 *	@return	The boat object removed, else null if not found.
	 *	@throws	ObjectNotFoundException
	 */
	public Boat remove()	throws NoSuchEntityException, DAOSysException, SQLException		{
		if (isDebugging()) System.out.println("B:remove()");
		getCustomer().removeBoat(this);
		Boat b = null;
		if (removeByPrimarykey(getPrimaryKey()) > 0)	{
			b = this;
		}

		return b;
	}
	
	/**
	 *	Convert this boat object to a meaningful string.
	 *	@return	This object as a string.
	 */
	public String toString()		{
		return this.toString(", ");
	}

	/**
	 *	Convert this boat object to a meaningful string.
	 *	@return	This object as a string.
	 */
	public String toString(String sep)		{
		return "registrationNo=" + getRegistrationNo()
			+ sep + "length=" + getLength()
			+ sep + "manufacturer=" + getManufacturer()
			+ sep + "year=" + getYear()
			+ sep + "customer=" + ((getCustomer() == null) ? null : getCustomer().getName())
			+ sep + "slip=" + ((getSlip() == null) ? null : getSlip().getNumber())
//			+ sep + "slipNumber=" + getSlip().getNumber();
			;
	}



	
	/* HELPERS	-----------------------------------------------------	*/
	/**
	 * Invoke this method to refresh the cached attribute values
	 * from the database.
	 */
	private void load() throws DAOSysException		{
//		if (isDebugging()) System.out.println("B:load()");
		BoatDAO dao = null;
		try	{
			dao = getDAO();
			setModel((BoatModel)dao.dbLoad(getPrimaryKey()));

		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}

//	static int count = 0;

	/**
	 * Invoke this method to save the cached attribute values to the datastore.
	 */
	private void store()	throws DAOSysException		{
		if (isDebugging())	{
			System.out.println("B:store():" + toString());	
		}

		BoatDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbStore(getModel());

		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
		
//		if (isDebugging())	{
//			if (count > 6)	{
//				try	{
//					throw new Exception("HALT HERE");
//				} catch (Exception ex)	{
//					ex.printStackTrace(System.out);
//					System.exit(1);
//				}
//			}
//			count++;
//		}
	}
	
	/**
	 * Get a data access object for the Boat entity.
	 *	@return	A Boat data access object.
	 */
	private static BoatSlipDAO getBSDAO() throws DAOSysException {
		if (bsdao == null)	{
			bsdao = (BoatSlipDAO) DAOFactory.getDAO("marina.BoatSlip");
		}

		return bsdao;
	}
	
	/**
	 * Get a data access object for the Boat entity.
	 *	@return	A Boat data access object.
	 */
	private static BoatDAO getDAO() throws DAOSysException {
		if (dao == null)	{
			dao = (BoatDAO) DAOFactory.getDAO("marina.Boat");
		}

		return dao;
	}

	public static boolean isDebugging()	{ return _debug;			}
	
	/* ATTRIBUTES	--------------------------------------------------	*/
	private static final boolean _debug = true;
	
	/** Persistence model for a boat object.									*/
	private BoatModel model;

	/** Data access object for boat entities.									*/
	private static BoatDAO dao;

	/** Data access object for boat entities.									*/
	private static BoatSlipDAO bsdao;

	
	/* REFERENCE ATTRIBUTES	-----------------------------------------	*/
	/** Reference to the customer object for this boat.					*/
	private Customer customer;
	/** Reference variable points to Slip for this boat					*/
	private Slip slip;

}	/*	End of CLASS:	Boat.java			*/