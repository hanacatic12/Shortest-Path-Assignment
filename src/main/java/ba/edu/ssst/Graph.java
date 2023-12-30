package ba.edu.ssst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Graph {
    Map<String, Node> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public Node getNode(String name) {
        return graph.get(name);
    }

    public void AddNode(String node) {
        if(!graph.containsKey(node))
            graph.put(node, new Node(node));
    }

    public void AddEdge(String source, String dest, Integer distance, List<Constraints> constraints) {
        AddNode(source);
        AddNode(dest);

        Node src = graph.get(source);
        Node dst = graph.get(dest);

        Boolean constraint = IncludeConstraint(source, dest, constraints);

        src.addNewNeighbor(dst, distance, constraint);
    }

    public Boolean IncludeConstraint(String source, String dest, List<Constraints> constraints) {
        for(Constraints constraint : constraints) {
            if(constraint.source.equals(source) && constraint.destination.equals(dest)) {
                Random rand = new Random();
                double random = rand.nextDouble();

                if(random == 0.0) return false;  //if the probability is 0, there is no constraint
                if(random <= constraint.probability) return true;
            }
        }
        return false;
    }

    public void printGraph() {
        for(Map.Entry<String, Node> entry : graph.entrySet()) {
            Node node = entry.getValue();
            for(Map.Entry<Node, Integer> entry2 : node.neighbors.entrySet()) {
                System.out.println(node.name + " " + entry2.getKey().name + " " + entry2.getValue());
            }
        }
    }
}
