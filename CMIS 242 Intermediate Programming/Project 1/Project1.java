/* Joel Goode - CMIS 242/4010 - 5/22/22
 * 3 private methods
 * 1 public method
 */



public class Project1 
{

	
	public static void main(String[] args) 
	{
		// Creating the three weight object values
		Weight weightOne = new Weight (11, 3);
		Weight weightTwo = new Weight (7, 20);
		Weight weightThree = new Weight (14, 6);
		
	
		//Displaying minimum, maximum & average weights 
		System.out.println("Weight 1: " + weightOne.toString());
		System.out.println("Weight 2: " + weightTwo.toString());
		System.out.println("Weight 3: " + weightThree.toString());
		
		findMinimum(weightOne, weightTwo, weightThree);
		
		findMaximum(weightOne, weightTwo, weightThree);
		
		findAverage(weightOne, weightTwo, weightThree);

	}
	
	// Method to find weight min and Displaying the values of the three weights
	private static Weight findMinimum (Weight weightOne, Weight weightTwo, Weight weightThree)
	{
		System.out.println("\nMinimum Weight is: ");
				
		if (weightOne.lessThan(weightTwo) && weightOne.lessThan(weightThree)) 
		{
			System.out.println("==> " + weightOne);
			return weightOne;
		}
		else if (weightTwo.lessThan(weightOne) && weightTwo.lessThan(weightThree))
		{
			System.out.println("==> " + weightTwo);	
			return weightTwo;
		}
		else 
		{
			System.out.println("==> " + weightThree);
			return weightThree;
		}
	}
	
	// Method to find max and displaying the values of the three weights
	private static Weight findMaximum (Weight weightOne, Weight weightTwo, Weight weightThree) 
	{
		//Displaying the values of the three weights
		
		System.out.println("Maximum Weight is: ");
		
		if (!weightOne.lessThan(weightTwo) && !weightOne.lessThan(weightThree))
		{
			System.out.println("==> " + weightOne);
			return weightOne;
		}
		else if (!weightTwo.lessThan(weightOne) && !weightTwo.lessThan(weightThree))
		{
			System.out.println("==> " + weightTwo);			
			return weightTwo;
		}
		else 
		{
			System.out.println("==> " + weightThree);
			return weightThree;
		}
	}
	
	
	// Method to find average
	private static Weight findAverage (Weight weightOne, Weight weightTwo, Weight weightThree)
	{
		// creating a temporary weight object to store the weight of all the 3 passed weight object argument
		Weight temp = new Weight(0,0);
		
		// adding weight of all the passed weight arguments
		temp.addTo(weightOne);
		temp.addTo(weightTwo);
		temp.addTo(weightThree);

		// x pounds and y ounces
		String[] weights = temp.toString().split(" ");

		// Get pounds and ounces string and converting it into integer and doubling ounces and then divide it by 3 to get average
		int pounds = Integer.parseInt(weights[0]) / 3;
		double ounces = Double.parseDouble(weights[2]) / 3;

		pounds = (int)(pounds + ounces / 16);
		ounces = ounces % 16;

		Weight newWeight = new Weight(pounds, ounces);

		System.out.println("The Average Weight is: \n==> " + newWeight.toString()); 
		return newWeight;

	}
}

