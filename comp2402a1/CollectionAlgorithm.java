package comp2402a1;

import java.io.*;

public class CollectionAlgorithm {
	static int count = 0;

	public static void main(String[] args) {
		BufferedReader r = null;
		PrintWriter w = null;
		try {

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
			//doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop - start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		} finally {
			try {
				r.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			w.close();
		}

		// System.out.println(Math.floor(12.34));
	}
	/*
	 * question 1: Read the input one line at a time until you have read all n lines
	 * and imagine these lines are numbered 0...n-1. Next output lines
	 * floor(n/2)...n-1 followed by lines 0...floor(n/2)-1
	 */
//	 private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//			List<String> list = new ArrayList<String>();
//
//			for (String line = r.readLine(); line != null; line = r.readLine()) {
//				list.add(line);
//			}
//
//			int halfSize = (int) Math.floor(list.size() / 2);
//			// w.println(halfSize);
//
//			for (int i = 0; i < list.size(); i++) {
//
//				if (i < halfSize) {
//					if (list.size() % 2 == 0)
//						w.println(list.get(i + halfSize));
//					else
//						w.println(list.get(i + halfSize + 1));
//				} else
//					w.println(list.get(i - halfSize));
//
//			}
//	
//	 }

	/*
	 * (solved) question 2: Read the input one line at a time and output the current
	 * line if and only if it is smaller than other line so far. smaller means the
	 * string order, use compareTo
	 */
//	private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//
//		Stack<String> list = new Stack<>();
//		
//		list.push(null);
//		for (String line = r.readLine(); line != null; line = r.readLine()) {
//			String head = list.peek();
//			if (head==null || line.compareTo(head) < 0) {
//				list.push(line);
//				w.println(line);
//			}
//			
//			count++;
//
//		}
//		w.println("lines: " + count);
//	}
	
//	private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//	
//	String min = null;
//	for (String line = r.readLine(); line != null; line = r.readLine()) {
//			if(min==null || line.compareTo(min)<0) {
//				min = line;
//				w.println(min);
//			}
//	}
//	}
	
	
	/*
	 * question 3: Read the input one line at a time and output only the last 9999
	 * linesin the order they appear if there are fewer than 9999 lines, output them
	 * all. For full marks, your code should be fast and should never store more
	 * than 9999 lines.
	 * 
	 * 
	 */
//	 private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//	
//		  Queue<String> q = new LinkedList<String>(); 
//		    
//	        for (String line = r.readLine(); line != null; line = r.readLine()) {
//	        	if (q.size()<9999) {
//	        		q.add(line);
//	        	}else {
//	        		q.remove();
//	        		q.add(line);
//	        	}
//	        }
//	        for (String temp: q) {
//	        	w.println(temp);
//	        }	
//	 }

	/*
	 * question 4: Read the input one line at a time and output the current line if
	 * and only if it is a duplicate of some previous line.
	 */
//	 private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//	
//		 Set<String> set = new HashSet<String>();
//	        for (String line = r.readLine(); line != null; line = r.readLine()) {
//	        	if(set.contains(line)) {
//	        		w.println(line);
//	        		//continue;
//	        	}
//	        	set.add(line);        
//	        }
//	 }

	/*
	 * question 5: read the input one line at a time. when you are done, output all
	 * lines in case-insensitive sorted order.
	 */
//	 private static void doIt(BufferedReader r, PrintWriter w) {
//		   	List<String> list = new LinkedList<String>();
//
//	        for (String line = r.readLine(); line != null; line = r.readLine()) {
//
//	        	list.add(line);        
//	        }
//	        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);;
//	       // list.sort(String.CASE_INSENSITIVE_ORDER);
//	    	for(String temp:list)
//	    		w.println(temp);
//	
//	 }
	/*
	 * question6: Read the input one line at a time and output the current line if
	 * and only if it is not suffix of some previous lines Example, if some line is
	 * "oxdeadbeef" and some subsequent line is "beef", then the suffix line should
	 * not be output.
	 */
//	private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//		SortedSet<String> sset = new TreeSet<String>();
//		for (String line = r.readLine(); line != null; line = r.readLine()) {
//			
//			String rev = new StringBuffer(line).reverse().toString();
//			SortedSet<String> ts = sset.tailSet(rev);
//			if(ts.isEmpty() || !ts.first().startsWith(rev)) {
//				w.println(line);
//				sset.add(rev);
//			}
//		}
//	}

	/*
	 * question7: Read the input one line at a time and output the current line if
	 * and only if you have already read at least 1000 lines greater than the
	 * current line and at least 1000 lines less than the current line.(greater than
	 * and less than
	 */
//	 private static void doIt(BufferedReader r, PrintWriter w) throws IOException {
//	
//		 int k = 1000;
//		 
//		 ArrayList<String> smallest = new ArrayList<>();
//		 ArrayList<String> largest = new ArrayList<>();
//		 for (String line = r.readLine(); line != null; line = r.readLine()) {
//			 
//			 if(smallest.size() == k && largest.size()==k
//					 && line.compareTo(largest.fir))
//		 }
//	 }

}
