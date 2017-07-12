package symphony.domain;

/**
 * Class for store the debitCard information
 * @author Bo
 * */

public class DebitCard  {

	
	/**
	 * name of the user
	 * */
	 	private Name name;
	 
	 	/**
	 	 * number of the accountNumber
	 	 * */
	private long accountNO;
	
	
	/**
	 * parameterized constructor
	 * @param name
	 * @param accountNum
	 * */
	public DebitCard(Name name, long accountNO) {
		super();
		this.name = name;
		this.accountNO = accountNO;
	}

	//-------------------getters and setters
	/**
	 * getter of the name
	 * @return name
	 * */
	public Name getName() {
		return name;
	}

	/**
	 * setter of the name
	 * @param name 
	 * */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * getter of accountNum
	 * @return accountNo
	 * */
	public long getAccountNO() {
		return accountNO;
	}

	/**
	 * setter of the accountNO
	 * @param accountNO
	 * */
	public void setAccountNO(long accountNO) {
		this.accountNO = accountNO;
	}

	
}
