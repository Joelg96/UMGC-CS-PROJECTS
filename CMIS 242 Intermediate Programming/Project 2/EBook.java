/* Joel Goode - CMIS242 - 7/1/2022
 * Create EBook Child Class
 * Add an attribute to Media class to store indication when media object is rented versus available.
 * Add code to constructor and create get and set methods as appropriate.
 * Add any additional constructors and methods needed to support the below functionality
 */

public class EBook extends Media {

	// Variable
	private int numberOfChapters;

	// Constructor
	public EBook(int id, String title, int year, boolean isRented, int numberOfChapters) {
		
		super(id, title, year, isRented);
		this.numberOfChapters = numberOfChapters;
	}

	// Setters and Getters
	public int getNumberOfChapters() {
		
		return numberOfChapters;
	}

	public void setNumberOfChapters(int numberOfChapters) {
		
		this.numberOfChapters = numberOfChapters;
	}

	// Method to display data.
	public String toString() {

		return "EBook [id:" + this.getId() + " title:" + this.getTitle() + " chapter:" + this.getNumberOfChapters()
				+ " year:" + this.getYear() + " available:" + this.isIsRented() + "]\n";
	}

	// Method for rental fee
	public double rentalFee() {
		
		return 2.00;
	}

}