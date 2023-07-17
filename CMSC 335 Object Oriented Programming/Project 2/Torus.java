

/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 *  Subclass of 3D shape that represents a Torus by providing volume and area calulations 
 */

public class Torus extends ThreeDimensionalShape {
     private double majorRadius;
     private double minorRadius;
    
    public Torus(double majorRadius, double minorRadius) {
        super(0, 0, 0, "Torus");
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }
    
    @Override
    public double getArea() {
        return 4 * Math.PI * Math.PI * minorRadius * majorRadius;
    }
    
    @Override
    public double getVolume() {
        return 2 * Math.PI * Math.PI * minorRadius * minorRadius * majorRadius;
    }
}
