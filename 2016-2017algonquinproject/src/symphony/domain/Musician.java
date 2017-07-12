package symphony.domain;


/**Musician is a class which is a person and store the information of musician
 * @author Bo
 * 
 * */
public class Musician extends Person{
   /**
    * id of Musician
    * */
	private ID id;
	
	/**
	 * parameterized constructor
	 * @param id
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * */
	public Musician(ID id, Name name, Address address, PhoneNumber phoneNumber) {
		super(id, name, address, phoneNumber);
		//do nothing else
		this.id=id;
	}

}
