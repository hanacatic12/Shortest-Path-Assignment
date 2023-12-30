package ba.edu.ssst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File f2 = new File("src/main/java/ba/edu/ssst/constraints.txt");
        File f3 = new File("src/main/java/ba/edu/ssst/places.txt");

        File f = new File("src/main/java/ba/edu/ssst/five_places.txt");
        File allA = new File("src/main/java/ba/edu/ssst/all_places_a.txt");
        File allB = new File("src/main/java/ba/edu/ssst/all_places_b.txt");
        File complex = new File("src/main/java/ba/edu/ssst/complex.txt");
        File simple = new File("src/main/java/ba/edu/ssst/simple.txt");
        File ten = new File("src/main/java/ba/edu/ssst/ten_places.txt");

        List<Constraints> constraints = new ArrayList<>();
        ScanConstraints(f2, constraints);
        Map<String, String> places = new HashMap<>();
        ScanPlaces(f3, places);

        Graph g1 = new Graph();
        Graph g_simple = new Graph();
        Graph g_allA = new Graph();
        Graph g_allB = new Graph();
        Graph g_complex = new Graph();
        Graph g_ten = new Graph();

        ScanFileForGraph(f, g1, constraints);
        ScanFileForGraph(simple, g_simple, constraints);
        ScanFileForGraph(allA, g_allA, constraints);
        ScanFileForGraph(allB, g_allB, constraints);
        ScanFileForGraph(complex, g_complex, constraints);
        ScanFileForGraph(ten, g_ten, constraints);


        File for_f = new File("src/main/java/ba/edu/ssst/optimalpaths.txt");
        FindAllPaths(for_f, g1, places);

        File for_simple = new File("src/main/java/ba/edu/ssst/optimal_for_simple.txt");
        FindAllPaths(for_simple, g_simple, places);

        File for_a = new File("src/main/java/ba/edu/ssst/optimal_for_all_a.txt");
        FindAllPaths(for_a, g_allA, places);

        File for_b = new File("src/main/java/ba/edu/ssst/optimal_for_all_b.txt");
        FindAllPaths(for_b, g_allB, places);

        File for_complex = new File("src/main/java/ba/edu/ssst/optimal_for_complex.txt");
        FindAllPaths(for_complex, g_complex, places);

        File for_ten = new File("src/main/java/ba/edu/ssst/optimal_for_ten.txt");
        FindAllPaths(for_ten, g_ten, places);

    }

    public static void ScanFileForGraph(File f, Graph g1, List<Constraints> constraints)  {

        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] lineParts = line.split(" ");

                String source = lineParts[0];
                String destination = lineParts[1];
                Integer distance = Integer.parseInt(lineParts[2]);

                g1.AddEdge(source, destination, distance, constraints);
            }
            s.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static void ScanConstraints(File f, List<Constraints> constraints) {

        try {
            Scanner s = new Scanner(f);

            if(s.hasNextLine()) s.nextLine();

            while(s.hasNextLine()) {
                String line = s.nextLine();
                String[] lineParts = line.split(",");

                String node1 = lineParts[0];
                String node2 = lineParts[1];
                String type = lineParts[2];
                Double probability = Double.parseDouble(lineParts[3]);

                constraints.add(new Constraints(node1, node2, type, probability));
            }
            s.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void ScanPlaces(File f, Map<String, String> places) {
        try {
            Scanner s = new Scanner(f);

            if(s.hasNextLine()) s.nextLine();

            while(s.hasNextLine()) {
                String line = s.nextLine();
                String[] lineParts = line.split(",");

                String symbol = lineParts[0];
                String place = lineParts[1];

                places.put(symbol, place);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void FindAllPaths(File f, Graph graph, Map<String, String> places) {
        try {

            FileWriter writer = new FileWriter(f);

            for(String source : graph.graph.keySet()) {
                for(String destination : graph.graph.keySet()) {
                    if(!source.equals(destination)) {
                        String src;
                        if (places.containsKey(source)) src = places.get(source);     //if the place doesn't exist in places file, the code is used as the name of the node
                        else src = source;
                        String dest;
                        if(places.containsKey(destination)) dest = places.get(destination);
                        else dest = destination;
                        int distance = ShortestPathAlgorithm.ShortestPath(source, destination, graph);

                        writer.write(src + " -> " + dest + " " + distance + "\n");
                    }
                }
            }

            writer.close();

        } catch(IOException e) {
            System.out.println(e);
        }
    }
}