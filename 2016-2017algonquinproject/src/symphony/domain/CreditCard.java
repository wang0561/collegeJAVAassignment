package symphony.domain;

import java.util.Date;
/**
 * class for creditCard information ,include type, expiredate,and security code
 * @author Bo
 * 
 * */

public class CreditCard {
	
	/**
	 * enum type CreaditCard which allowed different type of credit card
	 * */
	public enum CreditCardType{VISA,MASTER,AMEX	}
	
	/**
	 * store the cardType
	 * */
	private CreditCardType creditCardType;
	
	/**
	 * store the date of the expiredate
	 * */
	private Date expireDate;
	
	/**
	 * store the security code for the creditCard obj
	 * */
	private int securityCode;
	

	/**
	 * parameterized constructor
	 * @param creditCardType
	 * @param expireDate
	 * @param securityCode
	 * */
	public CreditCard(CreditCardType creditCardType, Date expireDate, int securityCode) {
		super();
		this.creditCardType = creditCardType;
		this.expireDate = expireDate;
		this.securityCode = securityCode;
	}

	//---------------------------------getters and setters
	/**
	 * getter of creditCard
	 * @return creditCardType
	 * */
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	/**
	 * setter of creditCardType
	 * @param creditCardType
	 * */
	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	
	/**
	 * getter of the ExpireDate
	 * @return expireDate
	 * */
	public Date getExpireDate() {
		return expireDate;
	}


	/**
	 * setter of the ExpireDate
	 * @param expireDate
	 * */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	/**
	 * getter of the securityCode
	 * @return securityCode
	 * */
	public int getSecurityCode() {
		return securityCode;
	}

	/**
	 * setter of the securityCode
	 * @param securitycode
	 * */
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	

	

}
