/* Joel Goode - CMIS 242/4010 - 6/26/22
 * DistanceConverter class which is a child of Converter 
 * Constructors which call parent constructors
 * Overridden convert() method to convert input (distance in miles)
 *  to distance in kilometers and returns the value.
 *  f the instance has no input value, it should return Double.NaN
 *  Use the following formula for conversion: KM = M * 1.609
 */

import java.text.DecimalFormat;

public class DistanceConverter extends Converter {
	
	// Constructor
	public DistanceConverter() {
		
		super();
	}

	// Parameterized constructor to set value overloading method
	public DistanceConverter(double value) {
		
		super(value);
	}

	// Method converts distance in miles to km
	@Override
	public double convert() {
		
		DecimalFormat decimal = new DecimalFormat("#.##");
		double km = 0;
		
		if (Double.isNaN(value)) {
			km = Double.NaN;
		} else {
			km = value * 1.609;
			km = Double.valueOf(decimal.format(km));
		}
		return km;
	}
}
