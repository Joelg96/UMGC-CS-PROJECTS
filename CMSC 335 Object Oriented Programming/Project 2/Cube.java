

/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * Subclass of 3D shape that represents a Cube by providing volume and area calulations. 
 */

public class Cube extends ThreeDimensionalShape {

    public Cube(double edge) {
        super(edge, edge, edge, "Cube");
    }

    @Override
    public double getVolume() {
        return Math.pow(dimension1, 3);
    }
    
    @Override
    public double getArea() {
        return 6 * Math.pow(dimension1, 2);
    }
}
