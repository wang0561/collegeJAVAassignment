package interfaces.feature;
import static java.lang.System.out;
public class DefaultMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method

		Formula formula = getFormular();
		
      out.println(formula.sqrt(16));
       out.println(formula.calculate(16));
	}
	public static Formula getFormular() {
		return new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a) * 5;
			}

		};
	}
}

interface Formula {

	double calculate(int a);

	/*
	 * default keyword is defined in an interface for any non-abstract method,and
	 * could be used as instance method for any implemented concrete class's object
	 */
	default double sqrt(int a) {
		return Math.sqrt(a);
	}

}