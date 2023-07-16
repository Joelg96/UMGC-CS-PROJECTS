
/* Joel Goode - CMIS242 - 7/1/2022
 * stores a list of Media objects
 * Has functionality to load Media objects from files
 * Creates/updates Media files 
 * has functionality to add new Media object to its Media list
 * has functionality to find all media objects for a specific title and returns that list
 * has functionality to rent Media based on id (updates rental status on media, updates file, returns rental fee)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Manager {

	static List<Media> mediaList = new ArrayList<>();

	// Constructor
	Manager() {

	}

	// Method to load Media files into program
	public void LoadMedia(File inputFile) {

		try (Scanner myReader = new Scanner(inputFile)) {

			while (myReader.hasNextLine()) {

				String data = myReader.nextLine();
				System.out.println(data);
				if (data.contains("<EBook>")) {

					mediaList.add(new EBook(
							Integer.parseInt(data.substring(data.indexOf("<id>") + 4, data.indexOf("</id>"))),
							data.substring(data.indexOf("<title>") + 7, data.indexOf("</title>")),
							Integer.parseInt(data.substring(data.indexOf("<year>") + 6, data.indexOf("</year>"))),
							Boolean.parseBoolean(
									data.substring(data.indexOf("<available>") + 11, data.indexOf("</available>"))),
							Integer.parseInt(
									data.substring(data.indexOf("<chapters>") + 10, data.indexOf("</chapters>")))));

				} else if (data.contains("MusicCD")) {

					mediaList.add(new MusicCD(
							Integer.parseInt(data.substring(data.indexOf("<id>") + 4, data.indexOf("</id>"))),
							data.substring(data.indexOf("<title>") + 7, data.indexOf("</title>")),
							Integer.parseInt(data.substring(data.indexOf("<year>") + 6, data.indexOf("</year>"))),
							Boolean.parseBoolean(
									data.substring(data.indexOf("<available>") + 11, data.indexOf("</available>"))),
							Integer.parseInt(data.substring(data.indexOf("<length>") + 8, data.indexOf("</length>")))));

				} else {

					mediaList.add(new MovieDVD(
							Integer.parseInt(data.substring(data.indexOf("<id>") + 4, data.indexOf("</id>"))),
							data.substring(data.indexOf("<title>") + 7, data.indexOf("</title>")),
							Integer.parseInt(data.substring(data.indexOf("<year>") + 6, data.indexOf("</year>"))),
							Boolean.parseBoolean(
									data.substring(data.indexOf("<available>") + 11, data.indexOf("</available>"))),
							Integer.parseInt(data.substring(data.indexOf("<length>") + 8, data.indexOf("</length>")))));

				}
			}
			JOptionPane.showMessageDialog(null, mediaList);
			myReader.close();
		} catch (FileNotFoundException e) {

          JOptionPane.showMessageDialog(null, "File cannot be opened: Could not load, no such directory.");
		}

	}

	// Method to find Media in program
	public void findMedia(String title) {
		String result = " ";
		boolean found = false;
		for (int i = 0; i < mediaList.size(); i++) {

			if (mediaList.get(i).getTitle().equals(title)) {
				result += mediaList.get(i).toString();
				System.out.print(mediaList.get(i).toString());
				found = true;
			}
		}
		if (result.isEmpty()) {

			JOptionPane.showMessageDialog(null, "No Media Was Found");
		}

		if (!found) {
			JOptionPane.showMessageDialog(null, "There is no media with title: " + title);
		}

		if (found) {
			JOptionPane.showMessageDialog(null, "The media: '" + title + "' is in the system");

		}
	}

	// Method to rent media in program
	public void rentMedia(int id) {

		// Variable
		boolean found = false;

		for (Media media : mediaList) {

			if (media.getId() == id) {

				found = true;
				if (media.isIsRented()) {

					JOptionPane.showMessageDialog(null,
							"Media " + id + " successfully rented out! Rental Fee: $" + media.rentalFee());
				} else {

					JOptionPane.showMessageDialog(null, "Media with id: " + id + " is not available for rent ");
					break;
				}
			}

		}

		if (!found) {

			JOptionPane.showMessageDialog(null, "The media id: " + id + " is not found ");
		}

	}
}