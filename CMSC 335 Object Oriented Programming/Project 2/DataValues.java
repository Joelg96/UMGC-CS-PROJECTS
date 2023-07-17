/**
 * Joel Goode
 * CMSC 335 Project 2
 * 4/10/2023
 * This class contains methods to return the areas and volumes of 2D and 3D shapes using
 * objects of thecorresponding classes. 
 * It also formats the calculated values to two decimal places and returns them as double
 * values.
 */

import java.text.DecimalFormat;

public class DataValues {
    

    private static String formatDouble(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(value);
    }
    

    // 2D Shapes Area.
static double getAreaOfCircle(double radius) {
    return Double.parseDouble(formatDouble(new Circle(radius).getArea()));
}

static double getAreaOfSquare(double side) {
    return Double.parseDouble(formatDouble(new Square(side).getArea()));
}

static double getAreaOfTriangle(double base, double height) {
    return Double.parseDouble(formatDouble(new Triangle(base, height).getArea() / 2));
}

static double getAreaOfRectangle(double base, double height) {
    return Double.parseDouble(formatDouble(new Rectangle(base, height).getArea()));
}


// 3D Shapes Area 
static double getAreaOfSphere(double radius) {
    return Double.parseDouble(formatDouble(new Sphere(radius).getArea()));
}

static double getAreaOfCube(double edge) {
    return Double.parseDouble(formatDouble(new Cube(edge).getArea()));
}

static double getAreaOfCone(double radius, double height) {
    return Double.parseDouble(formatDouble(new Cone(radius, height).getArea()));
}

static double getAreaOfCylinder(double radius, double height) {
    return Double.parseDouble(formatDouble(new Cylinder(radius, height).getArea()));
}

static double getAreaOfTorus(double majorRadius, double minorRadius) {
    return Double.parseDouble(formatDouble(new Torus(majorRadius, minorRadius).getArea()));
}

// 3D Shapes volume.
static double getVolumeOfCone(double radius, double height) {
    return Double.parseDouble(formatDouble(new Cone(radius, height).getVolume()));
}

public static double getVolumeOfCube(double edge) {
    return Double.parseDouble(formatDouble(new Cube(edge).getVolume()));
}

public static double getVolumeOfCylinder(double radius, double height) {
    return Double.parseDouble(formatDouble(new Cylinder(radius, height).getVolume()));
}

public static double getVolumeOfSphere(double radius) {
    return Double.parseDouble(formatDouble(new Sphere(radius).getVolume()));
}

static double getVolumeOfTorus(double majorRadius, double minorRadius) {
    return Double.parseDouble(formatDouble(new Torus(majorRadius, minorRadius).getVolume()));
}

}