/* Joel Goode - CMIS141/4015 - February 5, 2022
 * Write a Java program to calculate a gamer's total XP score with a bonus per level.
 * Prompt and read user’s input for the gamer's name
 * Level 1 XP (L1), Level 2 XP (L2), Level 3 XP (L3), and Engagement score (ES).User Scanner to read input
 * Each XP score input should be in whole numbers between 10-100 and in increments of 5.
 */




import java.util.Scanner;

public class Assign3 {

	public static void main(String[] args) {
	
		// Variables for Program
		Scanner input = new Scanner(System.in);
		String name;
		char menu; 
		int lvl1, lvl2, lvl3, engageScore;
		double score;
		boolean play = true;
		
		
		
			// Loop to determine user continuation or exit.	
			while(play)
			{
				//Main Menu 
				System.out.println("\t**Welcome to Game XP Calculator**\n");
				System.out.println("Please Select an Option(1) or (2):");
				System.out.println("(1) Calculate Gamer's Total XP");
				System.out.println("(2) Exit Calculator");
				System.out.print("Enter Option Here: ");
				menu = input.next().charAt(0);
				
				if(menu == '2')
				{
					System.out.print("\nGoodbye. Exiting.....");
					System.exit(0);
				}
				else if(menu == '1')
				{
					play = true;
				}
				else
				{
					System.out.println("!*Invalid Input*!");
					continue;
				}
				input.nextLine();
				System.out.print("\nEnter Gamer Name: ");
				name = input.nextLine();
				
				System.out.print("Level 1 XP (lvl1): ");
				lvl1 = input.nextInt();

				
				// Score input Validation.

				while(lvl1 < 10 || lvl1 > 100 || (lvl1 % 5 != 0))
				{
					System.out.print("Number Must be Within 10-100 and Multiples of 5!! Enter  Here Again: ");
					lvl1 = input.nextInt();
				}
				
				System.out.print("Level 2 XP (lvl2): ");
				lvl2 = input.nextInt();
				while(lvl2 < 10 || lvl2 > 100 || (lvl2 % 5 != 0))
				{
					System.out.print("Number Must be Within 10-100 and Multiples of 5!! Enter Here Again: ");
					lvl2 = input.nextInt();
				}
				
				System.out.print("Level 3 XP (lvl3): ");
				lvl3 = input.nextInt();
				while(lvl3 < 10 || lvl3 > 100 || (lvl3 % 5 != 0))
				{
					System.out.print("Number Must be Within 10-100 and Multiples of 5!! Enter Here Again: ");
					lvl3 = input.nextInt();
				}
				
				System.out.print("Enter Engagement Score (ES): ");
				engageScore = input.nextInt();
				while(engageScore < 10 || engageScore > 100 || (engageScore % 5 != 0)) 
				{	
					System.out.print("Number Must be Within 10-100 and Multiples of 5! Enter Here Again : ");
					engageScore = input.nextInt();
				}
					
				
				//Calculate total XP
				score = lvl1 + lvl1 * 0.20 + lvl2 + lvl2 * 0.30 + lvl3 + lvl3 * 0.50 + engageScore + engageScore * 0.60;
		
				// Display Gamer's Data.
				System.out.println("\n\t***GAMER: *" + name + "'s* SCORE***");
				System.out.println("Level 1 XP(lvl1): " + lvl1);
				System.out.println("Level 2 XP(lvl2): " + lvl2);
				System.out.println("Level 3 XP(lvl3): " + lvl3);
				System.out.println("Engagement score(ES) XP: " + engageScore);
				System.out.printf("**Total XP**: %.0f", score);
				input.nextLine();	
		
		
		
		// Ask User if they want to run program again.
		play = false;
		if (play==false)
		    System.out.println("\n\t**Run Calculator Again? (1) Continue or (2) EXIT**");
			System.out.print("Enter Here: ");
		    char again = input.next().charAt(0);
		        if (again == '1')
		        {
		        play=true;
		        }
		        else if (again == '2')
		        {
		        System.out.println("Thank you! Exiting....");
		        System.exit(0);
		        }
		        else
		        {
		        System.out.println("!*Invalid Input*!");
		        }
			}
	input.close();
	}
}

	

