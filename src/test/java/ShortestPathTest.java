import ba.edu.ssst.Constraints;
import ba.edu.ssst.Graph;
import ba.edu.ssst.ShortestPathAlgorithm;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathTest extends TestCase {

    public void testConnections() {
        List<Constraints> constraints = new ArrayList<>();
        constraints.add(new Constraints("A", "B", "none", 0.0));

        Graph graph = new Graph();

        graph.AddEdge("A", "B", 10, constraints);
        graph.AddEdge("B", "C", 20, constraints);
        graph.AddEdge("C", "A", 5, constraints);
        graph.AddEdge("A", "C", 7, constraints);
        graph.AddEdge("B", "D", 40, constraints);
        graph.AddEdge("C", "D", 2, constraints);

        assertEquals(10, ShortestPathAlgorithm.ShortestPath("A", "B", graph));
        assertEquals(7, ShortestPathAlgorithm.ShortestPath("A", "C", graph));
        assertEquals(25, ShortestPathAlgorithm.ShortestPath("B", "A", graph));
        assertEquals(20, ShortestPathAlgorithm.ShortestPath("B", "C", graph));
        assertEquals(5, ShortestPathAlgorithm.ShortestPath("C", "A", graph));
        assertEquals(15, ShortestPathAlgorithm.ShortestPath("C", "B", graph));
        assertEquals(2, ShortestPathAlgorithm.ShortestPath("C", "D", graph));
        assertEquals(9, ShortestPathAlgorithm.ShortestPath("A", "D", graph));
        assertEquals(22, ShortestPathAlgorithm.ShortestPath("B", "D", graph));
    }

    public void testWithConstraints() {
        List<Constraints> constraints = new ArrayList<>();
        constraints.add(new Constraints("A", "B", "traffic", 1.0));

        Graph graph = new Graph();

        graph.AddEdge("A", "B", 10, constraints);
        graph.AddEdge("B", "C", 20, constraints);
        graph.AddEdge("C", "A", 5, constraints);

        assertEquals(-1, ShortestPathAlgorithm.ShortestPath("A", "B", graph));
    }

    public void testInvalidNode() {
        List<Constraints> constraints = new ArrayList<>();
        constraints.add(new Constraints("A", "B", "traffic", 1.0));

        Graph graph = new Graph();

        graph.AddEdge("A", "B", 60, constraints);
        graph.AddEdge("B", "D", 21, constraints);
        graph.AddEdge("C", "A", 5, constraints);
        graph.AddEdge("D", "A", 15, constraints);

        assertEquals(-1, ShortestPathAlgorithm.ShortestPath("A", "H", graph));
    }
}
