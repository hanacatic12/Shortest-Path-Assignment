package ba.edu.ssst;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {
    String name;
    Map<Node, Integer> neighbors;

    public Node(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addNewNeighbor(Node neighbor, Integer distance, Boolean constraint) {
        if(!constraint)
            neighbors.put(neighbor, distance);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Node n = (Node) o;
        return Objects.equals(name, n.name);
    }

}
