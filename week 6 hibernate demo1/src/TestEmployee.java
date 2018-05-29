/* File: TestEmployee.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Test harness program to determine if Hibernate is working correctly.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Calendar;

public class TestEmployee {

	public static void main(String[] args) {
		System.out.println("Attempting to build SessionFactory");
		Configuration config = new Configuration()
		    .addAnnotatedClass(Employee.class) // load the entities
		    .configure("hibernate.cfg.xml");   // load additional settings
		
		StandardServiceRegistryBuilder sRBuilder = 
		        new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		ServiceRegistry sR = sRBuilder.build();
		SessionFactory factory = config.buildSessionFactory(sR);  // we create a factory only once per application
		System.out.println("SessionFactoryBuilt\n");
		
		System.out.println("Attempting to create and persist new entity");
		Session s = factory.getCurrentSession();		  // we use factory to get a session whenever needed
		s.beginTransaction();		
		Employee todd = new Employee();		              // at this instant, todd is transient 
		todd.setEmpId(10001);                             // if @GeneratedValue this is quietly ignored
		todd.setEmpEmail("e@temp.com");
		todd.setEmpAddress("temp address");
		todd.setEmpName("temp employee");
		todd.setAge(42);
		// see: https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.Builder.html
		todd.setEmpStartDate(new Calendar.Builder().setDate(2016, 9, 01).build());
		s.save(todd);                                             // todd becomes persistent
		s.getTransaction().commit();                             // todd becomes detached
		System.out.println("new entity persisted\n");
		
		System.out.println("Attempting to edit and persist existing entity");
		Session s2 = factory.getCurrentSession();
		s2.beginTransaction();
		todd.setEmpEmail("email_2@email.com");                  // change todd's state
		s2.update(todd);                                        // todd is persitent again
		s2.getTransaction().commit();
		System.out.println("edited entity persisted\n");
		
		System.out.println("Closing factory and destroying service registry");
		factory.close();                                        // shutting program down
		StandardServiceRegistryBuilder.destroy(sR);
	}
}
