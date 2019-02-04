package test.demo;

import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {

		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new FileReader("Lines"));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop - start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}

		// System.out.println("abcd".compareTo(""));
	}

	/*
	 * question 2: Read the input one line at a time and output the current line if
	 * and only if it is smaller than other line so far. smaller means the string
	 * order, use compareTo
	 */
//	private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//		
//		Stack<String> list = new Stack<>();
//		list.push("");
//		for (String line = r.readLine(); line != null; line = r.readLine()) {
//			if(list.peek().compareTo(line)<0)
//				list.push(line);
//			else {
//				w.println(line);
//			}
//		}
//	}
	/*
	 * question6: Read the input one line at a time and output the current line if
	 * and only if it is not suffix of some previous lines Example, if some line is
	 * "oxdeadbeef" and some subsequent line is "beef", then the suffix line should
	 * not be output.
 */
	 private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		 Stack<String> list = new Stack<>();
		 list.push("");
		 for (String line = r.readLine(); line != null; line = r.readLine()) {
		   
			 if(!list.peek().endsWith(line)) {
				 w.println(line);
				 list.push(line);
			 }
		 }
		 }
	
	 

	/*
	 * Read the input one line at a time and output the current line if and only if
	 * you have already read at least 1000 lines greater than the current line and
	 * at least 1000 lines less than the current line.(greater than and less than
	 */
	// private static void doIt(BufferedReader r, PrintWriter w) {
	//
	//
	// }

}