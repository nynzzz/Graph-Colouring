package Algorithms;

import Graph_Implementation.GraphList;
import Graph_Implementation.GraphMatrix;

import java.util.Arrays;

public class Backtrack {
    public static int backTrack(GraphMatrix g) {
        int numVert = g.getNumVert();
        int[] colors = new int[numVert];
        Arrays.fill(colors, 0);

        // call color for vertex 0
        if (!color(g, 9999, colors, 0)) {
            System.out.println("solution doesnt exist");
        }
        //printColors(colors);
        Arrays.sort(colors);
        System.out.println("chromatic number = " + colors[colors.length-1]);
        return colors[colors.length-1];
    }

    ///////////////////////// helper methods ///////////////////////////////

    //check if adj vertices of v are not the same color
    public static boolean safeToColor(GraphMatrix g, int[] colors, int col, int v) {
        for (int i = 0; i < g.getNumVert(); i++) {
            if (g.hasEdge(v, i) && col == colors[i]) {
                return false;
            }
        }
        return true;
    }

    //main coloring method
    //m = maximum amount of colors to check with safeToColor method
    public static boolean color(GraphMatrix g, int m, int[] colors, int v) {
        if (v == g.getNumVert())
            return true;

        for (int col = 1; col <= m; col++) {
            //check if assignment of color col to v is oke
            if (safeToColor(g, colors, col, v)) {
                colors[v] = col;
                //assign colors to rest of the vertices
                if (color(g, m, colors, v + 1))
                    return true;
                // If assigning color col doesnt lead to a solution then remove
                colors[v] = 0;
            }
        }
        return false;
    }

    public static void printColors(int[] colors) {
        for (int i = 0; i < colors.length; i++)
            System.out.println("Vertex " + i + " --->  Color " + colors[i]);
    }

    public static void main(String[] args) {
        GraphMatrix g = new GraphMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

       // g.printGraph();
        backTrack(g);
    }
}
