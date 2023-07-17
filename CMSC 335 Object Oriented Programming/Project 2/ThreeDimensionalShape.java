/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * Subclass of Shape for 3D shapes providing a basic structure for said shapes
 */

public abstract class ThreeDimensionalShape extends Shape {

    protected double dimension1;
    protected double dimension2;
    protected double dimension3;

    ThreeDimensionalShape(double threeDimensionOne, double threeDimensionTwo, double threeDimensionThree, String name) {
        super(3, name);
        dimension1 = threeDimensionOne;
        dimension2 = threeDimensionTwo;
        dimension3 = threeDimensionThree;
    }

    public double getArea() {
        return dimension1 * dimension2 * dimension3;
    }

    public abstract double getVolume();

}
