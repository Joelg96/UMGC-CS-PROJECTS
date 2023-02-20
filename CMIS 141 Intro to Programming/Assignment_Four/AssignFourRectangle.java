/* Joel Goode - CMIS141/4015 - February 10, 2022
 * Write Java code to prompt the user for the starting number to print.
 * Output rectangular pattern below: Use nested for-loops.
 * rows=9, columns=9
 */


import java.util.Scanner;


public class AssignFourRectangle 
{

	public static void main(String[] args) 
	{
		
        Scanner input = new Scanner(System.in);

        // Variables for program
        int row;
        int column;
        int startNumber;
        int min;
        
        
        
        // Prompt user to enter starting number 
        System.out.println("\t**Lets Create a Rectangle That Counts Down From a Number!**\n");
        System.out.print("Enter The Starting Number: ");
        startNumber = input.nextInt();
      
        
        // Validating and output rectangle. upper left of rectangle
        for(row = 1; row <= startNumber; row++)
		{   
        	for(column = 1; column <= startNumber; column++)
        	{   
        		if(row < column)
        		{
        		min = row;
        		}
        		else
        		{
        		min = column;
        		}
        		System.out.print(startNumber - min + 1+ " ");   
			}
		
        	
        	
        		// Upper Right of rectangle.
        		for (column = startNumber - 1; column >= 1; column--)
        		{
        			if(row < column)
        			{
        			min = row;
        			}
        			else
        			{
        			min = column;
        			}
        			System.out.print(startNumber - min + 1+ " ");   
        		}   
        			System.out.println();
		}   
        
        
        
		// Lower Left of rectangle.
		for (row = startNumber - 1; row >= 1; row--)
		{   
			for (column = 1; column <= startNumber; column++)
			{
				if(row < column)
				{
				min = row;
				}
				else
				{
				min = column;
				}
				System.out.print(startNumber - min + 1+ " ");   
			}   
		
		
			// Lower Right of rectangle.
			for (column = startNumber - 1; column >= 1; column--)
			{   
				if(row < column)
				{
				min = row;
				}
				else
				{
				min = column;
				}
				System.out.print(startNumber - min + 1+ " ");   
			}   
				System.out.println();
		}  
			input.close();
		
	}
}

