/*
 * Joel Goode CMSC 350 11/28/22
 * GUI that allows the user to input a tree in the above described format and then construct the tree once the Make Tree button is clicked.
 * 
 * * The third programming project involves writing a program that allows the user to enter a binary tree in a parenthesized prefix format and then allows it to be categorized and allows various features of that tree to be displayed.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private JTextField input = new JTextField(20);
    private JTextField output = new JTextField(30);

    private static BinaryTree inputTree;

     // Run 
     public static void main(String[] args) {
        MainGUI frame = new MainGUI();
        frame.setVisible(true);
    }

    // Class constructor creates GUI with three panels (input, buttons, and output)
    public MainGUI() {
        super("Binary Tree Categorizer");
        setSize(715, 175);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JComponent[] inputFields = {
            new JLabel("Enter Expression"), input
        };

        JComponent[] outputFields = {
            new JLabel("Output"), output
        };

        JButton[] buttonFields = {
            new JButton("Make Tree"), new JButton("Is Balanced?"),
            new JButton("Is Full?"), new JButton("Is Proper?"), 
            new JButton("Height"),
            new JButton("Nodes"), new JButton("Inorder")
        };

        makeFlowPanel(inputFields);
        makeFlowPanel(buttonFields);
        makeFlowPanel(outputFields);
        addActionListeners(buttonFields);
        output.setEditable(false);
        setResizable(false);
    }

    // Create a flow panel from array of components
    private void makeFlowPanel(JComponent[] components) {
        JPanel panel = new JPanel(new FlowLayout());

        for (Component component: components) { 
            panel.add(component); 
        }
        add(panel);
    }

    // Adds the ActionListener to the array of buttons passed to it, similar to previous
    private void addActionListeners (JButton[] buttons){
        for (JButton button: buttons){
            button.addActionListener(treeListener);
        }
    }

    // ActionListener uses switch statement to set output text based on String returned from getActionCommand
    private final ActionListener treeListener = event -> {
        try {
            switch ((event.getActionCommand())){
                case "Make Tree":
                    inputTree = new BinaryTree(input.getText());
                    output.setText(inputTree.toString());
                    break;
                case "Is Balanced?":
                    output.setText(String.valueOf(inputTree.isBalanced()));
                    break;
                case "Is Full?":
                    output.setText(String.valueOf(inputTree.isFull()));
                    break;
                case "Is Proper?":
                    output.setText(String.valueOf(inputTree.isProper()));
                    break;
                case "Height":
                    output.setText(String.valueOf(inputTree.height()));
                    break;
                case "Nodes":
                    output.setText(String.valueOf(inputTree.nodes()));
                    break;
                case "Inorder":
                    output.setText(inputTree.inOrder());
                    break;
            }
        } catch (InvalidTreeSyntax except) {
            JOptionPane.showMessageDialog(getParent(),except.getMessage());

        } catch (IndexOutOfBoundsException indexExcept) {
            JOptionPane.showMessageDialog(getParent(),"Error, No input given!");
        }
    };
}