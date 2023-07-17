/*Joel Goode CMSC 350 Project4 
 * The fourth programming project involves writing a program that accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.
 */

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainGUI {
    static DirectedGraph graph = new DirectedGraph();

    public static void main(String[] args) {
        new MainGUI().readGraph();

        // Starting Depth First Search.
        graph.depthFirstSearch();

        // Display Parenthesized List after processing the vertices.
        System.out.println(graph.parenthesizedList.toString());

        // Display Hierarchy after processing the vertices.
        System.out.println(graph.hierarchy.toString());

        // Display all the nodes that remained unreachable in the searching process.
        graph.displayUnreachableClasses();
    }

    // Method for reading graph.
    public void readGraph() {
        JFileChooser file = new JFileChooser(new File("."));
        int option = file.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                Scanner input = new Scanner(file.getSelectedFile());
                while (input.hasNextLine()) {
                    String edgeString = input.nextLine();
                    String[] edge = edgeString.split(" ");
                    // DFS starts from this node
                    if (graph.startNode == null)
                        graph.startNode = graph.getVertex(edge[0]);
                    for (int i = 1; i < edge.length; i++) {
                        graph.addEdge(edge[0], edge[i]);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}