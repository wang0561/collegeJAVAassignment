package enumeration.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WeekdayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            //print date
		    Date date=new Date();
		    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    System.out.println(dateFormat.format(date));
		    //print current week day
           Calendar c=Calendar.getInstance();
            c.setTime(date);
           int today= c.get(Calendar.DAY_OF_WEEK);
           switch( today){
        	   
        	   case 1: System.out.println(WeekDay.SUN.getValue());
        	   break;
        	   case 2:System.out.println(WeekDay.MON.getValue());
        		   break;
        	   case 3:System.out.println(WeekDay.TUE.getValue());
    		   break;
        	   case 4:System.out.println(WeekDay.WED.getValue());
    		   break;
        	   case 5:System.out.println(WeekDay.THUR.getValue());
    		   break;
        	   case 6:System.out.println(WeekDay.FRI.getValue());
    		   break;
        	   case 7:System.out.println(WeekDay.SAT.getValue());
    		   break;
    		   default:break;
        		   
           }
           
	}

}
enum WeekDay{
	
	MON("monday"),TUE("tuesday"),WED("wednesday"),THUR("thursday"),FRI("friday"),SAT("saturday"),SUN("sunday");
	
   private String dayValue;
   
   private WeekDay(String value){dayValue=value;}
   
   public  String getValue(){
	   
	   return ("Today is "+this.dayValue);
   }
	
	
}