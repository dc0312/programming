package practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IsGraphCyclic {
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

    public static void main(String[] args) {
        int vertices = 7;
        //Create a graph
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        //Initialize the graph
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        List<String> edges = Arrays.asList("0,1,10", "2,3,10", "4,5,10", "5,6,10", "4,6,10");
        for (String edge : edges) {
            String[] parts = edge.split(",");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int v3 = Integer.parseInt(parts[2]);

            graph[v1].add(new Edge(v1, v2, v3));
            graph[v2].add(new Edge(v2, v1, v3));
        }
        boolean isCycle = false;
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                if(isGraphCyclic(graph, i, visited)){
                    isCycle = true;
                    break;
                }
            }
        }
        System.out.println("Is graph cyclic ? " + isCycle);
    }

    private static boolean isGraphCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(src);

        while (!queue.isEmpty()) {
            Integer temp = queue.removeFirst();

            if (visited[temp]) {
                return true;
            }
            visited[temp] = true;

            for (Edge e : graph[temp]) {
                if (!visited[e.nbr]) {
                    queue.addLast(e.nbr);
                }
            }
        }
        return false;
    }
}
