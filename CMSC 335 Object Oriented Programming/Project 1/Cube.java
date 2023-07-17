/* Joel Goode - CMSC 335 - March 25th 2023
Cube class represents a Cube which is a ThreeDimensionalShape.
It has a side length which is used to calculate its area and volume.
This class provides a static method to construct a Cube object with user input.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cube extends ThreeDimensionalShape {
    private float side;

    /**
     * Constructor for Cube class.
     * @param side float value representing the side length of the Cube
     */
    public Cube(float side) {
        super();
        this.side = side;
    }

    /**
     * Getter method for side length of the Cube
     * @return float value representing the side length of the Cube
     */
    public float getSide() {
        return side;
    }

    /**
     * Method to calculate the surface area of the Cube
     * @return float value representing the surface area of the Cube
     */
    public float getArea() {
        return 6 * side * side;
    }

    /**
     * Method to calculate the volume of the Cube
     * @return float value representing the volume of the Cube
     */
    public float getVolume() {
        return side * side * side;
    }

    /**
     * Static method to construct a Cube object with user input
     * Prompts the user to enter the side length of the Cube and returns the
     * calculated volume
     * @param scanner Scanner object used to read user input
     */
    public static void constructCube(Scanner scanner) {
        System.out.println("**You Selected Cube**\n");
        System.out.println("Enter the side length of the cube:");
        float cubeSide = 0;
        try {
            cubeSide = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid float.");
            scanner.next(); // consume invalid input
            return;
        }
        Cube cube = new Cube(cubeSide);
        System.out.printf("The volume of the cube is %.2f\n", cube.getVolume());
    }

}