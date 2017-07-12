/*
 * BoatModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;

/**
 * BoatModel represents the persistence model for a customer object.
 *	The attributes defined in this class will be persisted to the
 *	data store.
 * @author Reg
 */
public class BoatModel extends CorePersistenceModel {
	/**
	 * Creates a new instance of BoatModel
	 */
	public BoatModel() { super();		}

	/**
	 *	Parameterized constructor.
	 *	@param	registrationNo
	 *	@param	length
	 *	@param	manufacturer
	 *	@param	year
	 *	@param	customer
	 */
	public BoatModel(String registrationNo,
					double length,
					String manufacturer,
					int year,
					CustomerPK customerpk,
					SlipPK slippk)		{
		this(new BoatPK(registrationNo), length, manufacturer, year, customerpk, slippk);
	}

	/**
	 * Creates a new instance of BoatModel
	 */
	public BoatModel(BoatPK primarykey,
						double length,
						String manufacturer,
						int year,
						CustomerPK customerpk,
						SlipPK slippk)		{
		super(primarykey);
		setLength(length);
		setManufacturer(manufacturer);
		setYear(year);
		setCustomerPrimarykey(customerpk);
		setSlipPrimarykey(slippk);
	}
	
	
	/* ACCESSORS	--------------------------------------------------	*/
	public BoatPK getPrimarykey()						{ return (BoatPK) super.getPrimarykey();			}
   public String getRegistrationNo()				{ return getPrimarykey().getRegistrationNo();	}
   public double getLength()							{ return length;											}
   public String getManufacturer()					{ return manufacturer;									}
   public int getYear()									{ return year;												}
   public CustomerPK getCustomerPrimarykey()		{ return customerPrimarykey;							}
   public SlipPK getSlipPrimarykey()				{ return slipPrimarykey;								}


	/* MODIFIERS	--------------------------------------------------	*/
	private void setPrimarykey(BoatPK pk)						{ super.setPrimarykey(pk);					}
   public void setLength(double length)						{ this.length = length;						}
   public void setManufacturer(String manufacturer)		{ this.manufacturer = manufacturer; 	}
   public void setYear(int year)									{ this.year = year;  						}
	public void setCustomerPrimarykey(CustomerPK pk)		{ customerPrimarykey = pk;  				}
	public void setSlipPrimarykey(SlipPK pk)					{ slipPrimarykey = pk;						}

	
	/* ATTRIBUTES	--------------------------------------------------	*/
	/** Length of the boat.															*/
   private double length;
   /** Manufacturer of the boat.													*/
	private String manufacturer;
	/** Year of the boat.															*/
	private int year;

	/* REFERENCE ATTRIBUTES	-----------------------------------------	*/
	/** The primary key for a customer											*/
	private CustomerPK customerPrimarykey;

	/** The primary key for a slip.												*/
	private SlipPK slipPrimarykey;

}	/*	End of CLASS:	BoatModel.java				*/
