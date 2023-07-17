/*Joel Goode CMSC 350 Project4 
 * This Class performs actions on graph data structures
 * The fourth programming project involves writing a program that accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.
 */

public interface DFSActions<V> {
    public void processVertex(V vertex);

    public void descendVertex(V vertex);

    public void ascendVertex(V vertex);

    public void cycleDetected();
}