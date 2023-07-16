/* Joel Goode - CMIS242 - 7/1/2022
 * Create MovieDVD Child Class
 * Add an attribute to Media class to store indication when media object is rented versus available.
 * Add code to constructor and create get and set methods as appropriate.
 * Add any additional constructors and methods needed to support the below functionality
 */

public class MovieDVD extends Media {

	// Variable
	private double size;

	// Constructor
	public MovieDVD(int id, String title, int year, boolean isRented, double megaBytes) {

		super(id, title, year, isRented);
		this.size = megaBytes;
	}

	// Setters and getters
	public double getMegaBytes() {

		return size;
	}

	public void setMegaBytes(double megaBytes) {

		this.size = megaBytes;
	}

	// Mehthod to diplay data
	public String toString() {

		return "MovieDVD  [id:" + this.getId() + "  title:" + this.getTitle() + "  Size:" + this.getMegaBytes()
				+ "  year:" + this.getYear() + "  available:" + this.isIsRented() + "]\n";
	}

	// Method for rental fee
	public double rentalFee() {

		return 2.00;
	}
}