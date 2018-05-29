package interfaces.feature;
import static java.lang.System.out;
public class functinalInterfacesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Demo<Integer,String> demo = (a)->{return "This is an integer as:" +a ; };
     out.println(demo.function(188));
     
     
     /*:: is a method reference for lambda expression*/
     Demo<String,Integer> demo2 = Integer :: valueOf;
     out.println("This is an integer converted from string:"+ demo2.function("188"));
     
     Demo2 demo3 = ()->{out.print("this is an implementation of an functional interface");};
     demo3.function();
	}
    
}

/*functional interface has only one abstract method needed to be implemented by any concrete class*/
@FunctionalInterface
interface Demo<F,T> {
	
	T function (F form);
}

@FunctionalInterface
interface Demo2{
	
	void function();
}