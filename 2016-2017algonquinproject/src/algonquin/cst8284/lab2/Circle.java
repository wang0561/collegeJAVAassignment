package algonquin.cst8284.lab2;

public class Circle extends BasicShape {
  
	public Circle() {

	}
   
    public Circle(Circle circle) {
		
    	//this(circle.getWidth());
	}

	public Circle(double diameter) {
		setWidth(diameter);
	}

	@Override
	public double getArea() {

		return Math.PI * (getWidth() / 2) * (getWidth() / 2);
	}

	@Override
	public double getPerimeter() {

		return getWidth() * Math.PI;
	}

	@Override
	public String toString() {
		return "Circle Overrides " + super.toString();
	}

	@Override
	public boolean equals(Object obj) {

		boolean isEqual = false;

		if (obj instanceof Circle && this.getWidth() == ((Circle) obj).getWidth())
			isEqual = true;
		
		return isEqual;

	}
}
