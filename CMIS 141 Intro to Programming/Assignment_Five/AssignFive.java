/* Joel Goode - CMIS141/4015 - February 21, 2022
 * (1) Prompt the user which action they want to take:
 * (a) Convert cubic feet to U.S. bushels
 * (b) Convert miles to kilometers
 * (c) Determine graduation with honors title
 * (d) Exit program
 * (2) Programs at a minimum must have the following methods:
 * (a) Convert square feet method gets square feet and returns cubic yards
 * (b) Convert to height method that gets height in inches and returns meters
 * (c) Determine graduation with honors title method that gets GPA and returns honors title value
 * (4) User should be able to select one action and then get prompted again for selection until they select exit choice
 */


import java.util.Scanner;


public class AssignFive {
	
	// Main Menu Method.
	public static void mainMenu() 

	{
		System.out.println("\n\t***Main Menu***\n");
		System.out.println("Please Choose An option:");
        System.out.println("(1) Convert Cubic Feet to U.S. Bushels");
        System.out.println("(2) Convert Miles to Kilometers");
        System.out.println("(3) Determine Graduation with Honors Title");
        System.out.println("(0) Exit");
	}
	
	
	// Cubic Feet to Bushels conversion method.
	public static double cubicToBushels(double cubicFeet)
	{
		//1 cubic foot = 0.803564 U.S. bushel;
		return cubicFeet * 0.803564;
	}
	

	// Miles to KM conversion method
	public static double milesToKm(double miles)
	{
		// 1 mile = 1.60934 km
		return miles * 1.60934;
	}

	
	// Determination of graduation honors title method.
	public static String honorsTitle(double gpa) 
	{
		if(gpa >= 3.5 && gpa <= 3.7)
		{
			return "Cum Laude";
		}
			else if(gpa >= 3.8 && gpa <= 3.9 )
			{
				return "Magna Cum Laude";
			}
			else if(gpa >= 4.0)
			{
				return "Summa Cum Laude";
			}
			else
			{
				return "INVALID INPUT";
				
			}
			
	}

	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		// Variables for Program.
		double cubicFeet, miles, gpa;
		char choice;
		
		// Do-while loop to determine user choice and calculate choice.
		do
		{
		mainMenu();
			
		// Prompt User to enter menu choice.
		System.out.print("Enter Choice Here: ");
		choice = input.next().charAt(0);
			
		// Switch statement for user's menu choice.
		switch(choice)
		{
			case '1':
				{
					System.out.print("Enter Cubic Feet: ");
					cubicFeet = input.nextDouble();
					System.out.printf("%.2f Cubic Feet is Equal to %.2f U.S. Bushel(s)\n", cubicFeet, cubicToBushels(cubicFeet));
					break;
				}
			
			case '2':
				{
					System.out.print("Enter Miles: ");
					miles = input.nextDouble();
					System.out.printf("%.2f Miles is equal to %.2f km\n", miles, milesToKm(miles));
					break;
				}
					
			case '3':
				{
					System.out.print("Enter GPA: ");
					gpa = input.nextDouble();
					System.out.println("Well Done! Congratulations! You graduated from " + honorsTitle(gpa) +  " with Honors!\n");
					break;
				}
					
			case '0':
				{
					System.out.println("\t\nFarewell! Goodbye!");
					input.close();	
					System.exit(0);
				}
					
			default: 
				{
					System.out.println("\t**Please Choose a Valid Selection! (0),(1),(2),(3)**\n");
				}
		}		
		} while(true);
		
	}
}
