/* Joel Goode - CMIS141/4015 - January, 2022
 * Prompts a user to enter two numbers between 200 and 1000 and a symbol for operation such as ‘+’, ‘-‘, ‘*’, and ‘/’
 * Code uses nested if statement or switch to perform the operation on the two numbers
 * If the provided symbol is valid, displays the input data along with the result of the calculation to the console.
 * Otherwise displays an error message
 */


import java.util.Scanner;

public class Assign2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 	

		//Variables for program:
		double numOne;
		double numTwo;
		char operator;
		double solution;		
		
		// Prompt user to enter two numbers between 200 and 1000.
		System.out.println("\t**Please Enter Two Numbers Between 200-1000**\n");
		System.out.print("Enter First Number: ");
		numOne = input.nextDouble();
		
		System.out.print("Enter Second Number: ");
		numTwo = input.nextDouble();
		
		//Prompt user for a symbol of operation such as ‘+’, ‘-‘, ‘*’, and ‘/’.
		System.out.println("\n\t**Choose an Operator Such as: ‘+’, ‘-‘, ‘*’, and ‘/’**\n");
		System.out.print("Enter Operator: ");
		operator = input.next().charAt(0);
	
		
		
		
		// Perform operation on inputed numbers and inputed operation +,-,*,/ using switch statement.
		switch(operator) {
			
			case '+':
				solution = numOne + numTwo;
				System.out.printf(numOne + " + " + numTwo + " = %,.3f",solution);
				break;
			
			case '-':
				solution = numOne - numTwo;
				System.out.printf(numOne + " - " + numTwo + " = %,.3f",solution);
				break;
			
			case '*':
				solution = numOne * numTwo;
				System.out.printf(numOne + " * " + numTwo + " = %,.3f",solution);
				break;
			
			case '/':
				solution = numOne / numTwo;
				System.out.printf(numOne + " / " + numTwo + " = %,.3f",solution);
				break;
			
			default:
				System.out.println("*Operator Invalid! Try Again!*");
			
		}
			

		
	input.close();
		
	}

}
