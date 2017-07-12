/*
 * BoatSlipModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;
import java.sql.Date;


/**
 * BoatSlipModel represents the persistence model for a Slip object.
 * @author Reg
 */
public class BoatSlipModel extends CorePersistenceModel	{
	/**
	 * Creates a new instance of BoatSlipModel
	 */
	public BoatSlipModel() { super();		}
	
	/**
	 * Creates a new instance of BoatSlipModel
	 */
	public BoatSlipModel(String boatRegistrationNo,
							String slipNumber)		{
		this(new BoatSlipPK(boatRegistrationNo, slipNumber));
	}

	/**
	 * Creates a new instance of BoatSlipModel
	 */
	public BoatSlipModel(BoatSlipPK primarykey)		{
		super();
		setPrimarykey(primarykey);
	}
	
	/* ACCESSORS	--------------------------------------------------	*/
	public BoatSlipPK getPrimarykey()			{ return (BoatSlipPK) super.getPrimarykey();	}
	public BoatPK getBoatPK()						{ return getPrimarykey().getBoatPK();					}
	public SlipPK getSlipPK()						{ return getPrimarykey().getSlipPK();					}

	/* MODIFIERS	--------------------------------------------------	*/
	public void setPrimarykey(BoatSlipPK pk)		{ super.setPrimarykey(pk);		}
	public void setBoatPK(BoatPK pk)					{ getPrimarykey().setBoatPK(pk);						}
	public void setSlipPK(SlipPK pk)				{ getPrimarykey().setSlipPK(pk);						}

	
	/* ATTRIBUTES	--------------------------------------------------	*/

}	/*	End of CLASS:	BoatSlipModel.java				*/