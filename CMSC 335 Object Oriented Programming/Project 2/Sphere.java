

/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 *  Subclass of 3D shape that represents a Shpere by providing volume and area calulations 
 */

public class Sphere extends ThreeDimensionalShape {
    private double radius;
    
    public Sphere(double radius) {
        super(radius, radius, radius, "Sphere");
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
    
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
