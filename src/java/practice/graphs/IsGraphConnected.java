package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsGraphConnected {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        //List<String> edges = Arrays.asList("0,1,10", "1,2,10", "2,3,10", "0,3,10", "3,4,10", "4,5,10", "5,6,10", "4,6,10");
        List<String> edges = Arrays.asList("0,1,10", "2,3,10", "4,5,10", "5,6,10", "4,6,10");

        for (String edge : edges) {
            String[] parts = edge.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int v3 = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }

        System.out.println("Result : " + isGraphConnected(graph));
    }

    private static boolean isGraphConnected(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                isGraphConnected(graph, comp, i, visited);
                ans.add(comp);
            }

        }
        return ans.size() == 1;
    }

    private static void isGraphConnected(ArrayList<Edge>[] graph, ArrayList<Integer> comp, int src, boolean[] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                isGraphConnected(graph, comp, edge.nbr, visited);
            }

        }
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
