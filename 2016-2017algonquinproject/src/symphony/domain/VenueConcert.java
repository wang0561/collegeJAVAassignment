package symphony.domain;

import java.util.List;

/** VenueConcert is a class which store the information of the concert and inhert the Venue
 * @author Bo*/
public class VenueConcert extends Venue {
	
	
	/**Store a list of concert*/
	private List<Concert> concert;
	/**the single seat*/
	private List<Seat>seat;

	/**parameterized constructor
	 * @param address
	 * @param ListOfPhoneNumber
	 * @param seat
	 * @param ListOfConcert*/
	public VenueConcert( Address address, List<PhoneNumber> phonenumber,List<Seat> seat,List<Concert> concert) {
		super(address, phonenumber);
		
		this.concert= concert;
		this.seat = seat;
	}

	//------------getters and setters
	
	/**getter of the list of concerts
	 * @return ListOfConcert*/
	public List<Concert> getConcert() {
		return concert;
	}
	/**setter of the list of concerts
	 * @param ListOfConcert*/
	public void setConcert(List<Concert> concert) {
		this.concert = concert;
	}

	/**getter of the seat
	 * @return seat*/
	public List<Seat> getSeat() {
		return seat;
	}

	/**setter of the seat
	 * @param seat*/
	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}
	
	
}
