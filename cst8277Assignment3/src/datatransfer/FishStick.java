package datatransfer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



/* File: FishStick.java
 * Author: Stanley Pieda
 * Modified: Stanley Pieda
 * Date: Jan 2018
 * Description: Sample solution to Assignment 2
 * Modifications:
 *     implements Serializable with serialVersionUID
 *     Overridden toString() for easier display to screen.
 *     Changed id to be of type Integer - can serialize just the id if needed for lookups rather than the whole transfer object.
 */

/**
 * Transfer object for FishStick data
 * @author Stanley Pieda
 * modified by Tao Wang& Min Luo
 */
@Entity
@Table(name="Fishsticks")
public class FishStick implements Serializable{
	/** Explicit serialVersionUID to avoid generating one automatically */
	private static final long serialVersionUID = 1L;
	
	/** ID value for database */
	private Integer id;
	
	/** recordNumber for database, originally matched a dataset file line number */
	private int recordNumber;
	
	/** omega field */
	private String omega;
	
	/** lambda field */
	private String lambda;
	
	/** uuid field, contains UUID as String */
	private String uuid;
	
	/** see lab hand-out notes from assignment 1 */
	private boolean isLastFishStick;
	
	/**
	 * Default constructor, sets id and recordNumber to zero, omega, lambda, uuid to empty Strings
	 * @author Stanley Pieda
	 */
	public FishStick() {
		this(0,0,"","","");
	}
	
	/**
	 * Telescoping constructor.
	 * @param id The id as Integer
	 * @param recordNumber The recordNumber as int
	 * @param omega The omega as String
	 * @param lambda The lambda as String
	 * @param uuid The UUID as String
	 * @author Stanley Pieda
	 */
	public FishStick(Integer id, int recordNumber, String omega, String lambda, String uuid) {
		this.id = id;
		this.recordNumber = recordNumber;
		this.omega = omega;
		this.lambda = lambda;
		this.uuid = uuid;
	}
	
	/** Getter for id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	/** Setter for id */
	public void setId(Integer id) {
		this.id = id;
	}
	/** Getter for recordNumber */
	@Column
	public int getRecordNumber() {
		return recordNumber;
	}
	/** Setter for recordNumber */
	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	/** Getter for omega */
	@Column
	public String getOmega() {
		return omega;
	}
	/** Setter for omega */
	public void setOmega(String omega) {
		this.omega = omega;
	}
	/** Getter for lambda */
	@Column
	public String getLambda() {
		return lambda;
	}
	/** Setter for lambda */
	public void setLambda(String lambda) {
		this.lambda = lambda;
	}
	/** Getter for uuid */
	@Column
	public String getUUID() {
		return uuid;
	}
	/** Setter for uuid */
	public void setUUID(String uuid) {
		this.uuid = uuid;
	}
	/** Getter for isLastFishStick, can be used by consumer to detect end of buffer */
	@Transient
	public boolean isLastFishStick() {
		return isLastFishStick;
	}
	/** Setter for isLastFishStick, can be used by producer when placing last FishStick into buffer */
	public void setLastFishStick(boolean isLastFishStick) {
		this.isLastFishStick = isLastFishStick;
	}
	
	/** Overridden toString() to provide formatting for console output. */
	@Override
	public String toString() {
		return String.format("%d, %d, %s, %s, %s", id, recordNumber, omega, lambda, uuid);
	}
}
