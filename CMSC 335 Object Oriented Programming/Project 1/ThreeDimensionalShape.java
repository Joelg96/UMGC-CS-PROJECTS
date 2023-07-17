/**
 * Joel Goode - CMSC 335 - March 25 2023
 * ThreeDimensionalShape is an abstract class that extends the Shape class and provides the numberOfDimensions variable that all Shapes will have. 
*/

package Project_1;

public abstract class ThreeDimensionalShape extends Shape {
    public ThreeDimensionalShape() {
        super(3);
    }

    /**
     * Abstract method for calculating the volume of a ThreeDimensionalShape object
     * Implemented in all subclasses of ThreeDimensionalShape
     * @return float value representing the volume of the ThreeDimensionalShape object
     */
    public abstract float getVolume();

}