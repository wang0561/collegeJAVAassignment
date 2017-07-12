/*
 * LeasedSlipModel.java
 *
 * Created on July 2, 2005, 2:13 PM
 */

package marina;

import sql.CorePersistenceModel;
import java.sql.Date;


/**
 * LeasedSlipModel represents the persistence model for a Slip object.
 * @author Reg
 */
public class LeasedSlipModel extends CorePersistenceModel	{
	/**
	 * Creates a new instance of LeasedSlipModel
	 */
	public LeasedSlipModel() { super();		}
	
	/**
	 * Creates a new instance of LeasedSlipModel
	 */
	public LeasedSlipModel(String boatRegistrationNo,
							String slipNumber)		{
		this(new LeasedSlipPK(boatRegistrationNo, slipNumber));
	}

	/**
	 * Creates a new instance of LeasedSlipModel
	 */
	public LeasedSlipModel(LeasedSlipPK primarykey)		{
		super();
		setPrimarykey(primarykey);
	}
	
	/* ACCESSORS	--------------------------------------------------	*/
	public LeasedSlipPK getPrimarykey()			{ return (LeasedSlipPK) super.getPrimarykey();		}
	public LeasePK getLeasePK()					{ return getPrimarykey().getLeasePK();					}
	public SlipPK getSlipPK()						{ return getPrimarykey().getSlipPK();					}

	/* MODIFIERS	--------------------------------------------------	*/
	public void setPrimarykey(LeasedSlipPK pk)	{ super.setPrimarykey(pk);								}
	public void setLeasePK(LeasePK pk)				{ getPrimarykey().setLeasePK(pk);					}
	public void setSlipPK(SlipPK pk)					{ getPrimarykey().setSlipPK(pk);						}

	
	/* ATTRIBUTES	--------------------------------------------------	*/

}	/*	End of CLASS:	LeasedSlipModel.java				*/