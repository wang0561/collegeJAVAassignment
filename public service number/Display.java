package public_service.employee;

public class Employee {
	private int year, number;
	private String dept,uni;


	public Employee(int year,int number, String dept, String uni) {
		this.year = year;
		this.number = number;
		this.dept= dept;
		this.uni = uni;
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
	public String getUni() {
		return uni;
	}
	public void setUni(String uni) {
		this.uni = uni;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String toString() {
		return "Year: "+ year+", Number: "+number+", Department: "+dept+",Universe: "+uni;
	}
}
