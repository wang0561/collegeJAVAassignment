/*
 *  @(#)CorePersistenceModel.java   1.0 02/08/20
 *
 *  (c) Copyright 2002, 2003 by Dyer Consulting
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
 *
 */

package	sql;

/**
 * CoreModel is a class that encapsulates the persistent data structure
 * of an object for communication between the CoreObject and the CoreDAO object.
 *	Although its contents is sparse represents a useful design for implementation
 * with most persistent objects.
 * @author    R. Dyer
 * @version   1.0.0 Aug 2002
 */
public class CorePersistenceModel {
	/**
	 *	Default constructor.
	 */
	public CorePersistenceModel()	{}

	/**
	 *	Parameterized constructor.
	 *	@param	primarykey	The primary key value (obect) for this object.
	 */
	public CorePersistenceModel(Object primarykey)	{ setPrimarykey(primarykey);		}

	/**
	 *	Convert the primary key to a string.
	 *	@return	Primary key as a string.
	 */
	public String toString()	{ return	getPrimarykey().toString();		}

	public Object getPrimarykey()	{ return primarykey;		}
	public void setPrimarykey(Object primarykey)	{ this.primarykey = primarykey;		}


	/*	Core ATTRIBUTES ----------------------------------------------	*/
	/** The primary key.																*/
	private Object primarykey;

}	/*	End of Class:	CorePersistenceModel.java						*/