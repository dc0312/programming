package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPaths {
    public static void main(String[] args) {
        int vertices = 7;

        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1,10", "1,2,10", "2,3,10", "0,3,10", "3,4,10", "4,5,10", "5,6,10", "4,6,10");

        for (String edge : edges) {
            String[] parts = edge.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int v3 = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }

        printGraph(graph);
        printAllPaths(graph, 0, 6, "" + 0);

    }

    private static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String output) {
        boolean[] visited = new boolean[graph.length];
        printAllPaths(graph, src, dest, output, visited);
    }

    private static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String output, boolean[] visited) {
        if (src == dest) {
            System.out.println(output);
            return;
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                printAllPaths(graph, edge.nbr, dest, output + edge.nbr, visited);
            }
        }
        visited[src] = false;
    }

    private static void printGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            for (Edge edge : graph[i]) {
                System.out.print(edge.src + "-->" + edge.nbr + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static private class Edge {
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
