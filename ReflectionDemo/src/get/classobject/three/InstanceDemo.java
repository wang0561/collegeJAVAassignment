package get.classobject.three;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InstanceDemo {
	static final String classname = "get.classobject.three.Person" ;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
        createObject();
        
        createObject_2();
        
	}

	private static void createObject_2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		//当要获取制定名称对应类中的所体现的对象时，而该对象不适用空参数constructor时
		
		Class cl = Class.forName(classname);
		
		Constructor c = cl.getConstructor(int.class,String.class);
		
		Object obj = c.newInstance(23,"tao");
		
		
	}

	private static void createObject() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		//早期：new的时候，class文件加载进内存，并创建class文件对象， 并创建该文件对应的person对象
		
		get.classobject.three.Person p =new get.classobject.three.Person();
		
		//现在
		//String classname = "get.classobject.three.Person" ;
		
		//寻找该class文件并加载进内存， 产生Class对象
		Class cl = Class.forName(classname);
		
		//产生person对象
		Object obj = cl.newInstance();
	      
		
	}
 
}
