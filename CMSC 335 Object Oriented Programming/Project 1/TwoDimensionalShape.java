/**
 * Joel Goode - CMSC 335 -  March 25 2023
 * TwoDimensional Shape class extends Shape.
 */

package Project_1;

public abstract class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape() {
        super(2);
    }

/**
 * Abstract method to calculate the area of the TwoDimensionalShape.
 * This method must be implemented by subclasses.
 * @return float value representing the area of the TwoDimensionalShape
 */
public abstract float getArea();

}