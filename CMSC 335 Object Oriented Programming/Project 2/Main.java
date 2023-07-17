/**
 * Joel Goode 
 * CMSC 335 Project 2
 * 4/10/2023
 * This is the main class for a graphical user interface application that allows users to calculate the area and volume
 * of various 2D and 3D shapes. It includes a box where users can select the shape they want to calculate, t
 * ext fields for entering the dimensions of the shape, 
 * a button for performing the calculation, and an area for displaying the result.
 * The application also displays an image of the selected shape.
 */


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Choice;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {

    public static JButton constructButton = new JButton();
    public static JTextField areaVolumeDisplay = new JTextField();
    public static JLabel imageLabel = new JLabel();
    public static JTextField inputTextOne = new JTextField();
    public static JTextField inputTextTwo = new JTextField();

    public static void main(String[] args) {



        // GUI Components
        JFrame mainFrame = new JFrame("Java Calculator Shape Visualizer");
        mainFrame.setSize(800, 600);
        Container contentPane = mainFrame.getContentPane();
        contentPane.setLayout(null);
        Font font = new Font(Font.DIALOG,  Font.BOLD, 20);
        JLabel menuLabel = new JLabel("Select shape");
        menuLabel.setFont(font);
        menuLabel.setBounds(10, 10, 150, 30 );

        Choice selectedShape = new Choice();
        selectedShape.setBounds(170, 10, 150, 30);
        selectedShape.setFont(font);
        selectedShape.add("");
        selectedShape.add("Circle");
        selectedShape.add("Square");
        selectedShape.add("Triangle");
        selectedShape.add("Rectangle");
        selectedShape.add("Sphere");
        selectedShape.add("Cube");
        selectedShape.add("Cone");
        selectedShape.add("Cylinder");
        selectedShape.add("Torus");
        contentPane.add(menuLabel);
        contentPane.add(selectedShape);
        
        JLabel inputLabelOne = new JLabel();
        inputLabelOne.setFont(font);
        inputLabelOne.setBounds(10, 50, 150, 30);
        inputTextOne.setFont(font);
        inputTextOne.setBounds(170, 50, 150, 30);
        JLabel inputLabelTwo = new JLabel("");
        inputLabelTwo.setFont(font);
        inputLabelTwo.setBounds(10, 90, 150, 30);
        inputTextTwo.setFont(font);
        inputTextTwo.setBounds(170, 90, 150,30);
        constructButton.setBounds(400, 50, 250, 30);
        constructButton.setFont(font);
        areaVolumeDisplay.setEditable(false);
        areaVolumeDisplay.setBounds(200, 130, 600, 30);
        areaVolumeDisplay.setFont(font);
        imageLabel.setBounds(10, 170, 680, 380 );
        contentPane.add(imageLabel);
        contentPane.add(areaVolumeDisplay);
        contentPane.add(constructButton);
        contentPane.add(inputLabelOne);
        contentPane.add(inputTextOne);
        contentPane.add(inputLabelTwo);
        contentPane.add(inputTextTwo);
        areaVolumeDisplay.setVisible(false);
        constructButton.setVisible(false);
        inputLabelOne.setVisible(false);
        inputTextOne.setVisible(false);
        inputLabelTwo.setVisible(false);
        inputTextTwo.setVisible(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);


        // Action Listeners for 2D Shapes: Circle, Square, Triangle, Rectangle
        ActionListener circle = e -> {
            try {
                double radius = Double.parseDouble(inputTextOne.getText());
                areaVolumeDisplay.setText("Area of circle = " + DataValues.getAreaOfCircle(radius));
                areaVolumeDisplay.setVisible(true);
                JFrame jframe = new JFrame("Circle");
                jframe.setSize(360, 300);
                jframe.add(new drawCircle());
                jframe.setLocationRelativeTo(null);
                jframe.setVisible(true);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
            }
        };

        ActionListener square = e -> {
            try {
                double side = Double.parseDouble(inputTextOne.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of square = " + DataValues.getAreaOfSquare(side));
                JFrame jframe = new JFrame("Square");
                jframe.setSize(360, 300);
                jframe.add(new drawSquare());
                jframe.setLocationRelativeTo(null);
                jframe.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
            }
        };

        ActionListener triangle = e -> {
            try {
                double base = Double.parseDouble(inputTextOne.getText());
                double height = Double.parseDouble(inputTextTwo.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of triangle = " + DataValues.getAreaOfTriangle(base, height));
                JFrame jframe = new JFrame("Triangle");
                jframe.setSize(360, 300);
                jframe.add(new drawTriangle());
                jframe.setLocationRelativeTo(null);
                jframe.setVisible(true);
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
                }
            };


        ActionListener rectangle = e -> {
            try{
                double width = Double.parseDouble(inputTextOne.getText());
                double length = Double.parseDouble(inputTextTwo.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of rectangle = " + DataValues.getAreaOfRectangle(width, length));
                JFrame jframe = new JFrame("Rectangle");
                jframe.setSize(360, 300);
                jframe.add(new drawRectangle());
                jframe.setLocationRelativeTo(null);
                jframe.setVisible(true);
            }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
                }
            };


        // Action Listeners for 3D Shapes: Sphere, Cube, Cone, Cylinder, Torus.
        ActionListener sphere = e -> {
            try {
                double radius = Double.parseDouble(inputTextOne.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of sphere = " + DataValues.getAreaOfSphere(radius) + 
                             "\n | Volume of sphere = " + DataValues.getVolumeOfSphere(radius));
                try {
                    ImageIcon img = image(new File("Sphere.png"));
                    imageLabel.setIcon(img);
                } catch (IOException ioException) {
                    System.out.println("Error, Image not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
            }
        };
        
            ActionListener cube = e -> {
                try {
                    double edge = Double.parseDouble(inputTextOne.getText());
                    areaVolumeDisplay.setVisible(true);
                    areaVolumeDisplay.setText("Area of cube = " + DataValues.getAreaOfCube(edge) + "\n | Volume of cube = " + new Cube(edge).getVolume());
                    try {
                        ImageIcon img = image(new File("Cube.png"));
                        imageLabel.setIcon(img);
                    } catch (IOException ioException) {
                        System.out.println("Error, Image not found.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
                }
            };
            
        ActionListener cone = e -> {
            try {
                double radius = Double.parseDouble(inputTextOne.getText());
                double height = Double.parseDouble(inputTextTwo.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of cone = " + DataValues.getAreaOfCone(radius, height)
                        + "\n | Volume of cone = " + DataValues.getVolumeOfCone(radius, height));
                try {
                    ImageIcon img = image(new File("Cone.png"));
                    imageLabel.setIcon(img);
                } catch (IOException ioException) {
                    System.out.println("Error, Image not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
            }
        };
        
        ActionListener cylinder = e -> {
            try{
                double radius = Double.parseDouble(inputTextOne.getText());
                double height = Double.parseDouble(inputTextTwo.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of cylinder = " + DataValues.getAreaOfCylinder(radius, height)
                           + "\n | Volume of cylinder = " + DataValues.getVolumeOfCylinder(radius, height));
                try {
                    ImageIcon img = image(new File("Cylinder.jpg"));
                    imageLabel.setIcon(img);
                } catch (IOException ioException) {
                    System.out.println("Error, Image not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
            }
        };
        
        ActionListener torus = e -> {
            try {
                double majorRadius = Double.parseDouble(inputTextOne.getText());
                double minorRadius = Double.parseDouble(inputTextTwo.getText());
                areaVolumeDisplay.setVisible(true);
                areaVolumeDisplay.setText("Area of torus = " + DataValues.getAreaOfTorus(majorRadius, minorRadius) 
                               + "\n | Volume of torus = " + DataValues.getVolumeOfTorus(majorRadius, minorRadius));
                try {
                    ImageIcon img = image(new File("Torus.jpg"));
                    imageLabel.setIcon(img);
                } catch (IOException ioException) {
                    System.out.println("Error, Image not found.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numerical value (#.##)");
            }
        };
        

        // Handeling Drop Down Menu 
        selectedShape.addItemListener(e -> {
            int shape = selectedShape.getSelectedIndex();
            switch (shape) {
                case 1 -> {
                    removeAdd(square, triangle, rectangle, sphere, cube, cone, cylinder, torus, circle);
                    constructButton.setVisible(true);
                    constructButton.setText("Draw a Circle");
                    inputLabelOne.setText("Radius");
                    inputLabelOne.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputLabelTwo.setVisible(false);
                    inputTextTwo.setVisible(false);
                }
                case 2 -> {
                    removeAdd(circle, triangle, rectangle, sphere, cube, cone, cylinder, torus, square);
                    constructButton.setVisible(true);
                    constructButton.setText("Draw a Square");
                    inputLabelOne.setText("Side");
                    inputLabelOne.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputLabelTwo.setVisible(false);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(false);
                }
                case 3 -> {
                    removeAdd(circle, square, rectangle, sphere, cube, cone, cylinder, torus, triangle);
                    constructButton.setVisible(true);
                    constructButton.setText("Draw a Triangle");
                    inputLabelOne.setText("Base");
                    inputLabelOne.setVisible(true);
                    inputLabelTwo.setText("Height");
                    inputLabelTwo.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(true);
                }
                case 4 -> {
                    removeAdd(square, triangle, circle, sphere, cube, cone, cylinder, torus, rectangle);
                    constructButton.setVisible(true);
                    constructButton.setText("Draw a Rectangle");
                    inputLabelOne.setText("Width");
                    inputLabelOne.setVisible(true);
                    inputLabelTwo.setText("Length");
                    inputLabelTwo.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(true);
                }
                case 5 -> {
                    removeAdd(square, triangle, rectangle, circle, cube, cone, cylinder, torus, sphere);
                    constructButton.setVisible(true);
                    constructButton.setText("Construct a Sphere");
                    inputLabelOne.setText("Radius");
                    inputLabelOne.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputLabelTwo.setVisible(false);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(false);
                }
                case 6 -> {
                    removeAdd(square, triangle, rectangle, sphere, circle, cone, cylinder, torus, cube);
                    constructButton.setVisible(true);
                    constructButton.setText("Construct a Cube");
                    inputLabelOne.setText("Edge");
                    inputLabelOne.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputLabelTwo.setVisible(false);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(false);
                }
                case 7 -> {
                    removeAdd(square, triangle, rectangle, sphere, cube, circle, cylinder, torus, cone);
                    constructButton.setVisible(true);
                    constructButton.setText("Construct a Cone");
                    inputLabelOne.setText("Radius");
                    inputLabelOne.setVisible(true);
                    inputLabelTwo.setText("Height");
                    inputLabelTwo.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(true);
                }
                case 8 -> {
                    removeAdd(square, triangle, rectangle, sphere, cube, cone, circle, torus, cylinder);
                    constructButton.setVisible(true);
                    constructButton.setText("Construct a Cylinder");
                    inputLabelOne.setText("Radius");
                    inputLabelOne.setVisible(true);
                    inputLabelTwo.setText("Height");
                    inputLabelTwo.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(true);
                }
                case 9 -> {
                    removeAdd(square, triangle, rectangle, sphere, cube, cone, cylinder, circle, torus);
                    constructButton.setVisible(true);
                    constructButton.setText("Construct a Torus");
                    inputLabelOne.setText("Major radius");
                    inputLabelOne.setVisible(true);
                    inputLabelTwo.setText("Minor radius");
                    inputLabelTwo.setVisible(true);
                    inputTextOne.setText("");
                    inputTextOne.setVisible(true);
                    inputTextTwo.setText("");
                    inputTextTwo.setVisible(true);
                }
            }
        });

    }


    // Reading in 3D shape representation
    public static ImageIcon image(File file) throws IOException {
        BufferedImage img = ImageIO.read(file);
        return new ImageIcon(img);
    }


    // Additional necessary actionListener behavior
    private static void removeAdd(ActionListener a, ActionListener b, ActionListener c, ActionListener d, ActionListener e,
                                 ActionListener f, ActionListener g, ActionListener h, ActionListener i){
        constructButton.removeActionListener(a);
        constructButton.removeActionListener(b);
        constructButton.removeActionListener(c);
        constructButton.removeActionListener(d);
        constructButton.removeActionListener(e);
        constructButton.removeActionListener(f);
        constructButton.removeActionListener(g);
        constructButton.removeActionListener(h);
        constructButton.addActionListener(i);
        areaVolumeDisplay.setVisible(false);
        imageLabel.setIcon(null);
    }
}


// Drawing 2D Shapes to panel
class drawCircle extends JPanel{

    public void paintComponent(Graphics shape) {
        super.paintComponent(shape);
        Graphics2D graphics2D = (Graphics2D) shape;
        graphics2D.drawOval(10, 20, 200, 200);
    }
}


class drawSquare extends JPanel{

    public void paintComponent(Graphics shape) {
        super.paintComponent(shape);
        Graphics2D graphics2D = (Graphics2D) shape;
        graphics2D.drawRect(10, 20, 200, 200);
    }
}



class drawTriangle extends JPanel{
    public void paintComponent(Graphics shape) {
        super.paintComponent(shape);
        Graphics2D graphics2D = (Graphics2D) shape;
        int[] x ={130,70,190};
        int[] y={50,200,200};
        graphics2D.drawPolygon(x, y, 3);
    }
}


class drawRectangle extends JPanel{

    public void paintComponent(Graphics shape) {
        super.paintComponent(shape);
        Graphics2D graphics2D = (Graphics2D) shape;
        graphics2D.drawRect(10, 20, 200, 100);
    }
}