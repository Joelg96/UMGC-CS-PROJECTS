

/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * Subclass of 2D shape that represents a Circle by providing area calulations 
 */

public class Circle extends TwoDimensionalShape{

    public Circle(double radius) {
        super(radius, radius * Math.PI, "Circle");
    }

}
