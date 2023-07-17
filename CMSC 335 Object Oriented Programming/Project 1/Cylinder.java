/* Joel Goode - CMSC 335 - March 25 2023
Cylinder class represents a Cylinder which is a ThreeDimensionalShape.
It has a radius and a height which are used to calculate its area and volume.
This class provides a static method to construct a Cylinder object with user input.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cylinder extends ThreeDimensionalShape {
    private float radius;
    private float height;

    /**
     * Constructor for Cylinder class.
     * @param radius float value representing the radius of the Cylinder
     * @param height float value representing the height of the Cylinder
     */
    public Cylinder(float radius, float height) {
        super();
        this.radius = radius;
        this.height = height;
    }

    /**
     * Getter method for radius of the Cylinder
     * @return float value representing the radius of the Cylinder
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Getter method for height of the Cylinder
     * @return float value representing the height of the Cylinder
     */
    public float getHeight() {
        return height;
    }

    /**
     * Method to calculate the area of the Cylinder
     * @return float value representing the area of the Cylinder
     */
    public float getArea() {
        return (float) (2 * Math.PI * radius * (radius + height));
    }

    /**
     * Method to calculate the volume of the Cylinder 
     * @return float value representing the volume of the Cylinder
     */
    public float getVolume() {
        return (float) (Math.PI * radius * radius * height);
    }

    /**
     * Static method to construct a Cylinder object with user input
     * Prompts the user to enter the radius and height of the Cylinder and returns
     * the calculated volume
     * @param scanner Scanner object used to read user input
     */
    public static void constructCylinder(Scanner scanner) {
        System.out.println("**You Selected Cylinder**\n");
        float cylinderRadius = 0;
        float cylinderHeight = 0;
        try {
            System.out.println("Enter the radius: ");
            cylinderRadius = scanner.nextFloat();
            System.out.println("Enter the height: ");
            cylinderHeight = scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid floats.");
            scanner.next(); // consume invalid input
            return;
        }
        Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
        System.out.printf("The volume of the cylinder is %.2f\n", cylinder.getVolume());
    }

}