package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BFSGraph {

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
        printBFS(graph, 0);
    }

    private static void printBFS(ArrayList<Edge>[] graph, int src) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, src + ""));
        boolean[] visited = new boolean[graph.length];
        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (visited[rem.v]) {
                continue;
            }
            visited[rem.v] = true;
            System.out.println(rem.v + "@" + rem.psf);
            for (Edge edge : graph[rem.v]) {
                if (!visited[edge.nbr]) {
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }
    }

    static class Pair {
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "v=" + v +
                    ", psf='" + psf + '\'' +
                    '}';
        }
    }

    static class Edge {
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
