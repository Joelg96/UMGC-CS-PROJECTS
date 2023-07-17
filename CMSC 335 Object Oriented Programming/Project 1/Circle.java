/* Joel Goode - CMSC 335 - March 25th 2023
 * Circle class represents a Circle which is a TwoDimensionalShape.
 * It has a radius which is used to calculate its area.
 * This class provides a static method to construct a Circle object with user input.
 */

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle extends TwoDimensionalShape {
    private float radius;

    /**
     * Constructor for Circle class. 
     * @param radius float value representing the radius of the Circle
     */
    public Circle(float radius) {
        super();
        this.radius = radius;
    }

    /**
     * Getter method for radius of the Circle
     * @return float value representing the radius of the Circle
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Method to calculate the area of the Circle
     * @return float value representing the area of the Circle
     */
    public float getArea() {
        return (float) Math.PI * radius * radius;
    }

    /**
     * Method to calculate the volume of the Circle (always 0 for 2D shapes)
     * @return float value representing the volume of the Circle (always 0 for 2D shapes)
     */
    public float getVolume() {
        return 0;
    }

    /**
     * Static method to construct a Circle object with user input
     * Prompts the user to enter the radius of the Circle and returns the calculated area
     * @param scanner Scanner object used to read user input
     */
    public static void constructCircle(Scanner scanner) {
        System.out.println("**You Selected Circle**\n");
        System.out.println("Enter the radius of the circle:");
        float circleRadius = 0;
        try {
            circleRadius = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid float.");
            scanner.next(); // consume invalid input
            return;
        }
        Circle circle = new Circle(circleRadius);
        System.out.printf("The area of the circle is %.2f\n", circle.getArea());
    }
}
