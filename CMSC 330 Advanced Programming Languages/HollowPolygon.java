// CMSC 330 Advanced Programming Languages
// Project 1 Skeleton
// UMGC CITE
// Spring 2023

/* Joel Goode
 * 2/6/23
 * CMSC 330 Project 1 
 */

import java.awt.*;

// Abstract class that defines all hollow polygons
abstract class HollowPolygon extends Polygon_ {

    // Constructor that calls super constructor
    public HollowPolygon(Color color, int vertexCount) {
        super(color, vertexCount);
    }
}