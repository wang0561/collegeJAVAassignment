package symphony.domain;

/**
 * DebitPayment class which store the debitCard obj and implements payMethod
 * @author Bo
 * 
 * */
public class DebitPayment implements PayMethod {
	

	
	/**
	 * debutCard obj
	 * */
	private DebitCard debitCard;
	
	/**
	 * parameterized constructor
	 * @param debitCard
	 * */
	public DebitPayment(DebitCard debitCard) {
		super();
		this.debitCard = debitCard;
	}


	
	//---------------------------getters and setters
	
	/**
	 * getter of the debitCard
	 * @return DebitCard
	 * */
	public DebitCard getDebitCard() {
		return debitCard;
	}


	/**
	 * setter of the DebitCard
	 * @param debitCard
	 * */
	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}


	
	/**
	 * Override the paymethod inside the paymethod
	 * @param amount
	 * */
	@Override
	public void pay(double amount) {
		//do nothing
	}

}
