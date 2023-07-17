/*
 * Joel Goode
 * 2/5/23
 * Project 1
 * CMSC 330 Project 1
 * This class is a subclass of Polygon_ to draw a solid polygon
 * Calculate points by using vertices use color to fill polygon.
 */


import java.awt.*;

abstract class SolidPolygon extends Polygon_ {

    //Constructor: creates a new SolidPolygon object
    public SolidPolygon(Color color, int vertices){
        super(color, vertices);
    }
}