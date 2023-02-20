 /* Joel Goode - CMIS141/4015 - March 1, 2022
  * 
  */

import java.util.InputMismatchException;
import java.util.Scanner;

public class AssignSix {

	// Method to determine lowest score.
	public static int lowestScore(int[] score)
	{
		int min, minSort, i; // Variables 
		  
		min = Integer.MAX_VALUE;
		minSort = 0;
		for(i = 0; i < score.length; i++)
		{
			if(score[i] < min)
			{
				min = score[i];
				minSort = i;
			}  
		}
		return minSort;
	}
	  
	  
	// Method to determine highest score.  
	public static int highestScore(int[] score)
	{
		int max, maxSort, i;// Variables
		
		max=Integer.MIN_VALUE;
		maxSort=0;
		for(i = 0; i < score.length; i++)
		{
			if(score[i]>max)
			{
				max=score[i];
				maxSort=i;
			}  
		}
		return maxSort;
	}
	  
	  
	  
	public static void main(String[] args) 
	{
	
		Scanner input = new Scanner(System.in);
	    
		// Variables and Array names for program.
		int numberTeams, i, lowSort, highSort;
		String[] teamName;
		int[] judgeScore;
		// Validate input of number of teams. Only integers.
		try 
		{
		System.out.println("\t**Please Enter Number of Teams, Team Name and Score"
				+ " to Determine Lowest Scoring Team and Highest Scoring Team**");
		System.out.print("How Many Teams do You Want to Enter?: ");
		numberTeams = input.nextInt();
		
		// Array for team names and team scores based on number of teams.
		teamName = new String[numberTeams]; 
		judgeScore = new int[numberTeams]; 
		
		for (i = 0; i < numberTeams; i++)
		{
			System.out.println("Team "+( i + 1) +":");
			System.out.print("Enter Team's Name:");
			teamName[i]=input.next();
			System.out.print("Enter Judge's Score (400-1000):");

			// while loop to validate input of score. numbers between 400-1000
			while(true)
			{
				judgeScore[i] = input.nextInt();
				if(judgeScore[i] >= 400 && judgeScore[i] <= 1000)
				{
					break;
				}
				else 
				{
					System.out.println("Entered Score Must Be An Integer Between 400-1000");
				}
			}
		}
	    // Variables calling methods   
		lowSort = lowestScore(judgeScore);
		highSort = highestScore(judgeScore);
		
		
	    //For loop to display all names and score of teams. 
		for (i = 0; i < judgeScore.length; i++) 
		{ 
			System.out.println(">Team Name: *"+teamName[i] + "* Judge's Score = "+ judgeScore[i]);
		}
		System.out.println();
		System.out.println("\t>>" + teamName[highSort] + " Has The Highest Score = " + judgeScore[highSort]);
		System.out.println("\t>>" + teamName[lowSort] + " Has The Lowest Score = " + judgeScore[lowSort]);
		} 
		catch(InputMismatchException e)
		{
			System.out.print("\n*******Invalid Input! Must Be An Integer!");     
		} 
	input.close();
	}
}

