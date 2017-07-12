package symphony.domain;

/**
 * Interface PayMethod prepared for payment classes
 * @author Bo
 * 
 * */
public interface PayMethod {
	
	
	/**
	 * pay method
	 * @param amount
	 * */
	public void pay(double amount);

}
