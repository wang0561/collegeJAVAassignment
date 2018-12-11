package properties.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("Demo.properties");
		/*	Demo.properties contains: 
		 * demo1=properties.reflect.Demo1
		   demo2=properties.reflect.Demo2*/
		Properties pro = new Properties();
		pro.load(fis);
		for (Object key : pro.keySet()) {
			String name = pro.getProperty((String)key);
			Class.forName(name).newInstance();
		}
	}

}
interface Demo{
	void printClassName();
}
class Demo1 implements Demo{
	
	public Demo1(){
		printClassName();
	}

	@Override
	public void printClassName() {
		System.out.println(Demo1.class.getName()+" is initialized.");
		
	}
}

class Demo2 implements Demo{
	
	public Demo2(){
		printClassName();
	}

	@Override
	public void printClassName() {
		System.out.println(Demo2.class.getName()+" is initialized.");
		
	}
}
