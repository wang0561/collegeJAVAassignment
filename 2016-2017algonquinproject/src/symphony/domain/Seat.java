package symphony.domain;

/**
 * Seat is a class which store the seat obj of the seat plan
 * @author Bo
 * */
public class Seat {
	
	/**
	 * is the seat reserved
	 * */
	private boolean seatReserved;
	
	/**row number of the seat*/
	private int rowNo;
	
	/**column number of the seat*/
	private int columNo;
	
	/**
	 * parameterized constructor
	 * @param seatReserved
	 * @param rowNo
	 * @param columNo
	 * */
	public Seat(boolean seatReserved, int rowNo, int columNo) {
		super();
		this.seatReserved = seatReserved;
		this.rowNo = rowNo;
		this.columNo = columNo;
	}

	//--------------setters and getters
	
	/**
	 * getter of the seatReserved 
	 * @return seatReserved
	 * */
	public boolean isSeatReserved() {
		return seatReserved;
	}

	/**
	 * setter of the seatReserved 
	 * @param seatReserved
	 * */
	public void setSeatReserved(boolean seatReserved) {
		this.seatReserved = seatReserved;
	}

	/**
	 * getter of the Row number 
	 * @return row
	 * */
	public int getRowNo() {
		return rowNo;
	}
	
	/**
	 * setter of the Row 
	 * @param RowNumber
	 * */
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	/**
	 * getter of the Column number 
	 * @return Column
	 * */
	public int getColumNo() {
		return columNo;
	}

	/**
	 * setter of the ColumnNumber 
	 * @param Column
	 * */
	public void setColumNo(int columNo) {
		this.columNo = columNo;
	}
	
	
	
	

}
