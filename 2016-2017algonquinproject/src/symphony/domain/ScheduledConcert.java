package symphony.domain;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

/**
 * Class SchedualedConcert is a class that store the information of the Schedualed Concert whic inhert from Concert
 * @author Bo
 * */
public class ScheduledConcert extends Concert {

	
	/**
	 * store the information of the conductor by using conductor class
	 * */
	public Conductor conductor;

	/**store the information of the Venue
	 * */
	public Venue venue;
	
	/**store the information of the date*/
	public Date date;
	
	/**store the information of the soloist*/
	public List<Soloist> soloist;

	/**
	 * parameterized constructor
	 * @param ConcertBuilder
	 * */
	public ScheduledConcert(ConcertBuilder builder) {
		this.id = builder.id;
		this.composition = builder.composition;
		this.conductor = builder.conductor;
		this.venue = builder.venue;
		this.date = builder.date;
		this.soloist = builder.soloist;
	}

	/**
	 * parameterized constructor
	 * @param id
	 * @param composition
	 * @param conductor
	 * @param soloist
	 * @param venue
	 * @param date
	 * @throws ParseException
	 * */
	public ScheduledConcert(ID id, List<Composition> composition, Conductor conductor, List<Soloist> soloist,
			Venue venue, Date date) throws ParseException {

		this.id = id;
		this.composition = composition;
		this.conductor = conductor;
		this.venue = venue;
		this.date = date;
		this.soloist = soloist;
	}

	
	//------------getters and setters
	/**
	 * getter of the conductor
	 * @return conductor
	 * */
	public Conductor getConductor() {
		return conductor;
	}

	/**
	 * setter of the conductor
	 * @param conductor
	 * */
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	/**
	 * getter of the Venue
	 * @return Venue
	 * */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * setter of the venue
	 * @param venue
	 * */
	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	/**
	 * getter of the date
	 * @return date
	 * */
	public Date getDate() {
		return date;
	}

	/**
	 * setter of the date
	 * @param date
	 * */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * getter of the conductor
	 * @return soloist
	 * */
	public List<Soloist> getSoloist() {
		return soloist;
	}

	/**
	 * setter of the soloist
	 * @param soloist
	 * */
	public void setSoloist(List<Soloist> soloist) {
		this.soloist = soloist;
	}

}
