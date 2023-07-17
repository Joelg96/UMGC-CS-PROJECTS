/* Joel Goode - CMIS 242/4010 - 6/26/22
 * Implement GUIConverter class using JFrame and JPanel as follows:
 * GUI will have 3 buttons: “Distance Converter”, “Temperature Converter”, and “Exit”.
 * When user clicks Exit, the program will terminate
 * When user clicks Distance Converter, an input dialog will pop up where user can type value and click OK:
 * Once user clicks OK, message dialog will pop up:
 * When user clicks on Temperature button, an input dialog will pop up to input value
and then when clicks OK, the message dialog with pop up with converted result:
 */
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GUIConverter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // Not sure what this mean but the IDE was giving me an error (warning) otherwise. Auto inserted.

	public GUIConverter() {
		
		JFrame frame = new JFrame("Multiple Converter");
		frame.setLayout(new FlowLayout());
		
		// Give the frame an initial size.
		frame.setSize(500, 90);
		frame.setLocationRelativeTo(null);
		
		// Terminate the program when the user closes the application.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create three buttons.
		JButton distanceConverter = new JButton("Distance Converter");
		JButton tempConverter = new JButton("Temperature Converter");
		JButton exit = new JButton("Exit");
		
		// Add button to content pane
		frame.add(distanceConverter);
		frame.add(tempConverter);
		frame.add(exit);
		
		// Add action listener for distance converter
		distanceConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				DistanceConverter distanceConverter = new DistanceConverter();
				try {
					double distance = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Distance in Miles"));
					distanceConverter.setValue(distance);
					JOptionPane.showMessageDialog(rootPane,
							"Converted Distance is: " + distanceConverter.convert() + " km");
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(rootPane,
							"Converted Distance is:" + distanceConverter.convert() + "km");
				}
			}
		});
		
		// Add action listener for temperature converter.
		tempConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				TemperatureConverter tempConverter = new TemperatureConverter();
				try {
					double temp = Double
							.parseDouble(JOptionPane.showInputDialog("Please Enter Temperature in Fahrenheit"));
					tempConverter.setValue(temp);
					JOptionPane.showMessageDialog(rootPane, "Converted Temperature is: " + tempConverter.convert() + " C");
				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(rootPane, "Converted Temperature is: " + tempConverter.convert() + " C");
				}
			}
		});
		
		// Add action listener for exit button.
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				frame.dispose();
			}
		});
		
		// Display the frame.
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		
		// Create the frame on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				new GUIConverter();
			}
		});
	}
}
