package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgoShortestPath {
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

    static class Pair implements Comparable {
        int node;
        String psf;
        int wt;

        public Pair(int node, int wt, String psf) {
            this.node = node;
            this.wt = wt;
            this.psf = psf;
        }


        @Override
        public int compareTo(Object o) {
            return this.wt - ((Pair) o).wt;
        }
    }

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


        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0, 0 + ""));
        boolean visited[] = new boolean[vertices];

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (visited[temp.node]) {
                continue;
            }
            visited[temp.node] = true;
            System.out.println(temp.node + "@" + temp.psf + "=" + temp.wt);

            for (Edge e : graph[temp.node]) {
                if (!visited[e.nbr]) {
                    queue.add(new Pair(e.nbr, temp.wt + e.wt, temp.psf + e.nbr));
                }
            }
        }
    }
}
