package interfaces.feature;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.*;

public class BuiltInFunctionalInterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //predicate interface demo implementing the abstract test(T t)
		Predicate<String> predicate = (s) -> s.length() > 0;

		predicate.test("foo");              // true
		predicate.negate().test("foo");     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		
	//function interface demo	implementing abstract method R apply(T t)
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		backToString.apply("123");     // "123"
		
		
	//supplier interface demo implementing the abstract 
		Supplier<Person> personSupplier = Person::new;
		personSupplier.get();   // new Person
		
	//consumer interface implementing abstract accept(T t);
		String str = "hello consumer";
		Consumer<String> c1 = (s)->System.out.println("consumer demo: "+s);
		Consumer<String> c2 = (s)->System.out.println("consumer demo again: "+s);
		Consumer<String> c3 = c1.andThen(c2);
		c1.accept(str);
		c2.accept(str);
		c3.accept(str);
		
		
	// comparator interface implementing the abstract method compare(Object o1, Object o2)
		Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

		Person p1 = new Person("John", "Doe");
		Person p2 = new Person("Alice", "Wonderland");

		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0
		
		
	// optional class 
		Optional<String> optional = Optional.of("bam");

		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}

}
class Person{
	
	 String firstName, lastName;
	 public Person(String firstname, String lastName) {
		 this.firstName=firstname;
		 this.lastName=lastName;
	 }
	 public Person() {}
}
