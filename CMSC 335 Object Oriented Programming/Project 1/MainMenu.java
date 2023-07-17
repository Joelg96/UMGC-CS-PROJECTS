/* Joel Goode - CMSC 335 - March 25 2023 
 * The MainMenu class is a command-line driven menu for the Java Shapes Program. 
 * It allows a user to construct different TwoDimensional and ThreeDimensional shapes and get the corresponding area or volume. 
 * The menu loops until the user chooses to exit and includes error checks for invalid inputs. 
 * The class also displays a thank you message upon program termination.
*/

package Project_1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueProgram = true;

        System.out.println("*************Welcome to the Java Shapes Program**********\n");

        while (continueProgram) {
            displayMenu();

            int option = readOption();
            
            // Switch case selection menu for user to choose option
            switch (option) {
                case 1:
                    Circle.constructCircle(scanner);
                    break;

                case 2:
                    Rectangle.constructRectangle(scanner);
                    break;

                case 3:
                    Square.constructSquare(scanner);
                    break;

                case 4:
                    Triangle.constructTriangle(scanner);
                    break;

                case 5:
                    Sphere.constructSphere(scanner);
                    break;

                case 6:
                    Cube.constructCube(scanner);
                    break;

                case 7:
                    Cone.constructCone(scanner);
                    break;

                case 8:
                    Cylinder.constructCylinder(scanner);
                    break;

                case 9:
                    Torus.constructTorus(scanner);
                    break;

                case 10:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }

            // If User wants to continue
            if (continueProgram) {
                System.out.println("Would you like to continue? (Y or N)");
                String input = scanner.next();
                while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                    System.out.println("Invalid input. Enter Y or N");
                    input = scanner.next();
                }
                if (input.equalsIgnoreCase("N")) {
                    continueProgram = false;
                }
            }
        }

        // Close scanner and print exit message.
        scanner.close();
        printExitMessage();
    }

    // Display main menu
    private static void displayMenu() {
        System.out.println("Select from the menu below:");
        System.out.println("1. Construct a Circle");
        System.out.println("2. Construct a Rectangle");
        System.out.println("3. Construct a Square");
        System.out.println("4. Construct a Triangle");
        System.out.println("5. Construct a Sphere");
        System.out.println("6. Construct a Cube");
        System.out.println("7. Construct a Cone");
        System.out.println("8. Construct a Cylinder");
        System.out.println("9. Construct a Torus");
        System.out.println("10. Exit the program\n");
        System.out.println("Enter Option (1-10): ");
    }

    // Read user input
    private static int readOption() {
        int option = 0;

        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // consume invalid input
        }
        return option;
    }

    // Exit message and time.
    private static void printExitMessage() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d 'at' h:mm a");
        System.out.printf("Thanks for using the program. Today is %s.\n", now.format(format));
    }
}
