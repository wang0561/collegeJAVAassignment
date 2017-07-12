/*
 * SlipModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;
import java.sql.Date;


/**
 * SlipModel represents the persistence model for a Slip object.
 * @author Reg
 */
public class SlipModel extends CorePersistenceModel	{
	/**
	 * Creates a new instance of SlipModel
	 */
	public SlipModel() { super();		}
	
	/**
	 * Creates a new instance of SlipModel
	 */
	public SlipModel(String number,
							double length,
							int width,
							BoatPK boatpk)		{
		this(new SlipPK(number), length, width, boatpk);
	}

	/**
	 * Creates a new instance of SlipModel
	 */
	public SlipModel(SlipPK primarykey,
							double length,
							int width)		{
		this(primarykey, length, width, null);
	}
	
	/**
	 * Creates a new instance of SlipModel
	 */
	public SlipModel(SlipPK primarykey,
							double length,
							int width,
							BoatPK boatpk)	{
		super();
		setPrimarykey(primarykey);
		setLength(length);
		setWidth(width);
		setBoatPrimarykey(boatpk);
//		setLeasePrimarykey(leasepk);
	}
	
	/* ACCESSORS	--------------------------------------------------	*/
	public SlipPK getPrimarykey()					{ return (SlipPK) super.getPrimarykey();	}
	public String getNumber()						{ return getPrimarykey().getNumber(); 		}
	public double getLength()						{ return length; 									}
	public int getWidth()							{ return width;	 								}
	public BoatPK getBoatPrimarykey()			{ return boatPrimarykey;						}
//	public LeasePK getLeasePrimarykey()			{ return leasePrimarykey;						}

	/* MODIFIERS	--------------------------------------------------	*/
	public void setPrimarykey(SlipPK pk)			{ super.setPrimarykey(pk);		}
	public void setLength(double length)			{ this.length = length; 		}
	public void setWidth(int width)					{ this.width = width;			}
	public void setBoatPrimarykey(BoatPK pk)		{ boatPrimarykey = pk;			}
//	public void setLeasePrimarykey(LeasePK pk)	{ leasePrimarykey = pk;			}

	
	/* ATTRIBUTES	--------------------------------------------------	*/
	/** Width in feet of this slip.												*/
	private int width;

	/** Length in feet fo this slip.												*/
	private double length;
	
	/** Primary key of boat.														*/
	private BoatPK boatPrimarykey;
	
//	/** Primary key of lease.														*/
//	private LeasePK leasePrimarykey;

}	/*	End of CLASS:	SlipModel.java				*/