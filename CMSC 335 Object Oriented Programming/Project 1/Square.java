/**
 * Joel Goode - CMSC 335 - March 25 2023
 * Square class represents a Square which is a TwoDimensionalShape.
 * It has a side which is used to calculate its area.
 * This class provides a static method to construct a Square object with user input.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Square extends TwoDimensionalShape {
    private float side;

    /**
     * Constructor for Square class.
     * 
     * @param side float value representing the length of the side of the Square
     */
    public Square(float side) {
        super();
        this.side = side;
    }

    /**
     * Getter method for the length of the side of the Square
     * 
     * @return float value representing the length of the side of the Square
     */
    public float getSide() {
        return side;
    }

    /**
     * Method to calculate the area of the Square
     * 
     * @return float value representing the area of the Square
     */
    public float getArea() {
        return side * side;
    }

    /**
     * Method to calculate the volume of the Square (always 0 for 2D shapes)
     * 
     * @return float value representing the volume of the Square (always 0 for 2D
     *         shapes)
     */
    public float getVolume() {
        return 0;
    }

    /**
     * Static method to construct a Square object with user input
     * Prompts the user to enter the length of the side of the Square and returns
     * the calculated area
     * 
     * @param scanner Scanner object used to read user input
     */
    public static void constructSquare(Scanner scanner) {
        System.out.println("**You Selected Square**\n");
        System.out.println("Enter the side length of the square:");
        float squareSide = 0;
        try {
            squareSide = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid float.");
            scanner.next(); // consume invalid input
            return;
        }
        Square square = new Square(squareSide);
        System.out.printf("The area of the square is %.2f\n", square.getArea());
    }

}