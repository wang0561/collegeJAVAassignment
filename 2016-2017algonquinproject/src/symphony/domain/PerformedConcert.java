package symphony.domain;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
/**
 * performedConcert class which to store the information of the concert
 * @author  Bo
 * */

public class PerformedConcert extends ScheduledConcert {
	
	
	/**
	 * isConcertPerformed
	 * */
	private boolean performed;

	/**
	 * parameterized constructor
	 * @param id
	 * @param composition
	 * @param conductor
	 * @param soloist
	 * @param venue
	 * @param date
	 * */
	public PerformedConcert(ID id, List<Composition> composition, Conductor conductor, List<Soloist> soloist, Venue venue, Date date) throws ParseException {
		super(id, composition, conductor, soloist,venue, date);
		
		
		//insert date
		 Calendar currentDate = Calendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
		 java.util.Date date1 = sdf.parse(""+currentDate);
		 java.util.Date date2 = sdf.parse(""+date);
		 
		 //check if is performed
		 if (date1.compareTo(date2)>0)
			  performed = true;		 
		 else performed = false;
	}
	/**
	 * @return performed
	 * method to get the value of performed
	 * */
	public boolean isPormaned(){
		return performed;
	}

	
}
