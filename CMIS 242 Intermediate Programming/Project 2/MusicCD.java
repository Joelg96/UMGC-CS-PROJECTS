/* Joel Goode - CMIS242 - 7/1/2022
 * Create MusicCD Child Class
 * Add an attribute to Media class to store indication when media object is rented versus available.
 * Add code to constructor and create get and set methods as appropriate.
 * Add any additional constructors and methods needed to support the below functionality
 */

public class MusicCD extends Media {

	// Variable
	private int length;
	
	//Constructor
	public MusicCD(int id, String title, int year, boolean isRented, int length) {

		super(id, title, year, isRented);
		this.length = length;
	}

	// Setters and Getters
	public int getLength() {

		return length;
	}

	public void setLength(int length) {

		this.length = length;
	}

	
	// Method to convert data to String to display
	public String toString() {

		return "MusicCD [id:" + this.getId() + " title:" + this.getTitle() + " Length:" + this.getLength() + " year:"
				+ this.getYear() + " available:" + this.isIsRented() + "]\n";

	}

	
	public double rentalFee() {

		return 2.00;
	}

}