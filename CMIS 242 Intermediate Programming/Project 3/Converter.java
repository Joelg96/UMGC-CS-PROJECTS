/* Joel Goode - CMIS 242/4010 - 6/26/22
 * Implement converter class hierarchy
 * Private attribute for input of data type double
 * Default constructor with no parameter which sets input to Double.NaN
 * Overloaded constructor with input for parameter
 * Get and set methods for input attribute
 * Method convert() which returns input value
 */

public class Converter {
	
	// Variables
	protected double value;

	// Constructor sets value to NaN
	public Converter() {
		
		value = Double.NaN;
	}

	// Parameterized constructor to set value overloading method
	public Converter(double value) {
		
		this.value = value;
	}
	
	// Setters and getters.
	public double getValue() {
		
		return value;
	}

	public void setValue(double value) {
		
		this.value = value;
	}

	// Method to return inputed value
	public double convert() {
		return value;
	}
}
