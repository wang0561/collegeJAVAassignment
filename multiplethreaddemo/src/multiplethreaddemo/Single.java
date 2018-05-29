package multiplethreaddemo;

public class Single {

	public static void main(String[] args) {

		String s1 = Single.getInstance();
		String s2 = Single.getInstance();

		System.out.println(s1 == s2);
		System.out.println(s1 == s);
		System.out.println(s2 == s);
		String a = "abc";
		String b = "abc";
	
		System.out.println(a==b);
		
	}

	private static String s = null;

	public static String getInstance() {
		if (s == null) {// this if condition is for improving the effective.
			synchronized (Single.class) {
				if (s == null)
					s = new String();
			}
		}
		return s;
	}
}
