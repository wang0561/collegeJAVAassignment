package algonquin.cst8110.lab;

	import java.util.Scanner;	//program uses class Scanner
	/**  This program prompts user to enter a numbers, then displays the next number
	 *   Author:   Howard Rosenblum
	 *   CST8110 Introduction to Computer Programming
	 */
	public class JavaMain {
		public static void main (String args[]) {
	
			@SuppressWarnings("resource")
			Scanner input = new Scanner (System.in);
	
			double number = 0;
			System.out.println("This program will produce a printout of the next value after the entered number. Enter the number:");
	
			number = input.nextDouble();



			System.out.println ("The next number after " +number+" is:");
			for(int i = 1;i<= 3; i++ ){
				System.out.println  (number+i);
			}
		} // end of main
	}// end of class