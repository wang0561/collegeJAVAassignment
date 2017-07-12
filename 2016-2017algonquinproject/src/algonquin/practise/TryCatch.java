package algonquin.practise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
	private boolean exit = false;
	public static void main(String[] args) {

		new TryCatch();

	}
	public TryCatch(){
		Scanner in = new Scanner(System.in);
		do{
			System.out.print("Enter first number: ");
			int num1 = in.nextInt();
			System.out.print("Enter the second number: ");
			int num2 = in.nextInt();
			in.nextLine();
			System.out.print("Enter +, -, *, /, or %: ");
			char choice = in.nextLine().charAt(0);
			System.out.println("Result is " +
					doCalculation(choice, num1, num2));
			System.out.println("do again?");
			String str=in.nextLine();
			if(!str.equalsIgnoreCase("y")){
			    exit=true;
			}
	
		} while (!exit);
		in.close();
	}
	private double doCalculation(char choice, int num1, int num2) {
		// TODO Auto-generated method stub
		boolean badCalculation = true;
		double result = 0.0;
		do{
			try{
				switch(choice){
				case '*':
					result = multiplication(num1, num2);
					break;
				case '/':
					result = division(num1, num2);
					break;
					//… plus additional case statements for '+', '-', etc.

				}	badCalculation=false;
			}catch (ArithmeticException ex){
				System.out.println("Bad value input; re-enter input");
				badCalculation=false;
			}
			catch (InputMismatchException ex){
				System.out.println("Bad operation input; try again");
				badCalculation=false;
			}
		}while(badCalculation);
		return result;
	}
	private double division(int num1, int num2)throws ArithmeticException {
		// TODO Auto-generated method stub
		if (num2==0) throw new ArithmeticException();
		return (num1/num2);

	}
	private double multiplication(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1*num2;
	}



}
