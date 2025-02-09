# Shortest Path Assignment

This Java project implements a sophisticated shortest path finding algorithm that takes into account various constraints and places. Based on the principle of Dijkstra's algorithm, the program is designed to find optimal paths between different locations while respecting defined constraints and distances.

## Project Structure

The project is organized as follows:
- `Main.java` - Entry point of the application
- `Graph.java` - Graph data structure implementation
- `Node.java` - Node representation for the graph
- `Pair.java` - Node pair representation for the graph
- `Constraints.java` - Constraint handling implementation
- `ShortestPathAlgorithm.java` - Dijkstra's algorithm implementation
- `ShortestPathTest.java` - Test class for the algorithm


## Features

- Graph-based path finding implementation
- Support for multiple test cases and scenarios
- Constraint-based path validation
- Place mapping and management
- Various test files for different complexity levels:
  - Simple paths
  - Complex paths
  - Five places scenario
  - Ten places scenario
  - All places scenarios (A and B variants)

## Input Files

The program uses several input files:
- `constraints.txt` - Defines the constraints between places
- `places.txt` - Contains mapping of place identifiers
- Various test files:
  - `five_places.txt`
  - `ten_places.txt`
  - `simple.txt`
  - `complex.txt`
  - `all_places_a.txt`
  - `all_places_b.txt`

## Output Files

The program generates optimal paths in the following output files:
- `optimalpaths.txt` - For the five places scenario
- `optimal_for_simple.txt` - For simple test cases
- `optimal_for_all_a.txt` - For all places from `all_places_a.txt`
- `optimal_for_all_b.txt` - For all places from `all_places_b.txt`
- `optimal_for_complex.txt` - For complex test cases
- `optimal_for_ten.txt` - For ten places scenario

## How to Run

1. Ensure you have Java installed on your system
2. Navigate to the project root directory
3. Compile the Java files
4. Run the Main class

The program will process the input files and generate the optimal paths in the respective output files.

## Implementation Details

The project uses:
- HashMap for efficient graph representation
- Custom Node class for managing graph nodes
- Custom ShortestPathAlgorithm class for implementing Dijkstra's algorithm
- Constraint checking for valid paths
- File I/O operations for reading inputs and writing results
