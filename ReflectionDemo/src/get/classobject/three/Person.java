package get.classobject.three;
import static java.lang.System.*;
public class Person {

	int age;
	String name;
	
	public Person(int age,String name) {
		
		super();
		this.age=age;
		this.name=name;
		out.println("person param run");
	}
	
	public Person() {
		super();
		out.println("person run");
	}
	
	public void show() {
		
		out.println(name+"...show run "+age);
	}
	
	private void method() {
		out.println("method run");
	}
	
	public void paramMethod(String str, int num) {
		
		out.println("paramMethod run..."+str+":"+num);
	}
}
