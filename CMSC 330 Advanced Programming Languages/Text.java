/* Joel goode
 * 2/6/23
 * CMSC 330 Project 1
 * The Text class extends the Image abstract class and must therefore implement the abstract method draw. The draw method uses the drawString method of the Graphics class to draw the text on the scene.
 */

import java.awt.*;

public class Text extends Image{
    private String text;
    private Color color;
    private Point location;

    public Text(Color color, Point location, String text){
        super(color);
        this.color = color;
        this.location = location;
        this.text = text;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        g.drawString(text, location.x, location.y);
    }
}