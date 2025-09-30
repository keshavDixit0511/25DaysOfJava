import java.util.ArrayList;

public class Day19 {
    static class Edge{

        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

      public static ArrayList<Edge>[] createGraph(int v) {
        // Initialize the array of ArrayLists
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Ensure every index of the array holds an empty ArrayList
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // --- Adding the specific edges you provided ---

        // adding edges at index 0
        graph[0].add(new Edge(0, 1, 5));

        // adding edges at index 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // adding edges at index 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        // adding edges at index 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 3));

        // adding edges at index 4
        graph[4].add(new Edge(4, 2, 2));

        return graph;
    }
    public static void main(String[] args) {
        int v = 5;  // no. of vertices

        ArrayList<Edge>[] graph = createGraph(v);


        // Find all the neghbours of vertex 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.destination );
        }


    }
}
