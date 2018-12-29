package public_service.employee;

public class YearAndNumber {
	protected int year, number;
	public YearAndNumber(int year,int number) {
		this.setYear(year);
		this.setNumber(number);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
