package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HamiltonianPath {
    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1,10", "0,2,10", "1,3,10", "3,2,10", "2,4,10", "4,6,10", "3,5,10", "4,5,10", "5,6,10");

        for (String edge : edges) {
            String[] parts = edge.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int v3 = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }

        printGraph(graph);

        printHamiltonian(graph);

    }

    private static void printHamiltonian(ArrayList<Edge>[] graph) {
        HashSet<Integer> visited = new HashSet<>();

        String psf = 0 + "";
        drawTree(0, graph, visited, psf, 0);
    }

    private static void drawTree(int src, ArrayList<Edge>[] graph, HashSet<Integer> visited, String psf, int oSrc) {

        if (visited.size() == graph.length - 1) {
            boolean isNbr = false;
            for (Edge e : graph[src]) {
                if (e.nbr == oSrc) {
                    isNbr = true;
                    break;
                }
            }
            if (isNbr) {
                System.out.println(psf + "*");
            } else {
                System.out.println(psf + "#");
            }
            return;
        }

        visited.add(src);
        for (Edge edge : graph[src]) {
            if (!visited.contains(edge.nbr)) {
                drawTree(edge.nbr, graph, visited, psf + edge.nbr, oSrc);
            }
        }
        visited.remove(src);
    }

    private static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Edge> edges = graph[i];
            for (Edge e : edges) {
                System.out.print(e.src + "-->" + e.nbr + "\t");
            }
            System.out.println();
        }
    }

    private static class Edge {
        public int src;
        public int nbr;
        public int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
}
