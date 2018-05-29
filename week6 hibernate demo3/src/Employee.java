/* File: Employee.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Description: Model for an employee entity, updated with Location
 *                           Demonstrates one to one relationship between entities
 */
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="myEmployee")
public class Employee 
{
	
	private int empId;
	private String empName;
	private String empEmail;
	private String empAddress;
    private Location location;
	private int age;
	private Calendar empStartDate;
	
	@Column
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Column(nullable = false)
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getEmpStartDate() {
		return empStartDate;
	}
	public void setEmpStartDate(Calendar empStartDate) {
		this.empStartDate = empStartDate;
	}
	@OneToOne(cascade=CascadeType.ALL) 
	@JoinColumn (name = "location_id")
	public Location getLocation(){
		return location;
	}
	public void setLocation(Location location){
		this.location = location;
	}
	
}
