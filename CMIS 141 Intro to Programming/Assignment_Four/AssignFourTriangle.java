/* Joel Goode - CMIS141/4015 - February 10, 2022
 * Write Java code to prompt the user for the starting number.
 * Output the triangle pattern below using nested for-loops.
 * 
 */


import java.util.Scanner;

public class AssignFourTriangle 
{

	public static void main(String[] args) 
	{
		
		Scanner input = new Scanner(System.in);
		
		// Variables for program.
		int length = 6;
		int row;
		int column;
		int startNumber;
		int add;

		
		// Prompt user to enter starting number for triangle.
		System.out.println("\t**Lets Build a Triangle Which Counts!**\n");
		System.out.print("Please Enter Starting Number: ");
		startNumber = input.nextInt();
		
		
		// For loop to make triangle shape.
		for(row = 0; row <= length; row++)
	    {
			add = startNumber;
			for(column = 0; column <= row; column++)
	    	{
	    	System.out.print(add + " ");
	    	add++;
	    	}
	    	System.out.println(); 
	    }

    	input.close(); 
	}	
}
 