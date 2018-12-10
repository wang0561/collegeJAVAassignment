package cst8110.game;

import static java.lang.System.*;
import java.util.*;

public class Prototype {
	public static void main(String args[]) {
		new Play().doGame();
	}

}

class Play {
	private static final String WELCOME = "Welcome to Dice Roulette Deluxe ";
	private static final String ASKDICE = "How many dice do you want?";
	private static final String INVALIDDICE = "You need at least one die";
	private static final String ASKSIDE = "How many sides do they have?";
	private static final String INVALIDSIDE = "It needs to have at least 2 sides";
	private static final String YOURPOT = "Your pot is: $";
	private static final String ASKBET = "How much do you want to bet?";
	private static final String INVALIDBET = "Invalid bet, pick a value between 0 and ";
	private static final String ASKCHOICE = "What is your choice?";
	private static final String INVALIDCHOICE = "Invalid choice, choose odd, even, high, or low";
	private static final String YOUROLLED = "You rolled:";
	private static final String TOTAL = "total=";
	private static final String WIN = "You win";
	private static final String LOSE = "You lose";
	public static final String THANKS = "Thank you for playing";
	private static final String AGAIN = "Do the game again?";
	private Scanner input = new Scanner(in);
	private int dice, side, total;
	private List<Integer> list;
	private String choice;
	private boolean result;
	private Game game;
	private final static double startPot = 110.0;
	private double currentPot, bet;

	public void doGame() {
		newGame();
		do {
			do {
				askBet();
				if (betZero()) {
					out.println(THANKS);
					break;
				}
				askChoice();
				output();

			} while (getCurrentPot() > 0);
			if (betZero())
				break;
		} while (doAgain());
	}

	public Play() {
	}

	private void print(String s) {
		out.println(s);
	}

	public double getBet() {
		return bet;
	}

	public double getCurrentPot() {
		return currentPot;

	}

	
	public void newGame() {
		// ask dice and sides
		print(ASKDICE);
		dice = input.nextInt();
		verifyDice(dice);
		print(ASKSIDE);
		side = input.nextInt();
		verifySide(side);
		game = new Game(dice, side);

		print(WELCOME + "\n\n");

	}

	public boolean betZero() {
		return bet == 0;
	}
	// begain the logic of game

	public void askBet() {
		// ask bet and choice
		if (currentPot == 0)
			currentPot = startPot;
		print(YOURPOT + currentPot);
		print(ASKBET);
		bet = Double.parseDouble(input.next());
		verifyBet(bet);

	}

	public void askChoice() {
		print(ASKCHOICE);
		choice = input.next();
		verifyChoice(choice);
	}

	public void output() {
		list = game.getRoll();
		print(YOUROLLED + list);
		print(TOTAL + game.getTotal());
		if (winOrLose()) {
			print(WIN);
			currentPot += bet;
		} else {
			print(LOSE);
			currentPot -= bet;
		}
	}

	public boolean doAgain() {
		print(AGAIN);
		String yesorno = input.next();
		if ("y".equalsIgnoreCase(yesorno))
			return true;
		print(THANKS);
		return false;
	}

	private boolean winOrLose() {
		result = false;
		int isHigh = dice * (side + 1) / 2;
		total = game.getTotal();
		switch (choice) {
		case "low":
			if (total < isHigh)
				result = true;
			break;
		case "high":
			if (total >= isHigh)
				result = true;
			break;
		case "odd":
			if (total % 2 != 0)
				result = true;
			break;
		case "even":
			if (total % 2 == 0)
				result = true;
			break;
		default:
			break;
		}
		return result;
	}

	private void verifyChoice(String s) {
		while (!correctChoice(s)) {
			print(INVALIDCHOICE);
			s = input.next();

		}
		this.choice = s;
	}

	private boolean correctChoice(String s) {
		return "low".equals(s) || "high".equals(s) || "odd".equals(s) || "even".equals(s);
	}

	private void verifyBet(double be) {
		while (be < 0 || be > currentPot) {
			print(INVALIDBET + currentPot);
			be = input.nextDouble();
		}
		this.bet = be;
	}

	private void verifySide(int side) {
		while (side < 2) {
			print(INVALIDSIDE);
			print(ASKSIDE);
			side = input.nextInt();

		}
		this.side = side;
	}

	private void verifyDice(int dice) {
		while (dice < 1) {
			print(INVALIDDICE);
			print(ASKDICE);
			dice = input.nextInt();

		}
		this.dice = dice;
	}

}

class Game {
	private static Random r = new Random();
	private int dice;
	private int side;
	private ArrayList<Integer> roll;

	public Game() {
	}

	public Game(int dice, int side) {

		setDice(dice);
		setSide(side);

	}

	public void setDice(int dice) {
		this.dice = dice;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public List<Integer> getRoll() {
		roll = new ArrayList<>();
		for (int i = 0; i < dice; i++)
			roll.add(r.nextInt(side) + 1);
		return roll;
	}

	public int getTotal() {
		int sum = 0;
		if (roll != null) {
			for (int i : roll)
				sum += i;
		}
		return sum;
	}
}
