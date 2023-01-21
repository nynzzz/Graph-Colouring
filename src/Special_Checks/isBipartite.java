package Special_Checks;

import Graph_Implementation.GraphMatrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class isBipartite {
    public static boolean isBipartite(GraphMatrix g) {
        int n = g.getNumVert();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for (int start = 0; start < n; start++) {
            if (colors[start] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                colors[start] = 0;

                while (!queue.isEmpty()) {
                    int vertex = queue.poll();

                    for (int neighbor = 0; neighbor < n; neighbor++) {
                        if (g.hasEdge(vertex,neighbor) && colors[neighbor] == -1) {
                            colors[neighbor] = 1 - colors[vertex];
                            queue.add(neighbor);
                        } else if (g.hasEdge(vertex,neighbor) && colors[neighbor] == colors[vertex]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        boolean result = isBipartite(g);
        if(result) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }
    }

}
