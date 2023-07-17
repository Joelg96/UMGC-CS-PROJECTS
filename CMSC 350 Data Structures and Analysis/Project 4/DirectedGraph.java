/*Joel Goode CMSC 350 Project4 
 * The fourth programming project involves writing a program that accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.
 */

import java.util.ArrayList;

// Class for DirectedGraph, extends graph created directed edge and adds it to the graph.
public class DirectedGraph extends Graph<Vertex> {
    public void addEdge(String u, String v) {
        ArrayList<Vertex> list = adjacencyList.get(getVertex(u));

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(getVertex(v));
        adjacencyList.put(getVertex(u), list);
    }

    // Method for getting vertex.
    public Vertex getVertex(String u) {

        if (!vertices.containsKey(u)) {
            vertices.put(u, new Vertex(u));
        }
        return vertices.get(u);
    }

}