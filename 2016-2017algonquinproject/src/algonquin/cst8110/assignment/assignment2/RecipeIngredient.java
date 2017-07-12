package algonquin.cst8110.assignment.assignment2;

import java.text.DecimalFormat;

/*
 LAB TEACHER: Howard Rosenblum
 Author:Wang,Tao 040857654
 course: CST8110 300 ;
 */
public class RecipeIngredient {

	private DecimalFormat df = new DecimalFormat("0.##");
	private double value;
	private double teaspoonnum;
	private double convertValue;
	private String unit;
	private String ingredient;

	public RecipeIngredient() { // default constructor
		this.value = 1;
		this.unit = "teaspoon";
		this.ingredient = "unkown ingredient";
	}

	public RecipeIngredient(String ing) { // initial constructor
		this.ingredient = ing;
	}

	public void setValue(double value, String unit) { // method to set value of
		// amount and unit
		this.value = value;
		this.unit = unit;

	}

	public String getAmount() {
		// convert the units by "if" statement

		if (unit == "teaspoon") {
			this.teaspoonnum = value;
		} else if (unit == "cup") {
			this.teaspoonnum = 48 * value;
		} else if (unit == "") {
			this.teaspoonnum = value;

		}

		if (teaspoonnum < 1.5 && unit != "") {
			this.convertValue = teaspoonnum;
			this.unit = "teaspoon";
		} else if (teaspoonnum < 24 && teaspoonnum >= 1.5 && unit != "") {
			this.convertValue = teaspoonnum / 3d;
			this.unit = "tablespoon";
		}

		else if (teaspoonnum >= 24 && unit != "") {
			this.convertValue = teaspoonnum / 48d;
			this.unit = "cup";

		} else {
			this.convertValue = teaspoonnum;
			this.unit = "";
		}

		// System.out.print(df.format(convertValue) + " " + unit + " " +
		// ingredient);
		return df.format(convertValue) + " " + unit + " " + ingredient;

	}

}// end of class
