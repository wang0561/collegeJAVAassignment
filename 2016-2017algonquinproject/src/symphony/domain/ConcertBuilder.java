
package symphony.domain;//package for the project

import java.sql.Date;

/**the builder for the concert model
	 * @author Bo
	 * */

import java.text.ParseException;

import java.util.List;
/**
 * This is a class for build a builder pattern for concert.
 * @author Bo
 * @version 1.0
 * 
 * 
 * */
public class ConcertBuilder{
	
			
	/**ID of concert*/
	protected ID id;
		
	 /**ID of concert*/
	protected List<Composition>  composition;
			 			 
	 /**Date of the start date*/
	 protected Date date;
			 
	 /**the venuePlace which using the Place class*/
	protected Venue venue;
			 
	 /**the conductor which using the Conductor class*/
	protected Conductor conductor;
			 
	 /**Date of the start date*/
	protected List<Soloist> soloist;	

			 /**parameterized constructor
			  * @param concertId*/
	    public ConcertBuilder(ID concertId ) {
	      this.id = concertId;
	    }
	    
	    /**
	     * builder of conductor
	     * @param conductor
	     * @return ConcerBuilder
	     * */
	    public ConcertBuilder conductor(Conductor conductor) {
		      this.conductor =  conductor;
		      return this;
		    }
	    
	    
	    /**
	     * builder of the start Date
	     * @param date
	     * @return ConcertBuilder
	     * @throws ParseException
	     * 
	     * */
	    public ConcertBuilder date(Date date) {
	    	
			this.date = date;
			  return this;
	    }


	  
	    /**
	     * builder of the venue
	     * @param venue
	     * @return ConcertBuilder
	     * */
	    public ConcertBuilder venue(Venue venue) {
	      this.venue = venue;
	      return this;
	    }
	    
	    
	    /**
	     * builder of the venue
	     * @param venue
	     * @return ConcertBuilder
	     * */
	    public ConcertBuilder soloist(List<Soloist> soloist) {
	      this.soloist = soloist;
	      return this;
	    }
	    
	   
		    
	    /**
	     * the build method for the builders
	     * @return Concert
	     * */

	    public ScheduledConcert build() {
	      return new ScheduledConcert(this);
	    }

	  }


