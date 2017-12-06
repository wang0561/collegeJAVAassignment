package algonquin.cst8390.assignment1.stream;

public class Mydata{

	private String streetName;
	private String postalCode;
	private String zoneGategory;
	private double houseAge;
	private double currentValue;
	private double preValue;

	public Mydata(String name, String code, String zone, double age, double preValue, double currentValue){
		this.streetName=name;
		this.postalCode=code;
		this.zoneGategory=zone;
		this.houseAge=age;
		this.preValue=preValue;
		this.currentValue=currentValue;
		
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getzoneGategory() {
		return zoneGategory;
	}
	public void setzoneGategory(String zoneGategory) {
		this.zoneGategory = zoneGategory;
	}
	public double getHouseAge() {
		return houseAge;
	}
	public void setHouseAge(int houseAge) {
		this.houseAge = houseAge;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public double getPreValue() {
		return preValue;
	}
	public void setPreValue(int preValue) {
		this.preValue = preValue;
	}
	public String toString(){
		return "name: "+ this.streetName+ " postcode: "+this.postalCode+" zone: "+this.zoneGategory+" age: "+this.houseAge+" currentValue: "+this.currentValue+" prevalue: "+this.preValue;
	}
}