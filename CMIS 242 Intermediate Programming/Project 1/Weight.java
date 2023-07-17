/* Joel Goode - CMIS 242/4010 - 5/22/22
 * 3 Private variables
 * 2 private methods
 * 4 public methodds
 */


public class Weight
{

	//Variables
	private final int OUNCES_IN_A_POUND = 16;
	private int pounds;
	private double ounces;
	
	// Public method for constructing weight.
	public Weight (int pounds, double ounces)
	{
		this.pounds = pounds;
		this.ounces = ounces;
		normalize();
		
		
	}

	// Public instance method to determine if weight is greater or less than normal values.
	public boolean lessThan (Weight weight)
	{
		if (this.pounds < weight.pounds)
		{
			return true;
		}
		else if (this.pounds == weight.pounds && this.ounces < weight.pounds)
		{
			return true;
		}
		else
			return false;
	}
	
	// Public instance method to accept weight values to .
	public void addTo (Weight weight)	
	{
		double weightOne = this.toOunces();
		double weightTwo = weight.toOunces();
		
		this.ounces = weightOne + weightTwo;
		normalize();
	}
	
	//Public instance method to display weight
	public String toString()
	{
		String info = this.pounds + " lbs " +  String.format("%.2f oz", this.ounces);
		return info;
	}
	
	// Private method to return total number of ounces.
	private double toOunces ()
	{
		double ounce = (this.pounds * OUNCES_IN_A_POUND) + this.ounces;
		return ounce;
	}
	
	// Private method to validate number of ounces in a pound.
	private void normalize ()
	{
		if (this.ounces > OUNCES_IN_A_POUND)
		{
			this.ounces -= 16;
			this.pounds += 1;
		}
	}
	
}
