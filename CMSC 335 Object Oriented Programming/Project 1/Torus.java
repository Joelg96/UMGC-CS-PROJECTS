/**
 * Joel Goode - CMSC 335 - March 25 2023
 * The Torus class is a ThreeDimensionalShape that extends the Shape class.
 */

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Torus extends ThreeDimensionalShape {
    private float majorRadius;
    private float minorRadius;

    /**
     * Constructor for the Torus class.
     * 
     * @param majorRadius float value representing the major radius of the Torus
     * @param minorRadius float value representing the minor radius of the Torus
     */
    public Torus(float majorRadius, float minorRadius) {
        super();
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    /**
     * Getter method for the major radius of the Torus
     * 
     * @return float value representing the major radius of the Torus
     */
    public float getMajorRadius() {
        return majorRadius;
    }

    /**
     * Getter method for the minor radius of the Torus
     * 
     * @return float value representing the minor radius of the Torus
     */
    public float getMinorRadius() {
        return minorRadius;
    }

    /**
     * Method to calculate the surface area of the Torus
     * 
     * @return float value representing the surface area of the Torus
     */
    public float getArea() {
        return (float) (4 * Math.PI * majorRadius * minorRadius);
    }

    /**
     * Method to calculate the volume of the Torus
     * 
     * @return float value representing the volume of the Torus
     */
    public float getVolume() {
        return (float) (2 * Math.PI * Math.PI * minorRadius * minorRadius * majorRadius);
    }

    /**
     * Static method to construct a Torus object with user input
     * Prompts the user to enter the major and minor radius of the Torus and returns
     * the calculated volume
     * 
     * @param scanner Scanner object used to read user input
     */
    public static void constructTorus(Scanner scanner) {
        System.out.println("**You Selected Torus**\n");
        float torusMajorRadius = 0;
        float torusMinorRadius = 0;
        try {
            System.out.println("Enter the major radius: ");
            torusMajorRadius = scanner.nextFloat();
            System.out.println("Enter the minor radius: ");
            torusMinorRadius = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid floats.");
            scanner.next(); // consume invalid input
            return;
        }
        Torus torus = new Torus(torusMajorRadius, torusMinorRadius);
        System.out.printf("The volume of the torus is %.2f\n", torus.getVolume());

    }

}
