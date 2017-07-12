/**
* @version 1.0
* @(#)ActivityDate.java 1.0 2017/03/19
* this is a part of project for CST8288_010 OOP with Design Patterns;
* */
package symphony.domain;//package for this project





import java.util.ArrayList;
import java.util.Date;

/**
 * The concertSeason which is an arraylist contain the season information
 * 
 * @author Bo
 * @version 1.0
 */
public class ConcertSeason extends ArrayList<Concert> {

	

	/**stores the startDate*/
	private Date openDate;

	/** stores the length of the concertSeason*/
	private int length;

	/**default constructor*/
	private ConcertSeason() {
	}

	/**getter of the start date
	 * @return startDate*/
	public Date getStartDate() {
		return openDate;
	}
	
	/**setter of the startDate
	 * @param date
	 */
	public void setOpenDate(Date date)  {

		this.openDate = date;
	}

	/**
	 * getter of the length
	 * @return length
	 * */
	public int getLength() {
		return length;
	}

	/**setter of the length
	 * @param length
	 **/
	public void setLength(int length) {
		this.length = length;
	}

	/**add the concert in the arraylsit
	 * @param concert
	 * @return add concert*/
	public boolean add(Concert concert) {
		return super.add(concert);
	}

	/**
	 * getter of the concertSeason
	 * @return ConcertSeason()
	 * */
	public static ConcertSeason getConcertSeason() {

		return new ConcertSeason();
	}

}