package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmallestPathInGraph {
    private static String shortestPath;
    private static int shortestPathWt = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1,10", "1,2,10", "2,3,10", "0,3,40", "3,4,2", "4,5,3", "5,6,3", "4,6,8");

        for (String edge : edges) {
            String[] pairs = edge.split(",");
            int v1 = Integer.parseInt(pairs[0]);
            int v2 = Integer.parseInt(pairs[1]);
            int v3 = Integer.parseInt(pairs[2]);
            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }

        printSmallestPath(graph, 0, 6);
    }

    private static void printSmallestPath(ArrayList<Edge>[] graph, int src, int dest) {
        boolean[] visited = new boolean[graph.length];
        String pathSoFar = "" + src;
        int weightSoFar = 0;
        printSmallestPath(graph, src, dest, pathSoFar, weightSoFar, visited);
        System.out.println(shortestPath + "@" + shortestPathWt);
    }

    private static void printSmallestPath(ArrayList<Edge>[] graph, int src, int dest, String pathSoFar, int weightSoFar, boolean[] visited) {

        if (src == dest) {
            if (weightSoFar < shortestPathWt) {
                shortestPath = pathSoFar;
                shortestPathWt = weightSoFar;
            }
            return;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                printSmallestPath(graph, edge.nbr, dest, pathSoFar + edge.nbr, weightSoFar + edge.wt, visited);
            }
        }

        visited[src] = false;

    }

    public static class Edge {
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
