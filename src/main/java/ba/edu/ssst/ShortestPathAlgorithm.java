package ba.edu.ssst;

import java.util.*;

public class ShortestPathAlgorithm {
    public static int ShortestPath(String start, String end, Graph graph) {
        Map<String, Integer> distances = new HashMap<>();
        distances.put(start, 0);

       PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.distance));
       queue.offer(new Pair(graph.getNode(start), 0));

       while(!queue.isEmpty()) {
            Pair current = queue.poll();

            if(current.node != null) {
                if(current.node.toString().equals(end))
                    return current.distance;

                for(Map.Entry<Node, Integer> neighbor : current.node.neighbors.entrySet()) {
                    if(neighbor.getValue() < 0) {
                        continue;
                    }
                    Integer newDistance = current.distance + neighbor.getValue();

                    //updates distances

                    if(!distances.containsKey(neighbor.getKey().toString()) || newDistance < distances.get(neighbor.getKey().toString())) {
                        distances.put(neighbor.getKey().toString(), newDistance);
                        queue.offer(new Pair(neighbor.getKey(), newDistance));
                    }
                }
            }
       }

       return -1;
    }

}
