package get.classobject.three;
import java.lang.reflect.*;
import static java.lang.System.*;

public class GetClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //1. use object.getClass() method
		getClassObject_1();
		
		//2. use .class get Class object
		getClassObject_2();
		
		//3.use Class's method forName(classname)
		
		getClassObject_3();
		
		
	}
   private static void getClassObject_3() {
		// TODO Auto-generated method stub
		try {
			String name="get.classobject.three.Person";
			Class cl = Class.forName(name);
			Class cl2 = Class.forName(name);
			
			out.println(cl==cl2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			err.println("no such class"+e.getMessage());
		}
		
		
	}
private static void getClassObject_2() {
		// TODO Auto-generated method stub
		Class cl = Person.class;
		
		Class cl2=Person.class;
		
		out.println(cl==cl2);
		
		
	}
public static void getClassObject_1() {
	   
	   Person p = new Person();
	   
	   Class cl = p.getClass();
	   
	   Person p2 = new Person();
	   
	   Class cl2 = p2.getClass();
	   
	   out.println(cl==cl2);
	   
   }
}
