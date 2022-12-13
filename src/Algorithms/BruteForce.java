package Algorithms;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.Arrays;

import static Lower_Upper_bound_approx.Upper_bound.upperBound_vertCov;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class BruteForce {


    // brute force:
    public static int bruteForce(GraphMatrix g){
        int numVert = g.getNumVert();
        int[] color = new int[numVert];
        int start_k = numVert;
//        System.out.println("start k " + start_k);
        while(true){
            System.out.println("start k, while " + start_k);
            boolean success = kColoring(g,start_k,0,color);
            System.out.println("success " + success);
            if(success){
                start_k = start_k - 1;
            }
            else {
                return start_k + 1;
            }
        }
    }

    ///////////////////////// helper methods ///////////////////////////////

    // A recursive function that takes the current index, number of vertices, and the color array. If the recursive call
    // returns true then the coloring is possible. It returns false if k colors cannot be assigned
    public static boolean kColoring(GraphMatrix g, int k, int i, int color[]) {
        int numVert = g.getNumVert();
        // If we have reached the last vertex then check if legal
        if (i == numVert) {
            return isLegal(g, color);
        }
        // Assigning color to the vertex and recursively call the function
        for (int j = 1; j <= k; j++) {
            color[i] = j;
            if (kColoring(g, k, i + 1, color)) {
//                System.out.println("here");
                return true;
            }
            color[i] = 0;
//            System.out.println(Arrays.toString(color));
        }
        return false;
    }

    // function that checks if the current coloring of the graph is legal or not
    public static boolean isLegal(GraphMatrix g, int[] color) {
        int vertNum = g.getNumVert();
        for (int i = 0; i < vertNum; i++) {
            for (int j = i + 1; j < vertNum; j++) {
                if (g.hasEdge(i, j) && color[j] == color[i])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        GraphMatrix g = new GraphMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

//        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph07_2022.txt";
//        GraphMatrix g = createGraphFromTxt_Matrix(path);

        System.out.println(bruteForce(g));
    }

}
