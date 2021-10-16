package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestPathInGraph {

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1,10", "1,2,10", "2,3,10", "0,3,40", "3,4,2", "4,5,3", "5,6,3", "4,6,8");

        for (String edge : edges) {
            String[] parts = edge.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int v3 = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }

        System.out.println("Largest Path : " + largestPath(graph, 0, 6));
    }

    private static int largestPath(ArrayList<Edge>[] graph, int src, int dest) {
        int largestPath = Integer.MIN_VALUE;
        boolean[] visited = new boolean[graph.length];
        return largestPath(graph, src, dest, largestPath, 0, visited);
    }

    private static int largestPath(ArrayList<Edge>[] graph, int src, int dest, int largestPath, int sum, boolean[] visited) {
        if (src == dest) {
            largestPath = Math.max(sum, largestPath);
            return largestPath;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                largestPath = largestPath(graph, edge.nbr, dest, largestPath, sum + edge.wt, visited);
            }
        }
        visited[src] = false;
        return largestPath;
    }

    static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
}
