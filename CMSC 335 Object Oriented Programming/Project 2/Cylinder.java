

/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 *  Subclass of 3D shape that represents a Cylinder by providing volume and area calulations.
 */

public class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;
    
    public Cylinder(double radius, double height) {
        super(0, height, height, "Cylinder");
        this.radius = radius;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
    
    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
