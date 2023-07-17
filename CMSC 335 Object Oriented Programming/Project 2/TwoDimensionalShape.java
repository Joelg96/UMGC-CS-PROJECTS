/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * Subclass of Shape provides representation of 2D shapes.
 */

public abstract class TwoDimensionalShape extends Shape {

   protected double dimension1;
   protected double dimension2;

    TwoDimensionalShape(double twoDimensionOne, double twoDimensionTwo, String name) {
        super(2, name);
        dimension1 = twoDimensionOne;
        dimension2 = twoDimensionTwo;
    }

    public double getArea() {
        return dimension1 * dimension2 ;
    }
}
