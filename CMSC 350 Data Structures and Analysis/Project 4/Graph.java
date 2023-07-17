/*Joel Goode CMSC 350 Project4 
 * The fourth programming project involves writing a program that accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.
 */

import java.util.*;

public class Graph<V> {
    // Start node of the graph.
    public V startNode = null;

    // Map all the vertex name (String) to a corresponding  using hashmap.
    Map<String, V> vertices = new HashMap<>();
    Map<V, ArrayList<V>> adjacencyList = new HashMap<>();
    Set<V> visited = new HashSet<>();

    ParenthesizedList hierarchy = new ParenthesizedList();
    Hierarchy parenthesizedList = new Hierarchy();

    boolean cycle;

    Set<V> discovered = new HashSet<>();

    // Method for initializing Depth First Search.
    public void depthFirstSearch() {
        cycle = false;
        depthFirst(startNode);
    }

    // Method for searching list in Depth First Order.
    private void depthFirst(V node) {
        if (discovered.contains(node)) {
            cycle = true;
            hierarchy.cycleDetected();
            parenthesizedList.cycleDetected();
            return;
        }

        hierarchy.processVertex((Vertex) node);
        parenthesizedList.processVertex((Vertex) node);
        hierarchy.descendVertex((Vertex) node);
        parenthesizedList.descendVertex((Vertex) node);
        discovered.add(node);
        visited.add(node);

        ArrayList<V> list = adjacencyList.get(node);
        if (list != null) {
            for (V u : list)
                depthFirst(u);
        }

        hierarchy.ascendVertex((Vertex) node);
        parenthesizedList.ascendVertex((Vertex) node);
        discovered.remove(node);
    }

    // Method for printing nodes/classes
    public void displayUnreachableClasses(){
        for (Map.Entry<V, ArrayList<V>> entry : adjacencyList.entrySet()) {

            if (entry.getValue().size()>0){

                if (!visited.contains(entry.getKey())){
                    System.out.println(entry.getKey() + " is unreachable");
                    visited.add(entry.getKey());
                }

                for (V vertex : entry.getValue()){

                    if (!visited.contains(vertex)){
                        System.out.println(vertex + " is unreachable");
                        visited.add(vertex);
                    }
                }
            }
        }
    }
}