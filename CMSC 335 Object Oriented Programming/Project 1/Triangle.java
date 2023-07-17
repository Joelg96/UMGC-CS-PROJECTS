/**
 * Joel Goode - CMSC 335 - March 25th 2023
 * Triangle class extends TwoDimensionalShape.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle extends TwoDimensionalShape {
    private float base;
    private float height;

    /**
     * Constructor for Triangle class. 
     * @param base   float value representing the base of the Triangle
     * @param height float value representing the height of the Triangle
     */
    public Triangle(float base, float height) {
        super();
        this.base = base;
        this.height = height;
    }

    /**
     * Getter method for the base of the Triangle
     * @return float value representing the base of the Triangle
     */
    public float getBase() {
        return base;
    }

    /**
     * Getter method for the height of the Triangle 
     * @return float value representing the height of the Triangle
     */
    public float getHeight() {
        return height;
    }

    /**
     * Method to calculate the area of the Triangle
     * @return float value representing the area of the Triangle
     */
    public float getArea() {
        return (float) (0.5 * base * height);
    }

    /**
     * Method to calculate the volume of the Triangle (always 0 for 2D shapes) 
     * @return float value representing the volume of the Triangle (always 0 for 2D   shapes)
     */
    public float getVolume() {
        return 0;
    }

    /**
     * Static method to construct a Triangle object with user input
     * Prompts the user to enter the base and height of the Triangle and returns the
     * calculated area 
     * @param scanner Scanner object used to read user input
     */
    public static void constructTriangle(Scanner scanner) {
        System.out.println("**You Selected Triangle**\n");
        float triangleBase = 0;
        float triangleHeight = 0;
        try {
            System.out.println("Enter the base: ");
            triangleBase = scanner.nextFloat();
            System.out.println("Enter the height: ");
            triangleHeight = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid doubles.");
            scanner.next(); // consume invalid input
            return;
        }
        Triangle triangle = new Triangle(triangleBase, triangleHeight);
        System.out.printf("The area of the triangle is %.2f\n", triangle.getArea());
    }

}