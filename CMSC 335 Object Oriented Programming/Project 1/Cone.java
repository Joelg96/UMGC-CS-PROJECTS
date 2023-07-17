/* Joel Goode - CMSC 335 - March 25 2023
Cone class represents a Cone which is a ThreeDimensionalShape.
It has a radius and height which are used to calculate its surface area and volume.
This class provides a static method to construct a Cone object with user input.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cone extends ThreeDimensionalShape {
    private float radius;
    private float height;

    /**
     * Constructor for Cone class.
     * @param radius float value representing the radius of the Cone
     * @param height float value representing the height of the Cone
     */
    public Cone(float radius, float height) {
        super();
        this.radius = radius;
        this.height = height;
    }

    /**
     * Getter method for radius of the Cone
     * @return float value representing the radius of the Cone
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Getter method for height of the Cone
     * @return float value representing the height of the Cone
     */
    public float getHeight() {
        return height;
    }

    /**
     * Method to calculate the surface area of the Cone
     * @return float value representing the surface area of the Cone
     */
    public float getArea() {
        return (float) ((float) Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius)));
    }

    /**
     * Method to calculate the volume of the Cone 
     * @return float value representing the volume of the Cone
     */
    public float getVolume() {
        return (float) (1.0 / 3.0) * (float) Math.PI * radius * radius * height;
    }

    /**
     * Static method to construct a Cone object with user input
     * Prompts the user to enter the radius and height of the Cone and returns the
     * calculated volume
     * @param scanner Scanner object used to read user input
     */
    public static void constructCone(Scanner scanner) {
        System.out.println("**You Selected Cone**\n");
        float coneRadius = 0;
        float coneHeight = 0;
        try {
            System.out.println("Enter the radius: ");
            coneRadius = scanner.nextFloat();
            System.out.println("Enter the height: ");
            coneHeight = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid floats.");
            scanner.next(); // consume invalid input
            return;
        }
        Cone cone = new Cone(coneRadius, coneHeight);
        System.out.printf("The volume of the cone is %.2f\n", cone.getVolume());
    }
}
