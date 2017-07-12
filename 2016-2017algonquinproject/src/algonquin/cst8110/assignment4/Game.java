package algonquin.cst8110.assignment4;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 Lab Teacher: Howard Rosenblum
 Author:Wang,Tao 040857654
 course: CST8110 300 ;
 */
public class Game {

	private double pot;
	private double bet;
	private String choice;
	private boolean done;
	private double half;
	private int sides = 0;
	private int[] dice;
	private String play;
	private int total = 0;
	private int d = 0;//number of die
	private Scanner input = new Scanner(System.in);
	private DecimalFormat df = new DecimalFormat("##.00");
	Die die = new Die();

	public void welcome() {
		System.out.println("How many dice do you want? ");
		d = input.nextInt();
		while (d < 1) {
			System.out.println("You need at least one die");
			d = input.nextInt();
		}
		dice = new int[d];
		
		System.out.println("How many sides do you want? ");
		sides = input.nextInt();
		while (sides < 2) {
			System.out.println("It needs to have at least 2 sides ");
			sides = input.nextInt();
		}
		die.setI(sides);
		
		System.out.println("Welcom to Dice Roullete");
		System.out.println("     if you select the correct high/low, you win double your bet");
		System.out.println("     if you select the correct odd/even, you win double your bet");
		System.out.println("otherwise you lose your bet");
		System.out.println("If you bet 0 or lose all your money, the game is over");

	}

	/*
	 * public Game() {
	 * 
	 * }
	 */// - Construct the game

	public double getPotAmout() {
		return pot;
	}

	public void getPotFromUser() {
		System.out.print("what is your starting pot? $");
		this.pot = input.nextDouble();

		while (pot < 0) {
			System.out.println("please enter a postive number");
			System.out.println("what is your starting pot? $");
			pot = input.nextDouble();
		}
	}

	public double getBetAmount() {

		return bet;
	}

	public void getBetFromUser() {
		
		System.out.println("Your pot is " + df.format(pot));
		System.out.print("How much do you want to bet? $");
		this.bet = input.nextDouble();

		while (bet > pot || bet < 0) {
			System.out.println("Invalid bet, pick a value between 0 and " + df.format(pot));
			System.out.print("How much do you want to bet? $");
			this.bet = input.nextDouble();
		}
	}// - Get amount the player wants to bet (with retry)

	public void getChoiceFromUser() {
		
		input = new Scanner(System.in);
		System.out.print("What is your choice? ");
		choice = input.nextLine();

		while (!choice.equals("high") && !choice.equals("low") && !choice.equals("odd") && !choice.equals("even")) {
			System.out.println("Invalid choice, choose odd, even, high, or low ");
			System.out.print("What is your choice? ");
			choice = input.nextLine();
		}
	}// - Get type of bet the player is making (with retry)

	public void playOneRound() {

		for (int i = 0; i < dice.length; i++) {
			die.roll();
			dice[i] = die.getValue();
			this.total += dice[i];

		}
		System.out.print("You rolled: ");
		for (int i = 0; i < dice.length; i++) {
			System.out.print(dice[i] + ",");
		}
		System.out.println("\ntotal=" + total);
		if (verify(total) == true) {
			pot += bet;
			System.out.println("You win" + "\n");
		} else if (verify(total) == false && pot - bet > 0) {
			pot -= bet;
			System.out.println("You lose" + "\n");
		} else if (verify(total) == false && pot - bet == 0) {
			pot -= bet;
			System.out.println("You lose");
			System.out.println("You lose all you money" + "\n");

		}
	}// - Given bet and type, roll all three die and show results}

	public boolean playAgain() {
		System.out.println("You leave with a pot of $" + df.format(pot));
		input = new Scanner(System.in);
		System.out.print("Do you want to play again? ");
		this.play = input.nextLine();
		System.out.println("");

		while (!this.play.equalsIgnoreCase("y") && !this.play.equalsIgnoreCase("n")
				&& !this.play.equalsIgnoreCase("yes") && !this.play.equalsIgnoreCase("no")) {
			System.out.print("please enter  yes,y,n or no, with ignore case");
			play = input.nextLine();
		}
		if (this.play.equalsIgnoreCase("y") || this.play.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDone() {
		if (pot == 0) {
			return true;
		} else {
			return false;
		}
	}

	// - Return done value
	private boolean verify(int total) {
		this.half = d * (sides + 1) / 2;
		if (total % 2 == 0 && choice.equals("even")) {
			return true;
		} else if (total % 2 != 0 && choice.equals("odd")) {
			return true;
		} else if (total > half && choice.equals("high")) {
			return true;
		} else if (total <= half && choice.equals("low")) {
			return true;
		} else {
			return false;
		}
	}// - Given total of the 3 dice, did the player win/lose

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean getDone() {
		return done;
	}

	public void goodbye() {
		System.out.print("Thank you for playing");
	}

}
