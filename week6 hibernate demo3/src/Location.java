/* File: Location.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Model for a Store Location, only has an id and Store Number.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	private Integer storeNumber;
	private int locationId;
	
	public Location(){
		storeNumber = 0;
	}
	public Location(Integer storeNumber){
		this.storeNumber = storeNumber;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	public int getLocationId(){
		return locationId;
	}
	public void setLocationId(int locationId){
    	this.locationId = locationId;
    }	
	
	@Column(name="store_number")
	public Integer getStoreNumber() {
		return storeNumber;
	}
	public void setStoreNumber(Integer storeNumber) {
		this.storeNumber = storeNumber;
	}
}
