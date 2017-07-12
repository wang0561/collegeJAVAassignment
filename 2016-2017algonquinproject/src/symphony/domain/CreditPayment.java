package symphony.domain;

/**
 * Class CreditPayment method which store the credit Card obj and implements the PayMethod
 * @author Bo
 * 
 * */
public class CreditPayment implements PayMethod {
	
	
	
	/**Store the creditCard obj
	 * */
	private CreditCard creditCard;
	

	/**
	 * parameterized constructor
	 * @param creditCard
	 * */
	public CreditPayment(CreditCard creditCard) {
		super();
		this.creditCard = creditCard;
	}


	/**
	 * getter of the creditCard
	 * @return creditCard
	 * */
	public CreditCard getCreditCard() {
		return creditCard;
	}


	/**
	 * setter of the creditCard
	 * @param creditCard
	 * */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}


	/**
	 * inhert the pay method from PayMethod
	 * @param amount
	 * */
	@Override
	public void pay(double amount) {
		//do nothing
	}

}
