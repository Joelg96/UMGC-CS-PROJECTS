/* Joel Goode -CMIS242 - 7/1/2022
 * user interface which is either menu driven through console commands or GUI buttons or menus. 
 * Look at the bottom of this project file for sample look and feel. 
 * Selection to load Media files from a given directory (user supplies directory)
 * selection to find a media object for a specific title value
 * selection to rent a media object based on its id value 
 * selection to exit program
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class MediaRentalSystem extends javax.swing.JFrame {

	// Variables
	private javax.swing.JMenu mainMenu;
	private javax.swing.JMenuBar headerBar;
	private javax.swing.JMenuItem loadMenu;
	private javax.swing.JMenuItem findMenu;
	private javax.swing.JMenuItem rentMenu;
	private javax.swing.JMenuItem quit;
	private static final long serialVersionUID = 1L;

	// Constructor
	public MediaRentalSystem() {

		setFont(new Font("Arial", Font.BOLD, 12));
		setForeground(Color.DARK_GRAY);
		initComponents();
	}

	Manager manager = new Manager();

	// Method to create and format GUI options and look
	private void initComponents() {

		// JMenus and the respective action listeners
		headerBar = new javax.swing.JMenuBar();
		mainMenu = new javax.swing.JMenu();
		mainMenu.setFont(new Font("Arial", Font.BOLD, 14));
		loadMenu = new javax.swing.JMenuItem();
		loadMenu.setFont(new Font("Arial", Font.BOLD, 12));
		findMenu = new javax.swing.JMenuItem();
		findMenu.setFont(new Font("Arial", Font.BOLD, 12));
		rentMenu = new javax.swing.JMenuItem();
		rentMenu.setFont(new Font("Arial", Font.BOLD, 12));
		quit = new javax.swing.JMenuItem();
		quit.setFont(new Font("Arial", Font.PLAIN, 12));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Welcome To Media Rental System ");
		mainMenu.setText("MEDIA MENU");

		loadMenu.setText("> Load Media");
		loadMenu.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mainMenuMouseClicked(evt);
			}
		});

		loadMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadMenuActionPerformed(evt);
			}
		});

		mainMenu.add(loadMenu);

		findMenu.setText("> Find Media");
		findMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				findMenuActionPerformed(evt);
			}
		});

		mainMenu.add(findMenu);

		rentMenu.setText("> Rent Media");
		rentMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rentMenuActionPerformed(evt);
			}
		});

		mainMenu.add(rentMenu);

		quit.setText("> Quit ");
		quit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuActionPerformed(evt);
			}
		});

		mainMenu.add(quit);
		headerBar.add(mainMenu);
		setJMenuBar(headerBar);

		// Added label to help user know what to do.
		JLabel tag = new JLabel("Welcome! Select an option from the drop down menu at the top.");
		tag.setForeground(Color.BLACK);

		// Layout
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
		layout.createSequentialGroup().addContainerGap(32, Short.MAX_VALUE)
		.addComponent(tag, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
		.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
		layout.createSequentialGroup().addContainerGap(98, Short.MAX_VALUE)
		.addComponent(tag, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE).addGap(72)));
		getContentPane().setLayout(layout);
		pack();
		setLocationRelativeTo(null);
	} // end of GUI internal options

	// Method for main menu Action handler
	private void mainMenuMouseClicked(java.awt.event.MouseEvent evt) {

	}

	// Method for load menu Action handler
	private void loadMenuActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(""));
        int fChooser = chooser.showOpenDialog(null);
        if (fChooser == JFileChooser.APPROVE_OPTION) {

            File file =  new File (chooser.getSelectedFile().getAbsolutePath());
            System.out.println("You chose to open this file: " + chooser.getSelectedFile());
            String filename = file.getName();
            System.out.println("You have selected: " + filename);
            manager.LoadMedia(file);
        }
    }

	// Method for find menu Action handler
	private void findMenuActionPerformed(java.awt.event.ActionEvent evt) {

		String title = JOptionPane.showInputDialog(null, "Enter The Title");
		manager.findMedia(title);
	}

	// Method for rent menu Action handler
	private void rentMenuActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String id = JOptionPane.showInputDialog(null, "Enter The Id");
		manager.rentMedia(Integer.parseInt(id));

	}

	// Method for exit menu Action handler
	private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {

			java.util.logging.Logger.getLogger(MediaRentalSystem.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {

			java.util.logging.Logger.getLogger(MediaRentalSystem.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {

			java.util.logging.Logger.getLogger(MediaRentalSystem.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {

			java.util.logging.Logger.getLogger(MediaRentalSystem.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}

		// Display GUI
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MediaRentalSystem().setVisible(true);
			}
		});
	}
}