package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    static class Edge {
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1", "1,2", "2,3", "0,3", "4,3", "4,5", "4,6", "5,6");

        for (String edge : edges) {
            String[] parts = edge.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        boolean visited[] = new boolean[vertices];
        Stack stack = new Stack();
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack stack) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                topologicalSort(graph, e.nbr, visited, stack);
            }
        }
        stack.push(src);
    }
}
