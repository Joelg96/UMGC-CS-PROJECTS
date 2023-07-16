/* Joel Goode - CMIS242 - 7/1/2022
 * Create Media Class
 * Add an attribute to Media class to store indication when media object is rented versus available.
 * Add code to constructor and create get and set methods as appropriate.
 * Add any additional constructors and methods needed to support the below functionality
 */

public abstract class Media {

	// Variables
	private int id;
	private String title;
	private int year;
	private boolean isRented;

	// Constructor
	public Media(int id, String title, int year, boolean isRented) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.isRented = isRented;
	}
	
	//Setters and Getters
	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getTitle() {

		return title;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	public int getYear() {

		return year;

	}

	public void setYear(int year) {

		this.year = year;

	}

	public boolean isIsRented() {

		return isRented;

	}

	public void setIsRented(boolean isRented) {

		this.isRented = isRented;

	}
	
	public abstract double rentalFee();

}