/*
 * RemoveException.java
 *
 * Created on July 2, 2005, 12:10 PM
 */

package marina;

/**
 *
 * @author Reg
 */
public class RemoveException extends java.sql.SQLException	{
	public RemoveException()					{ super(DEFAULT_MESSAGE);			}
	public RemoveException(String msg)		{ super(msg);							}

	private final static String DEFAULT_MESSAGE = "Object not found";
}
