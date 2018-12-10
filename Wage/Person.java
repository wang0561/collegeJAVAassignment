package wage.display.javafx;

public class Person {

		private String name, gender;
		private int age;
		private Wage wage;
		
		public Person(Wage wage, String name, String gender,int age) {
			
			this.wage =wage;
			this.name = name;
			this.gender = gender;
			this.age = age;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Name: "+ name+"\n"+"Age: "+age+"\nGender: "+gender+"\n");
			sb.append(wage.toString());
			return sb.toString();
		}
}
