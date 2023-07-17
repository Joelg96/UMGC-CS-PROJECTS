/**
 * Joel Goode - CMSC 335 - March 25 2023
 * This class represents a Sphere which extends ThreeDimensionalShape.
 * This class provides a static method to construct a Sphere object with user input.
 */

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sphere extends ThreeDimensionalShape {
    private float radius;

    /**
     * Constructor for Sphere class 
     * @param radius float value representing the radius of the Sphere
     */
    public Sphere(float radius) {
        super();
        this.radius = radius;
    }

    /**
     * Getter method for radius of the Sphere 
     * @return float value representing the radius of the Sphere
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Method to calculate the area of the Sphere
     * @return float value representing the area of the Sphere
     */
    public float getArea() {
        return (float) (4 * Math.PI * radius * radius);
    }

    /**
     * Method to calculate the volume of the Sphere 
     * @return float value representing the volume of the Sphere
     */
    public float getVolume() {
        return (float) ((4.0 / 3.0) * Math.PI * radius * radius * radius);
    }

    /**
     * Static method to construct a Sphere object with user input
     * Prompts the user to enter the radius of the Sphere and returns the calculated
     * volume 
     * @param scanner Scanner object used to read user input
     */
    public static void constructSphere(Scanner scanner) {
        System.out.println("**You Selected Sphere**\n");
        System.out.println("Enter the radius of the sphere:");
        float sphereRadius = 0;
        try {
            sphereRadius = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid float.");
            scanner.next(); // consume invalid input
            return;
        }
        Sphere sphere = new Sphere(sphereRadius);
        System.out.printf("The volume of the sphere is %.2f\n", sphere.getVolume());
    }
}