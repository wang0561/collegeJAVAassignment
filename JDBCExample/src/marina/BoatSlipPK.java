/*
 *  @(#)BoatSlipPK.java   1.1 2002/11/15
 *
 *  (c) Copyright 2001, 2002 by Dyer Consulting
 *      Quebec, Canada
 *      All rights reserved.
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 */

package	marina;

/**
 * BoatSlipPK is the primary key class for a Slip entity.
 * @author    R. Dyer
 * @version   1.0.0 May 2002
 */
public class BoatSlipPK implements java.io.Serializable	{
	/**
	 *	Default constructor.
	 */
	public BoatSlipPK()	{}

	/**
	 *	Constructor to build a primary key from an Number.
	 *	@param	number	The customer number.
	 */
	public BoatSlipPK(String boatRegistrationNo, String slipNumber)	{
		this(new BoatPK(boatRegistrationNo), new SlipPK(slipNumber));
	}
	
	/**
	 *	Parameterized constuctor.
	 *	@param	boatPK
	 * @param	slipPK
	 */
	public BoatSlipPK(BoatPK boatpk, SlipPK slippk)	{
		setBoatPK(boatpk);
		setSlipPK(slippk);
	}


	/* ACCESSORS	--------------------------------------------------	*/
	public BoatPK getBoatPK()	{ return boatPK;		}
	public SlipPK getSlipPK()	{ return slipPK;		}

	
	/* MODIFIERS	--------------------------------------------------	*/
	public void setBoatPK(BoatPK pk)		{ boatPK = pk;		}
	public void setSlipPK(SlipPK pk)		{ slipPK = pk;		}


	/* BEHAVIOR	-----------------------------------------------------	*/
	/**
	 *	Convert this primary key object into a meaningful string.
	 *	@return	This object as a string.
	 */
	public String toString()	{ return	getBoatPK() + ":" + getSlipPK();		}


	/**
	 *	Implemenation of the "object" equals method.
	 *	@return	True if the fields of this primary key object equal the
	 *	contents of the fields from the passed primary key object, otherwise
	 *	false, they are not equal.
	 */
	public boolean equals(Object obj)	{
		return	obj instanceof BoatSlipPK
			&&	getBoatPK().equals(((BoatSlipPK) obj).getBoatPK())
			&&	getSlipPK().equals(((BoatSlipPK) obj).getSlipPK())
			;
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
		return	getBoatPK().hashCode() + getSlipPK().hashCode();
	}



	/*	Slip Entity PRIMARY KEY FIELDS ------------------------------	*/
	/** Boat registration number.													*/
	private BoatPK boatPK;

	/** Slip number.																	*/
	private SlipPK slipPK;

}	/*	End of Class:	BoatSlipPK.java				*/