/*Joel Goode CMSC 350 Project4 
 * The fourth programming project involves writing a program that accepts information contained in a file about
the class dependencies in a Java program and creates a directed graph from that information. From the directed
graph, it produces two different kinds of displays of those dependency relationships.
 */


// Vertex constructor class
public class Vertex {
    private final String name;

    public Vertex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}