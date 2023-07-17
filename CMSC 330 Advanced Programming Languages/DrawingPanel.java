// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023

/* Joel Goode
 * 2/6/23
 * CMSC 330 Project 1 
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

// Class that defines the panel for drawing the images
class DrawingPanel extends JPanel {

    private ArrayList<Image> images = new ArrayList<>();

    // Adds a graphic object to the drawing panel
    public void addImage(Image image) {

        images.add(image);
      }

    // Draws all the images on the drawing panel
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Image image : images)
            image.draw(graphics);
    }
}