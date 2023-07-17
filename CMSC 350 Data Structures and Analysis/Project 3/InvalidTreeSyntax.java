import javax.swing.JOptionPane;

/*
 * Joel Goode CMSC 350 11/28/22
 * Defines a checked exception
 * Thrown when a invalid string is supplied and the Make Tree button is clicked
 */

public class InvalidTreeSyntax extends Exception{

    public InvalidTreeSyntax(){
        super();
    }
    
    public InvalidTreeSyntax(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }
}
