/* File: MessageLogEntry
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Model of a Message Log, saves message, and client info to database.
 */
package datatransfer;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
//@Table(name="message")
public class MessageLogEntry {
	
	private int mesId;
	private int mesNumber;
	private Calendar mesDate;
	private String client;
	private String message;
	
	// if you omit strategy = GenerationType.IDENTITY hibernate
	// will do things as it deems best, including creating another
	// table for tracking primary key generation...
	// strategy = GenerationType.IDENTITY forces hibernate to use MySQL autoincrement column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMesId() {
		return mesId;
	}
	public void setMesId(int mesId) {
		this.mesId = mesId;
	}
	@Column
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Column
	public int getMesNumber(){
		return mesNumber;
	}
	public void setMesNumber(int mesNumber){
		this.mesNumber = mesNumber;
	}
	@Column
	public String getClient(){
		return client;
	}
	public void setClient(String client){
		this.client = client;
	}
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getMesDate() {
		return mesDate;
	}
	public void setMesDate(Calendar mesDate) {
		this.mesDate = mesDate;
	}
}
