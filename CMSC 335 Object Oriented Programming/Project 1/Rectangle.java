/* Joel Goode - CMSC 335 - March 25 2023
Rectangle class represents a Rectangle which is a TwoDimensionalShape.
It has a length and width which are used to calculate its area.
This class provides a static method to construct a Rectangle object with user input.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle extends TwoDimensionalShape {
    private float length;
    private float width;

    /**
     * Constructor for Rectangle class.
     * @param length float value representing the length of the Rectangle
     * @param width  float value representing the width of the Rectangle
     */
    public Rectangle(float length, float width) {
        super();
        this.length = length;
        this.width = width;
    }

    /**
     * Getter method for length of the Rectangle
     * @return float value representing the length of the Rectangle
     */
    public float getLength() {
        return length;
    }

    /**
     * Getter method for width of the Rectangle
     * @return float value representing the width of the Rectangle
     */
    public float getWidth() {
        return width;
    }

    /**
     * Method to calculate the area of the Rectangle
     * @return float value representing the area of the Rectangle
     */
    public float getArea() {
        return length * width;
    }

    /**
     * Method to calculate the volume of the Rectangle (always 0 for 2D shapes)
     * @return float value representing the volume of the Rectangle (always 0 for
     *         2D shapes)
     */
    public float getVolume() {
        return 0;
    }

    /**
     * Static method to construct a Rectangle object with user input
     * Prompts the user to enter the length and width of the Rectangle and returns
     * the calculated area 
     * @param scanner Scanner object used to read user input
     */
    public static void constructRectangle(Scanner scanner) {
        System.out.println("**You Selected Rectangle**\n");
        float rectangleLength = 0;
        float rectangleWidth = 0;
        try {
            System.out.println("Enter the length: ");
            rectangleLength = scanner.nextFloat();
            System.out.println("Enter the width: ");
            rectangleWidth = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid floats.");
            scanner.next(); // consume invalid input
            return;
        }
        Rectangle rectangle = new Rectangle(rectangleLength, rectangleWidth);
        System.out.printf("The area of the rectangle is %.2f\n", rectangle.getArea());
    }

}