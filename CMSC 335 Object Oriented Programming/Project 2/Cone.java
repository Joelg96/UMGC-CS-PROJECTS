

/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * Subclass of 3D shape that represents a Cone by providing volume and area calulations 
 */

public class Cone extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        super(0,0,0, "Cone");
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }

    @Override
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }
}
