import java.util.ArrayList;
import java.util.Stack;

public class Day21 {
      // Static inner class to represent an edge in the graph
    static class Edge {
        int src; // Source vertex
        int dest; // Destination vertex
        int wt; // Weight of the edge (not used in basic traversals, but good practice)

        // Constructor for an Edge
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static ArrayList<Edge>[] createGraph(int v){
        @SuppressWarnings("unchecked") 
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3, 1));

        graph[3].add(new Edge(3, 1, 1));

        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        return graph;
    }

    public static void topoLogicalSort(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for( int i = 0; i < graph.length; i++){
            if (!visited[i]) {
                topoLogicalSortUtil(graph,i,visited,s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topoLogicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> s){

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                topoLogicalSortUtil(graph, e.dest, visited, s);
            }
        }

        s.push(curr);
    }

    public static void main(String[] args) {
        // topological sorting is only for directed acyclic graph(DAG)
        // it is linear ordering of vertices such that for every directed edge u->v, u comes before v in the ordering
        // it is used in scheduling tasks, build systems, resolving dependencies etc.

        int v = 6;
        ArrayList<Edge>[] graph = createGraph(v);

        topoLogicalSort(graph);
      

    }
}


