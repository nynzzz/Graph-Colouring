package Algorithms;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class Backtrack {
    public static int backTrack(GraphMatrix g) {
        int numVert = g.getNumVert();
//        System.out.println("numVert " + numVert);
        int[] colors = new int[numVert];
        Arrays.fill(colors, 0);

        // call color for vertex 0
        if (!color(g,  colors, 0)) {
            System.out.println("solution not found");
        }
        //printColors(colors);
        Arrays.sort(colors);
//        System.out.println("colors " + Arrays.toString(colors));
        System.out.println("chromatic number = " + colors[colors.length-1] );
        return colors[colors.length-1];
    }

    ///////////////////////// helper methods ///////////////////////////////

    //check if adj vertices of v are not the same color
    public static boolean safeToColor(GraphMatrix g, int[] colors, int col, int v) {
        for (int i = 0; i < g.getNumVert(); i++) {
            if (g.hasEdge(v, i) && col == colors[i]) {
//                System.out.println("v= " + v + " i= " + i);
                return false;
            }
        }
        return true;
    }

    //main coloring method
    //m = maximum amount of colors to check with safeToColor method
    public static boolean color(GraphMatrix g, int[] colors, int v) {
//        System.out.println("v " + v);
        if (v == g.getNumVert())
            return true;

        for (int col = 1; col <= g.getNumVert(); col++) {
            //check if assignment of color col to v is oke
            if (safeToColor(g, colors, col, v)) {
//                System.out.println("col " + col);
                colors[v] = col;
//                System.out.println("colors " + Arrays.toString(colors));
                //assign colors to rest of the vertices
                if (color(g, colors, v + 1)) {
                    return true;
                }
                // if assigning color col doesnt lead to a solution then remove
                colors[v] = 0;
            }
        }
        return false;
    }



    public static void main(String[] args) throws FileNotFoundException {
//        GraphMatrix g = new GraphMatrix(5);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(1, 3);
//        g.addEdge(2, 3);
//        g.addEdge(3, 4);

        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph07_2022.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);
       // g.printGraph();
        backTrack(g);
    }
}
