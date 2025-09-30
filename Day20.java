import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Day20 {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static ArrayList<Edge>[] createGraph(int v) {
        ArrayList<Edge>[] graph = new ArrayList[v];

        for( int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

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
        graph[4].add(new Edge(4, 3, 6));

        return graph;
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                bfsUtil(graph,visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;

                for(int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {

        System.out.print(curr + " ");

        visited[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }

    public static void main(String[] args) {
        
        int v = 5; // no. of vertices
        ArrayList<Edge>[] graph = createGraph(v);

        // Find all the neighbours of vertex 3
        for ( int i = 0; i < graph[3].size(); i++) {
            Edge e = graph[3].get(i);
            System.out.println(e.dest);
        }

        // BFS
        bfs(graph);
       
        System.out.println();
        // DFS
        dfs(graph);
    }
}
