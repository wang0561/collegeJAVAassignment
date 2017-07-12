package symphony.domain;

import java.util.List;

/**
 * Ticket is a class which store the information of the ticket as an object
 * 
 * @author Bo
 */
public class Ticket {
	

	/** id of the ticket */
	private ID id;
	/** Price of the ticket */
	private double ticketPrice;
	/** VenueConcert information */
	private VenueConcert venue;

	/** List of the concert */
	private List<Concert> concert;

	/**
	 * parameterized constructor
	 * 
	 * @param id
	 * @param ticketPrice
	 * @param Venue
	 * @param ListOfConcert
	 */
	public Ticket(ID id, double ticketPrice, VenueConcert venue, List<Concert> concert) {
		super();
		this.id = id;
		this.ticketPrice = ticketPrice;
		this.venue = venue;
		this.concert = concert;
	}

	// ---------------getters and setters

	/**
	 * getter of the id
	 * 
	 * @return id
	 */
	public ID getId() {
		return id;
	}
	
	/**
	 * setter of the id
	 * 
	 * @param id
	 */
	public void setId(ID id) {
		this.id = id;
	}
	/**
	 * getter of the TicketPrice
	 * 
	 * @return ticketPrice
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * setter of the ticketPrice
	 * 
	 * @param ticketPrice
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	/**
	 * getter of the Venue
	 * 
	 * @return venue
	 */
	public Venue getVenue() {
		return venue;
	}

	/**
	 * setter of the venue
	 * 
	 * @param venue
	 */
	public void setVenue(VenueConcert venue) {
		this.venue = venue;
	}

	/**
	 * getter of List of concerts	 * 
	 * @return ListConcerts
	 */
	public List<Concert> getConcert() {
		return concert;
	}

	/**
	 * setter of the concert
	 * 
	 * @param Listconcert
	 */
	public void setConcert(List<Concert> concert) {
		this.concert = concert;
	}

}
