/* File: TestEmployee.java
 * Provided by: Todd Kelley (2016) Personal Communication
 * Modified by: Stanley Pieda
 * Modified Date: Oct 9, 2017
 * Description: Test harness that attempts to load, update, persist an
 *              Employee with Location information.
 */
import java.util.ArrayList;
import org.hibernate.Query; // caution: old way of doing things
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class TestEmployee {

    public static void main(String[] args) {
    	// Build SessionFactory
        Configuration config = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Location.class)
                .configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sRBuilder = 
                new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        ServiceRegistry sR = sRBuilder.build();
        SessionFactory factory = config.buildSessionFactory(sR);  // we create a factory only once
        
        // Use a Session to attempt to load employee with id of 1, then modify and persist
        Session s = factory.getCurrentSession();
        try{
            s.beginTransaction();		
            Employee todd = new Employee();
            s.load(todd,1); // if no record with id is found employee todd will not be initialized
            if(todd.getLocation() != null){ // if employee was not initialized
                System.out.println("Todd's current location is " + 
                todd.getLocation().getStoreNumber());
            }
            else{
                System.out.println("Todd's current location is unknown (null)");
            }
            todd.setEmpEmail("kelleyt@algonquincollege.com");
            todd.setEmpAddress("Algonquin College, Information and Communications Technology");
            todd.setEmpName("Todd Kelley");
            todd.setLocation(new Location(new Integer(42)));
            s.save(todd);
            s.getTransaction().commit();
        }
        catch(Exception ex){
            if(s.getTransaction().getStatus() != TransactionStatus.COMMITTED){
            	s.getTransaction().rollback();}
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        // Load an employee using a query with list.
        ArrayList<Employee> emps = new ArrayList<Employee>();
        Session s2 = factory.getCurrentSession();
        try{
            s2.beginTransaction();
            Query q = s2.createQuery("from Employee E where E.empId = :id"); // use Entity class name, not database table name
            // see http://stackoverflow.com/questions/9954590/hibernate-error-querysyntaxexception-users-is-not-mapped-from-users
            q.setParameter("id",1);
            emps = (ArrayList<Employee>) q.list();
            s2.getTransaction().commit();
            for (Employee e: emps){
                Location l = e.getLocation();
                System.out.println(e.getEmpName() + 
                    "'s current location is " + l.getStoreNumber());
            }
        }
        catch(Exception ex){
            if(s.getTransaction().getStatus() != TransactionStatus.COMMITTED){
            	s.getTransaction().rollback();}
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        System.out.println("Closing factory and destroying service registry");
		factory.close();                                        // shutting program down
		StandardServiceRegistryBuilder.destroy(sR);
    }
}
