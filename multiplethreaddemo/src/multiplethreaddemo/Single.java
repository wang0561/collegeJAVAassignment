package multiplethreaddemo;

public class Single {

	public static void main(String[] args) {

		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();

		System.out.println(s1 == s2);
		System.out.println(s1 == s);
		System.out.println(s2 == s);
		;
	}

	private static Single s = null;

	public static Single getInstance() {
		if (s == null) {// this if condition is for improving the effective.
			synchronized (Single.class) {
				if (s == null)
					s = new Single();
			}
		}
		return s;
	}
}
