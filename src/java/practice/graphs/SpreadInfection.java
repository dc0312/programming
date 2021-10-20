package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SpreadInfection {
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

    static class Pair{
        int node;
        String psf;
        int level;

        public Pair(int node, String psf, int level) {
            this.node = node;
            this.psf = psf;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", psf='" + psf + '\'' +
                    ", level=" + level +
                    '}';
        }
    }

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

        boolean[] visited = new boolean[vertices];
        LinkedList<Pair> queue = new LinkedList<>();

        queue.addLast(new Pair(6, 6 + "", 1));

        int time = 3;

        while (!queue.isEmpty()) {
            Pair temp = queue.removeFirst();
            if (visited[temp.node]) {
                continue;
            }
            visited[temp.node] = true;
            if (temp.level > time) {
                break;
            }
            System.out.println(temp.node+"@"+temp.psf+"-"+temp.level);


            for (Edge e : graph[temp.node]) {
                if (!visited[e.nbr]) {
                    queue.addLast(new Pair(e.nbr, temp.psf + e.nbr, temp.level+1));
                }
            }
        }

    }
}
