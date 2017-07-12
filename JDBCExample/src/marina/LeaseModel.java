/*
 * LeaseModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;
import java.sql.Date;


/**
 * LeaseModel represents the persistence model for a Lease object.
 * @author Reg
 */
public class LeaseModel extends CorePersistenceModel	{
	/**
	 * Creates a new instance of LeaseModel
	 */
	public LeaseModel() { super();		}

	/**
	 * Creates a new instance of AnnualLeaseModel
	 */
	public LeaseModel(String number, Date startdate) { this(number, 0, startdate, null, null, null);		}
	
	/**
	 * Creates a new instance of LeaseModel
	 */
	public LeaseModel(String number,
							double amount,
							Date startdate,
							Date enddate,
							CustomerPK customerPK,
							SlipPK slipPK)		{
		this(new LeasePK(number), amount, startdate, enddate, customerPK, slipPK);
	}

	/**
	 * Creates a new instance of LeaseModel
	 */
	public LeaseModel(LeasePK primarykey,
							double amount,
							Date startdate,
							Date enddate,
							CustomerPK customerPK,
							SlipPK slipPK)		{
		super();
		setPrimarykey(primarykey);
		setAmount(amount);
		setStartDate(startdate);
		setEndDate(enddate);
		setCustomerPrimarykey(customerPK);
		setSlipPrimarykey(slipPK);
	}
	
	
	/* ACCESSORS	--------------------------------------------------	*/
	public LeasePK getPrimarykey()				{ return (LeasePK) super.getPrimarykey();	}
	public String getNumber()						{ return getPrimarykey().getNumber(); 		}
	public double getAmount()						{ return amount; 									}
	public Date getStartDate()						{ return startDate; 								}
	public Date getEndDate()						{ return endDate; 								}
	public CustomerPK getCustomerPrimarykey()	{ return customerPrimarykey; 					}
	public SlipPK getSlipPrimarykey()			{ return slipPrimarykey; 						}


	/* MODIFIERS	--------------------------------------------------	*/
	public void setPrimarykey(LeasePK pk)					{ super.setPrimarykey(pk);		}
	public void setAmount(double amount)					{ this.amount = amount; 		}
	public void setStartDate(Date startDate)				{ this.startDate = startDate; }
	public void setEndDate(Date endDate)					{ this.endDate = endDate; 		}
	public void setCustomerPrimarykey(CustomerPK pk)	{ customerPrimarykey = pk; 	}	
	public void setSlipPrimarykey(SlipPK pk)				{ slipPrimarykey = pk; 			}

	
	/* ATTRIBUTES	--------------------------------------------------	*/
	/** Dollar amount for this lease.											*/
	private double amount;
	/** Starting date for this lease.											*/
	private Date startDate;
	/** Ending date for this lease.												*/
	private Date endDate;

	/** Customer																		*/
	private CustomerPK customerPrimarykey;
	
	/** Slip																				*/
	private SlipPK slipPrimarykey;
	

}	/*	End of CLASS:	LeaseModel.java				*/