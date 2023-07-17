/* Joel Goode - CMIS 242/4010 - 6/26/22
 * Constructors which call parent constructors
 * Overridden convert() method to convert input (Fahrenheit temperature) to Celsius and returns the value.
 * If the instance has no input value, it should return Double.NaN
 * Use the following formula for conversion: C = ((F-32)*5)/9
 */
import java.text.DecimalFormat;

public class TemperatureConverter extends Converter {
	
	// Constructor
	public TemperatureConverter() {
		
		super();
	}
	
	// Parameterized constructor to set value overloading method
	public TemperatureConverter(double value) {
		
		super(value);
	}

	// Convert method that converts tempearture from fahrenheit to celsius
	@Override
	public double convert() {
		
		DecimalFormat decimal = new DecimalFormat("#.##");
		double celsius = 0;
		
		if (Double.isNaN(value)) {
			celsius = Double.NaN;
		} else {
			celsius = ((value - 32) * 5) / 9;
			celsius = Double.valueOf(decimal.format(celsius));
		}
		return celsius;
	}

}
