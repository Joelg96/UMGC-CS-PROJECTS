/**
 * Joel Goode - CMSC 335 - March 25 2023
 * Shape Class is the parent class to all other shape classes within the program.
 */

package Project_1;

public abstract class Shape {
    protected int numberOfDimensions;

    /**
     * Constructor for Shape class
     * @param numberOfDimensions int value representing the number of dimensions of                         the Shape
     */
    public Shape(int numberOfDimensions) {
        this.numberOfDimensions = numberOfDimensions;
    }

    /**
     * Getter method for the number of dimensions of the Shape 
     * @return int value representing the number of dimensions of the Shape
     */
    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }

    /**
     * Abstract method to calculate the area of the Shape
     * @return float value representing the area of the Shape
     */
    public abstract float getArea();

    /**
     * Abstract method to calculate the volume of the Shape 
     * @return float value representing the volume of the Shape
     */
    public abstract float getVolume();
}