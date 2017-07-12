/*
 * FinderException.java
 *
 * Created on July 2, 2005, 11:59 AM
 */

package sql;

/**
 *
 * @author Reg
 */
public class FinderException extends java.sql.SQLException	{
	public FinderException()					{ super(DEFAULT_MESSAGE);			}
	public FinderException(String msg)		{ super(msg);							}

	private final static String DEFAULT_MESSAGE = "Object not found";
}
