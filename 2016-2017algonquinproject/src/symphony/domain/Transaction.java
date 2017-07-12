package symphony.domain;

import java.util.Date;
import java.util.List;

/**
 * Class for store all data of transaction
 * @author Bo
 */
public class Transaction {

	/**
	 * Date of the Transaction
	 */
	private Date transactionDate;

	/** the list of the ticket */
	private List<Ticket> ticket;

	/** the transaction id */
	private ID id;

	/** the terminalNumber */
	private int terminalNumber;
	/** description of the transaction */
	private String description;

	/** the transaction amount */
	private double amount;

	/**
	 * parameterized constructor
	 * 
	 * @param transactionDate
	 * @param ListOfTicket
	 * @param terminalNumber
	 * @param description
	 */
	public Transaction(Date transactionDate, List<Ticket> ticket, ID id, int terminalNumber, String description) {
		super();
		this.transactionDate = transactionDate;
		this.ticket = ticket;
		this.id = id;
		this.amount = getAmount();
		this.terminalNumber = terminalNumber;
		this.description = description;
	}

	// ---------getters and setters

	/**getter of the transactionDate
	 * @return transactionDate*/
	public Date getTransactionDate() {
		return transactionDate;
	}

	
	/**setter of the transactionDate
	 * @param transactionDate*/
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**getter of the listOfTicket
	 * @return listOfTicket*/
	public List<Ticket> getTicket() {
		return ticket;
	}

	/**setter of the ListOfTicket
	 * @param ListOfTicket*/
	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}

	/**getter of the id
	 * @return id*/
	public ID getId() {
		return id;
	}

	/**setter of the id
	 * @param id*/
	public void setId(ID id) {
		this.id = id;
	}

	/**getter of the terminalNumber
	 * @return terminalNumber*/
	public int getTerminalNumber() {
		return terminalNumber;
	}

	/**setter of the terminalNumber
	 * @param terminalNumber*/
	public void setTerminalNumber(int terminalNumber) {
		this.terminalNumber = terminalNumber;
	}

	/**getter of the Description
	 * @return Description*/
	public String getDescription() {
		return description;
	}

	/**setter of the description
	 * @param description*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**getter of the Amount
	 * @return Amount*/
	public double getAmount() {

		for (Ticket ticket : ticket) {
			amount += ticket.getTicketPrice();
		}
		return amount;
	}

	/**
	 * start the pay method
	 * @param payMethod
	 * */
	public void pay(PayMethod paytMethod) {
		amount = getAmount();
		paytMethod.pay(amount);
	}

}
