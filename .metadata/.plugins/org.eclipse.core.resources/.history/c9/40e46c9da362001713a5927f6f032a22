/*
 *  @(#)Customer.java
 *
 *
 */

package marina;

import sql.*;

import java.sql.SQLException;
import java.util.*;

import sql.CreateException;
import sql.FinderException;
import sql.NoSuchEntityException;

/**
 * Customer class
 *		with Boat reference attribute and accessors
 *		and Lease reference attribute and accessors
 */
public class Customer		{
	/* STATIC PRE-OBJECT BEHAVIOR	-----------------------------------	*/
	/* CREATORS	-----------------------------------------------------	*/
	/**
	 *	Create an instance of a new customer.
	 *	@return	An instance of a customer entity.
	 *	@param	number	The customer number.
	 *	@param	name		The name of the customer. 
	 *	@param	address	The address for this customer.
	 *	@param	phoneno	The phone number for this customer.
	 */
	public static Customer create(String number,
											String name,
											String address,
											String phoneno)
								throws CreateException				{
		if (_debug) System.out.println("C:create:" + number);

		CustomerModel model = new CustomerModel(number, name, address, phoneno);
		CustomerDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbInsert(model);
			/* Initially this customer has no boats or leases			*/

		} catch (Exception sqlex)	{
			throw new CreateException(sqlex.getMessage());
		}

		return	new Customer(model);
	}
	
	/* FINDERS	-----------------------------------------------------	*/
	/*	Finder methods are used to search for a particular instance
	 *	or a collection of instances, therefore finders either return
	 *	and instance to the entity, or a collection of instances.
	 */
	/**
	 *	Find a customer by primary key.
	 *	@return	An instance of a customer entity.
	 *	@param	primarykey	The primary key for the customer to find.
	 *	@throws	ObjectNotFoundException
	 */
	public static Customer findByPrimarykey(CustomerPK primarykey)
								throws FinderException, NoSuchEntityException			{
		if (_debug) System.out.println("C:findByPrimarykey(" + primarykey + ")");

		CustomerModel model = null;
		Customer customer = null;
		CustomerDAO dao = null;
		try	{
			dao = getDAO();
			model = (CustomerModel) dao.dbSelectByPrimaryKey(primarykey);
			customer = new Customer(model);

//			/* Add boat references for this customer.				*/
//			customer.setBoats( ((ArrayList<Boat>) Boat.findByCustomer(customer)) );

			/*	Add leasse references for this customer.			*/

			
			
		} catch (Exception sqlex)	{
			throw new FinderException(sqlex.getMessage());
		}

		return customer;
	}

	/**
	 *	Find all customer entities.
	 *	@return	A collection of customer instances.
	 *	@throws	FinderException
	 * @throws	CreateException
	 */
	public static Collection<Customer> findAll() throws FinderException, CreateException			{
		ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
		CustomerDAO dao = null;
	
		try	{
			dao = getDAO();
			Collection c = dao.dbSelectAll();
			Iterator itr = c.iterator();
			while (itr.hasNext())	{
				CustomerPK cpk = (CustomerPK) itr.next();
				try	{
					Customer customer = Customer.findByPrimarykey(cpk);
//					/* Add boat references for this customer.				*/
//					customer.setBoats(((ArrayList<Boat>) Boat.findByCustomer(customer)));

//					/* Add leases for this customer							*/
					
					
					
					/* Add this customer to the list.						*/
					listOfCustomers.add(customer);

				} catch (Exception ex)	{
					System.err.println("Customer: Error processing list <" + ex.toString());
				}
			}

		} catch (Exception sqlex)	{
			throw new CreateException(sqlex.getMessage());
		}

		
		return listOfCustomers;
	}
	
	
	/* REMOVERS	-----------------------------------------------------	*/
	/**
	 *	Remove a customer by primary key.
	 *	@param	primarykey	The primary key for the customer to find.
	 *	@throws	ObjectNotFoundException
	 */
	private static int removeByPrimarykey(CustomerPK primarykey)
								throws	DAOSysException, NoSuchEntityException	{
		int rc = 0;
		CustomerDAO dao = null;
		dao = getDAO();
		rc = dao.dbRemove(primarykey);
		
		return rc;
	}

	
	/* CONSTRUCTORS	-----------------------------------------------	*/
	/**
	 *	Default constructor
	 */
	private Customer()	{ super();		}

	/**
	 *	Parameterized constructor.
	 *	@param	name
	 *	@param	address
	 *	@param	phoneno
	 */
	private Customer(String number, String name, String address, String phoneno)	{
		this(new CustomerModel(number, name, address, phoneno));
	}

	/**
	 *	Parameterized constructor.
	 *	@param	model	The persistence model for a customer object.
	 */
	private Customer(CustomerModel model)	{
		setModel(model);

		/*	initially no Boat and no leases, but we do have empty collections		*/
		setListOfBoats(new ArrayList<Boat>());
		setListOfLeases(new ArrayList<Lease>());
	}


	/* ACCESSORS	--------------------------------------------------	*/
	public CustomerModel getModel()				{ return model;												}
	public CustomerPK getPrimaryKey()			{ return getModel().getPrimarykey();					}
	public String getNumber()						{ return getModel().getPrimarykey().getNumber(); 	}
 	public String getName()							{ return getModel().getName();							}
	public String getAddress()						{ return getModel().getAddress();						}
	public String getPhoneNo()						{ return getModel().getPhoneNo();						}
	public ArrayList<Boat>	getListOfBoats()	{ return listOfBoats;										}
	public ArrayList<Lease>	getListOfLeases()	{ return listOfLeases;										}

	private ArrayList<Boat> getBoats()	{
		ArrayList<Boat> list = new ArrayList<Boat>();
		try	{
			list = (ArrayList<Boat>) Boat.findByCustomer(this);
		} catch (Exception ex)	{
		}
		return list;
	}

	private ArrayList<Lease> getLeases(){
		ArrayList<Lease> list = new ArrayList<Lease>();
//		list = Lease.findByCustomer(this);
		return list;
	}

	
	/* MODIFIERS	--------------------------------------------------	*/
	private void setModel(CustomerModel model)	{ this.model = model;								}

	private void setPrimaryKey(CustomerPK pk)	{ getModel().setPrimaryKey(pk);						}
	public void setName(String name)				{
		getModel().setName(name);
		update();
	}
	public void setAddress(String address)		{
		getModel().setAddress(address);
		update();
	}
	public void setPhoneNo(String phoneNo)		{
		getModel().setPhoneNo(phoneNo);
		update();
	}

	
	private void setListOfBoats(ArrayList<Boat> boats)		{ listOfBoats = boats;						}
	private void setListOfLeases(ArrayList<Lease> leases)	{ listOfLeases = leases;					}


	/* BEHAVIOR	-----------------------------------------------------	*/
	/**
	 *	Implemenation of the "object" equals method.  Customers objects are equal
	 *	if their primary key's are equal.
	 *	@return	True if the fields of this primary key object equal the
	 *	contents of the fields from the passed primary key object, otherwise
	 *	false, they are not equal.
	 */
	public boolean equals(Object obj)	{
		return	obj instanceof Customer
			&&	(getNumber().equals(((Customer) obj).getNumber())
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
		return	getNumber().concat(
								getName()
								+ getAddress()
								+ getPhoneNo()
							).hashCode();
	}

	/**
	 *	Flush cached attribute values to the datastore.
	 *	Catch and report any errors.
	 */
	public void update()	{
		if (_debug) System.out.println("C:update()");
		try	{
			store();
		} catch (Exception ex)	{
			System.out.println("C: Error in update(), <" + ex.toString() + ">");
		}
	}

	
	public String toString()	{ return this.toString(", ");				}
	public String toString(String sep)	{
		return "number=" + getNumber()
				+ sep + "name=" + getName()
				+ sep + "address=" + getAddress()
				+ sep + "phoneNo=" + getPhoneNo()
				+ sep + "listOfBoats=" + getListOfBoats()
				+ sep + "listOfLeases=" + getListOfLeases()
				+ sep + "boats=" + getBoats()
				+ sep + "leases=" + getLeases()
			;
	}

	/**
	 *	Get an iterator to the list of boats for this customer.
	 */
	public Iterator boats()					{ return getBoats().iterator();								}

	/**
	 *	Get an iterator to the list of leases for this customer.
	 */
	public Iterator leases()				{ return getLeases().iterator();								}
	
	/**
	 *	Add a boat to this customer.
	 */
	public void addBoat(Boat boat)	{
		if (!getListOfBoats().contains(boat))	{
			getListOfBoats().add(boat);
		}
	}

	/**
	 *	Remove a boat from this customer
	 */
	public void removeBoat(Boat boat)	{
		getBoats().remove(boat);
	}

	/**
	 *	Add a lease to this customer
	 */
	public void addLease(Lease lease)	{
		if (!getLeases().contains(lease))	{
			getLeases().add(lease);
		}
	}

	/**
	 *	Remove a lease from this customer
	 */
	public void removeLease(Lease lease)	{
		getLeases().remove(lease);
	}
	
	

	/**
	 *	Remove a customer from the data store (by primary key).
	 *	@param	primarykey	The primary key for the customer to find.
	 *	@throws	ObjectNotFoundException
	 */
	public Customer remove()	throws NoSuchEntityException, DAOSysException	{
		Customer c = null;
		if (removeByPrimarykey(getPrimaryKey()) > 0)	{
			c = this;
		}

		return c;
	}

	/**
	 * Invoke this method to refresh the cached attribute values
	 * from the database.
	 */
	private void load() throws DAOSysException		{
		if (_debug) System.out.println("C:load()");
		CustomerDAO dao = null;
		try	{
			dao = getDAO();
			setModel((CustomerModel)dao.dbLoad(getPrimaryKey()));

		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}


	/**
	 * Invoke this method to save the cached attribute values to the datastore.
	 */
	private void store()	throws DAOSysException		{
		if (_debug) System.out.println("C:store()");
		CustomerDAO dao = null;
		try	{
			dao = getDAO();
			dao.dbStore(getModel());
		} catch (Exception ex)	{
			throw new DAOSysException(ex.getMessage());
		}
	}

	/**
	 * Get a data access object for the Customer entity.
	 *	@return	A Customer data access object.
	 */
	private static CustomerDAO getDAO() throws DAOSysException {
		if (dao == null)	{
			dao = (CustomerDAO) DAOFactory.getDAO("marina.Customer");
		}

		return dao;
	}

	
	

	/* ATTRIBUTES	--------------------------------------------------	*/
	private static final boolean _debug = false;
	
	/** Persistence model for a customer object.								*/
	private CustomerModel model;

	/** Data access object for a customer.										*/
	private static CustomerDAO dao;

	
	/* REFERENCE ATTRIBUTES	-----------------------------------------	*/
 	/** Boat for this customer.													*/
	private ArrayList<Boat> listOfBoats;

	/** Lease for this customer.													*/
	private ArrayList<Lease> listOfLeases;


}	/*	End of CLASS:	Customer.java				*/