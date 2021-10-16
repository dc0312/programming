package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetConnectedComponentOfGraph {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1,10", "2,3,10", "4,5,10", "5,6,10", "4,6,10");
        for (String edge : edges) {
            String[] pairs = edge.split(",");
            int v1 = Integer.parseInt(pairs[0]);
            int v2 = Integer.parseInt(pairs[1]);
            int v3 = Integer.parseInt(pairs[2]);
            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }
        List<List<Integer>> stringList = new ArrayList<>();
        getConnectedComponent(graph, vertices, stringList);
        System.out.println(stringList);
    }

    private static void getConnectedComponent(ArrayList<Edge>[] graph, int vertices, List<List<Integer>> stringList) {
        boolean[] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                drawTree(graph, i, comp, visited);
                stringList.add(comp);
            }
        }
    }

    private static void drawTree(ArrayList<Edge>[] graph, int src, List<Integer> comp, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                drawTree(graph, edge.nbr, comp, visited);
            }
        }
    }

    public static class Edge {
        private int src;
        private int nbr;
        private int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
}
