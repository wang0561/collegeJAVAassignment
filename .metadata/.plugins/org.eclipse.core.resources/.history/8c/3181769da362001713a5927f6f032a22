/*
 * CustomerModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;

/**
 * CustomerModel represents the persistence model for a customer object.
 * @author Reg
 */
public class CustomerModel extends CorePersistenceModel	{
	/**
	 * Creates a new instance of CustomerModel
	 */
	public CustomerModel() { super();		}
	
	/**
	 * Creates a new instance of CustomerModel
	 */
	public CustomerModel(String number,
								String name,
								String address,
								String phoneno) {
		this(new CustomerPK(number), name, address, phoneno);
	}

	/**
	 * Creates a new instance of CustomerModel
	 */
	public CustomerModel(CustomerPK primarykey,
								String name,
								String address,
								String phoneno) {
		super();
		setPrimaryKey(primarykey);
		setName(name);
		setAddress(address);
		setPhoneNo(phoneno);
	}
	
	
	/* ACCESSORS	--------------------------------------------------	*/
	public CustomerPK getPrimarykey()	{ return (CustomerPK) super.getPrimarykey();		}
	public String getNumber()				{ return getPrimarykey().getNumber();				}
 	public String getName() 				{ return name;												}
	public String getAddress()				{ return address;											}
	public String getPhoneNo()				{ return phoneNo;											}


	/* MODIFIERS	--------------------------------------------------	*/
	public void setPrimaryKey(CustomerPK pk)	{ super.setPrimarykey(pk);			}
	public void setName(String name)				{ this.name = name;					}
	public void setAddress(String address)		{ this.address = address;			}
	public void setPhoneNo(String phoneNo)		{ this.phoneNo = phoneNo;			}

	
	/* ATTRIBUTES	--------------------------------------------------	*/
	/** Name of this customer.														*/
 	private String name;
 	/** Address for this customer.												*/
 	private String address;
 	/** Phone number for this customer.											*/
 	private String phoneNo;

}
