package public_service.employee;

public class DeptAndNumber {
	
	private String dept;
	private int number;
	
	public DeptAndNumber(String dept, int number) {
		this.setDept(dept);
		this.setNumber(number);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
