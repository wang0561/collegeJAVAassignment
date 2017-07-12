package algonquin.cst8110.assignment.assignment2;


/*
 LAB TEACHER: Howard Rosenblum
 Author:Wang,Tao 040857654
 course: CST8110 300 ;
 */

import java.util.Scanner;

public class Recipe {

	private double dozen;
	private RecipeIngredient butter = new RecipeIngredient("butter");
	private RecipeIngredient whitesuger = new RecipeIngredient("white sugar");
	private RecipeIngredient brownsuger = new RecipeIngredient("brown sugar");
	private RecipeIngredient eggs = new RecipeIngredient("eggs");
	private RecipeIngredient vanilla = new RecipeIngredient("vanilla");
	private RecipeIngredient bakingsoda = new RecipeIngredient("baking soda");
	private RecipeIngredient hotwater = new RecipeIngredient("hot Water");
	private RecipeIngredient salt = new RecipeIngredient("salt");
	private RecipeIngredient flour = new RecipeIngredient("flour");
	private RecipeIngredient chocolatechips = new RecipeIngredient("chocolate chips");
	private RecipeIngredient choppedwalnuts = new RecipeIngredient("chopped walnuts");

	// default constructor
	public Recipe() {
		this.dozen = 1;
	}

	public double getNumberOfCookies() {

		System.out.println("Best Chocolate Chip Cookies ");
		System.out.println("Number of dozen Cookies:");
		Scanner input = new Scanner(System.in);
		dozen = input.nextDouble();

		// use a loop statement "while" reminder user to enter a positive number
		// when the user entered any invalid number.

		while (dozen < 0) {

			System.out.println("Please enter a positive number:  ");
			dozen = input.nextDouble();
		}
		input.close();
		return dozen;
	}// end of method

	public void calculateAmounts() {

		butter.setValue(0.5 * dozen, "cup");
		whitesuger.setValue(0.5 * dozen, "cup");
		brownsuger.setValue(0.5 * dozen, "cup");
		eggs.setValue(dozen * 1, "");
		vanilla.setValue(dozen * 1, "teaspoon");
		bakingsoda.setValue(0.5 * dozen, "teaspoon");
		hotwater.setValue(dozen * 1, "teaspoon");
		salt.setValue(0.25 * dozen, "teaspoon");
		flour.setValue(1.5 * dozen, "cup");
		chocolatechips.setValue(dozen * 1, "cup");
		choppedwalnuts.setValue(0.733 * dozen, "cup");

	} // end of method

	public void displayRecipe() {// display the output
		System.out.println("1) Preheat oven to 350 degrees F (175 degrees C).");
		System.out.println("2) Cream together " + butter.getAmount() + ", " + whitesuger.getAmount() + ", and "
				+ brownsuger.getAmount() + " until smooth.");
		System.out.println("3) Beat in " + eggs.getAmount() + ", and then stir in " + vanilla.getAmount() + ".");
		System.out.println("4) Dissolve " + bakingsoda.getAmount() + " in " + hotwater.getAmount() + ".");
		System.out.println("5) Add to batter along with " + salt.getAmount() + ".");
		System.out.println("6) Stir in " + flour.getAmount() + ", " + chocolatechips.getAmount() + ", and "
				+ choppedwalnuts.getAmount() + ".");
		System.out.println("7) Drop by large spoonfuls onto ungreased pans.");
		System.out.println("8) Bake for about 10 minutes in the preheated oven, or until edges are nicely browned.");
	}// end of method

}// end of class
