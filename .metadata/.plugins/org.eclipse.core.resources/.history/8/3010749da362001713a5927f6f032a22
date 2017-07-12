/*
 * AnnualLeaseModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;
import java.sql.Date;


/**
 * AnnualLeaseModel represents the persistence model for a Lease object.
 * @author Reg
 */
public class AnnualLeaseModel extends LeaseModel	{
	/**
	 * Creates a new instance of AnnualLeaseModel
	 */
	public AnnualLeaseModel() { super();		}

	/**
	 * Creates a new instance of AnnualLeaseModel
	 */
	public AnnualLeaseModel(String number, Date startdate) { super(number, startdate);		}
	
	/**
	 * Creates a new instance of AnnualLeaseModel
	 */
	public AnnualLeaseModel(String number,
							double amount,
							Date startdate,
							Date enddate,
							CustomerPK customerPK,
							SlipPK slipPK,
							double balanceDue,
							boolean paymonthly)		{
		this(new AnnualLeasePK(number), amount, startdate, enddate, customerPK, slipPK, balanceDue, paymonthly);
	}

	/**
	 * Creates a new instance of AnnualLeaseModel
	 */
	public AnnualLeaseModel(AnnualLeasePK primarykey,
							double amount,
							Date startdate,
							Date enddate,
							CustomerPK customerPK,
							SlipPK slipPK,
							double balanceDue,
							boolean paymonthly)		{
		super(primarykey, amount, startdate, enddate, customerPK, slipPK);
		setBalanceDue(balanceDue);
		setPayMonthly(paymonthly);
	}
	
	
	/* ACCESSORS	--------------------------------------------------	*/
	public AnnualLeasePK getPrimarykey()		{ return (AnnualLeasePK) super.getPrimarykey();	}
	public double getBalanceDue()					{ return balanceDue;										}
	public boolean getPayMonthly()				{ return payMonthly;										}


	/* MODIFIERS	--------------------------------------------------	*/
	public void setPrimarykey(AnnualLeasePK pk)			{ super.setPrimarykey(pk);		}
	public void setBalanceDue(double amount)				{ balanceDue = amount;			}
	public void setPayMonthly(boolean paymonthly)		{ payMonthly = paymonthly;		}

	
	/* ATTRIBUTES	--------------------------------------------------	*/
	/** Dollar amount for this lease.											*/
	private double balanceDue;
	/** Monthly payment flag.														*/
	private boolean payMonthly;

}	/*	End of CLASS:	AnnualLeaseModel.java				*/