/**
 * @version 1.0
 * @(#)ActivityDate.java 1.0 2017/03/19
 * this is a part of project for CST8288_010 OOP with Design Patterns;
 * */
package symphony.domain;//package for this project

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Class for run the project as start point, main method inside
 *  @author BO */
public class Controller {

	/** the static ConcertSeason is an arraylist which store the current season information */
	static ConcertSeason cs;

	/** default constructor */
	public Controller() {

	}

	/**
	 * the main
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String... args) throws ParseException {

		//Example 1
		
		Movement movement1 = new Movement(new ID("movement1"));
		Movement movement2 = new Movement(new ID("movement2"));
		
		Composition composition1 = new CompositionBuilder(new ID("composition1"))
				.composer(new Composer(new Name("Wang", "Chen", "MR")))
				.movement(new ArrayList<Movement>() {
					{
						add(movement1);
					}
				}).build();

		Composition composition2 = new CompositionBuilder(new ID("composition2"))
				.composer(new Composer(new Name("Min", "Luo","Mrs")))
				.movement(new ArrayList<Movement>() {
					{
						add(movement2);
					}
				}).build();

	
	

		Conductor conductor1 = new Conductor(new ID("conductor1"), new Name("Sungwon", "Lee", "MR"),
				new Address("66 ", "Slater ", "Ottawa ", "ON ",new PostalCode("K1L2A2")), new PhoneNumber(613,727,8888,333));
		
		Soloist soloist1 = new Soloist(new ID("soloist1"), new Name("Wang", "Tao", "Mr"),
				new Address("875 ", "Heron ", "Ottawa ", "ON ", new PostalCode("K2L2A2")), new PhoneNumber(613,227,6130,3344),
				new ArrayList<String>() {
					{
						add("sax");
					}
				});
		Date concertStartDate1 = new Date (2017,04,022);
		//String str="2017-04-30";  
	   // Date date=Date.valueOf(str);//converting string into sql date 
		PhoneNumber ph1= new PhoneNumber(613,227,6130,3344);
		
			Venue venue1 = new Venue(
			new Address("1355 ", "Woodroffe ", "Ottawa ", "ON ", new PostalCode("K1L2A2")),
				new ArrayList<PhoneNumber>() {
				{
					add(ph1);
				}}	);
		
		ScheduledConcert sc= new ConcertBuilder(new ID("composition2")).conductor(conductor1).date(concertStartDate1)
				.soloist(new ArrayList<Soloist>() {
					{
						add(soloist1);
					}
				}).venue(venue1).build();
		Seat st = new  Seat(false, 22, 33);
		
		VenueConcert  vc = new VenueConcert(
			new Address("1355 ", "Woodroffe ", "Ottawa ", "ON ", new PostalCode("K1L 2A2")),
				new ArrayList<PhoneNumber>(){
				{
					add(ph1);
				}},
				new ArrayList<Seat>(){
				{
					add(st);
				}},
				new ArrayList<Concert>() {
					{
						add(sc);
					}});
		
		cs.add(sc);
				
	}
	
	

}
