/* File: Employee.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Model for an employee entity.
 */
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/* This class is an example of a Hibernate Entity.  
 * Employee objects are to be stored in the database.
 */
@Entity
@Table(name="myEmployee")  // optionally we can specify a table name other than the class name
public class Employee 
{
	// these instance variables are not annotated, so Hibernate will use property access
	// Note: Either annotate fields, or annotate properties, never both.
	private int empId;         
	private String empName;
	private String empEmail;
	private String empAddress;
	private int age;
	private Calendar empStartDate;
	private int dontStoreInDB;

	@Transient //do not store this into the database, i.e. do not make a column in the table
        public int getDontStoreInDB(){
		return dontStoreInDB;
	}
	public void setDontStoreInDB(int dontStoreInDB){
		this.dontStoreInDB = dontStoreInDB;
        }
	
	@Column                 // all attributes will be stored as columns, unless the @Transient annotation is used
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Id                       // the getter of the primary key is annotated, so Hibernate will use property access
	@GeneratedValue           // automatically generate the primary key values
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@Column(nullable = false)      // required field in database table
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
	
	
	@Temporal(TemporalType.TIMESTAMP)      //specifies the data-type for use within the database table
	public Calendar getEmpStartDate() {
		return empStartDate;
	}
	public void setEmpStartDate(Calendar empStartDate) {
		this.empStartDate = empStartDate;
	}
}
