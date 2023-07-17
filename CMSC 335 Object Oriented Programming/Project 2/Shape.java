
/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * Shape class is parent class for all shape classes.
 */

public class Shape {

    protected int numberOfDimensions;
    protected String shapeName;

    Shape(int dimensions, String name) {
        numberOfDimensions = dimensions;
        shapeName = name;
    }

    int getNumberOfDimensions() {
        return numberOfDimensions;
    }


    String getShapeName() {
        return shapeName;
    }
}
