package Algorithms;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

import static Algorithms.Backtrack.backTrack;
import static txtReader_DIMACS.txtReader_DIMACS.createGraphFromTxt_DIMACS;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class TabuCol {
    public static boolean TabuCol_kGCP(GraphMatrix graph, int maxIter, int k){
        // Number of vertices
        int numVert = graph.getNumVert();
        // The current coloring of the graph
        int[] coloring = new int[numVert];

        // The tabu list, which is a list of vertices that are "tabu" (cannot be colored). Pairs of [vertex, color]
        Queue<Move> TabuQueue = new LinkedBlockingQueue<>();

        // Initialize the coloring. Initially random
        for (int i = 0; i < numVert; i++) {
            int vertex = i;
            int color = getRandomInteger(k-1,0);
            Move initialMove = new Move(vertex, color);
            TabuQueue.add(initialMove);
            coloring[vertex] = color;
        }
        // The current iteration of the algorithm
        int iteration = 0;
        // Search space. Neighbourhood size - colourings which can be reached by one-step move
        int spaceSize = ((k-1)*numVert)*2;

        // Continue until the maximum number of iterations is reached or the coloring is valid
        while (!isLegal(graph, coloring)) {

            if(iteration >= maxIter){
//                System.out.println("Out of max iterations");
                return false;
            }

//            System.out.println("-----------------------");
//            printTabu(TabuQueue);
//            System.out.println("itr: " + iteration);
//            System.out.println("Tabu Size: " + TabuQueue.size());


            // Current coloring evalFun value
            int currentEval = evalFun(graph, coloring);
//            System.out.println("currentEval: " + currentEval);
//            System.out.println("-----------------------");
            if(currentEval == 0){
//                System.out.println("No conflicts with k = " + k);
                return true;
            }
            // Neighborhood - possible solutions that can be reached by one-step move
            List<int[]> neighbourhood = new ArrayList<>();
            // Vertices used to build the neighborhood
            List<Integer> neighVertices = new ArrayList<>();
            // Colors assigned to neighVertices when building the neighborhood
            List<Integer> neighColors = new ArrayList<>();
            // Build the neighborhood
            for (int i = 0; i < spaceSize; i++) {
                int randomVertex = getRandomInteger(numVert, 0);
                neighVertices.add(randomVertex);
                int[] localColoring = coloring.clone();
                oneStepMove(graph, localColoring, k, randomVertex, neighColors, TabuQueue);
                neighbourhood.add(localColoring);
            }
            // Pick neighborhood with max difference in EvalFun value (with the fewest number of conflicts)
            int neighID = pickNextNeigh(neighbourhood, graph, currentEval);
            // Pick next vertex and color
            int nextVertex = neighVertices.get(neighID);
            int colorNextVertex = neighColors.get(neighID);

            // Perform the move in the actual solution
            coloring[nextVertex] = colorNextVertex;
            // Update current eval value
            currentEval = evalFun(graph, coloring);
            // Make the found combination of vertex/color a Move obj
            Move move = new Move(nextVertex, colorNextVertex);
            // Add move to the tabu list
            TabuQueue.add(move);
            // Update the tabu q
            while(tabuDuration(currentEval) < TabuQueue.size()){
                TabuQueue.remove();
            }
            iteration++;
        }
//        int eeee = evalFun(graph, coloring);
//        System.out.println("Last Eval, out of while: " + eeee);
//        System.out.println("No conflicts with k = " + k);
        return true;
    }

    public static void TabuCol(GraphMatrix g){
        int start_k = backTrack(g);
        System.out.println("NEW BEST UPPER BOUND = " + start_k);
        while (true){
            boolean success = TabuCol_kGCP(g,10000,start_k);
            if(success){
                System.out.println("NEW BEST UPPER BOUND = " + start_k);
                start_k = start_k - 1;
            }
            else {
                break;
            }
        }
    }

    //////////////// helper methods //////////////////

    // Check eval fun value for a specific move if better or not then current eval
    public static boolean checkIfBetter(GraphMatrix g, int[] coloring, int vertex, int color, int currentEval){
        int[] coloringToCheck = coloring.clone();
        coloringToCheck[vertex] = color;
        int evalOfColoringToCheck = evalFun(g,coloringToCheck);
        return evalOfColoringToCheck < currentEval;
    }

    // Print the tabu list
    public static void printTabu(Queue<Move> TabuQueue){
        for (Move m : TabuQueue) {
            System.out.println("Vertex: " + m.vertex + ", Color: " + m.color);
        }
    }

    // returns time duration to be spent in the tabu list for a given move
    public static long tabuDuration(int eval){
        int l = getRandomInteger(9,0);

//        System.out.println("eval: " + eval);
//        System.out.println("l: " + l);

        double lambda = 0.6;   // 0.38
//        System.out.println("tabuDuration: " + (long) (eval*lambda+l));
        return (long) (eval*lambda+l);
    }

    // Evaluation function. Measures the number of conflicts in a solution (complete solution)
    public static int evalFun(GraphMatrix g, int[] coloring){
        int conflicts = 0;
        int graphLen = g.getNumVert();
        for (int i = 0; i < graphLen; i++) {
            for (int j = i + 1; j < graphLen; j++) {
                if (g.hasEdge(i, j) && coloring[i] == coloring[j]) {
                    conflicts = conflicts + 1;
                }
            }
        }
        return conflicts;
    }

    // One-step move - changing the color of vertex v to color c
    public static void oneStepMove(GraphMatrix graph, int[] coloring, int k, int vertex, List<Integer> neighColors, Queue<Move> TabuQueue){

        boolean notFoundYet = true;

        while(notFoundYet) {
            int color = pickBestColor(vertex, graph, coloring, k);
//            int color = getRandomInteger(k-1,0);
            Move move = new Move(vertex, color);
            if(!TabuQueue.contains(move)){
                neighColors.add(color);
                coloring[vertex] = color;
                notFoundYet = false;
            }
        }
    }

    public static int pickNextNeigh(List<int[]> neighborhood, GraphMatrix g, int currentEval){
        int[] neighEval = new int[neighborhood.size()];
        for (int i = 0; i < neighborhood.size(); i++) {
            int[] candidateColoring = neighborhood.get(i);
            int candidateColoringConflicts = evalFun(g,candidateColoring);
            neighEval[i] = currentEval - candidateColoringConflicts;
        }
        int indexOfBestNeigh = argmax(neighEval);
        return indexOfBestNeigh;
    }

    // Pick the best color for the given vertex using the least constraining value heuristic
    private static int pickBestColor(int vertex, GraphMatrix graph, int[] coloring, int k) {
        int[] colorCount = new int[k];

        int numVert = graph.getNumVert();
        // Count the number of times each color is used among the neighbors of the vertex
        for (int i = 0; i < numVert; i++) {
            if (graph.hasEdge(vertex, i) && coloring[i] != -1) {
                colorCount[coloring[i]]++;
            }
        }
        // Pick the color that is used the least among the neighbors
        int minCount = Integer.MAX_VALUE;
        int color = -1;
        for (int i = 0; i < k; i++) {
            if (colorCount[i] < minCount) {
                minCount = colorCount[i];
                color = i;
            }
        }
        return color;
    }

    // Function that checks if the current coloring of the graph is legal or not (complete solution)
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
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    // argmin
    public static int argmin(int[] a) {
        int v = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < v) {
                v = a[i];
                ind = i;
            }
        }
        return ind;
    }

    // argmax
    public static int argmax(int[] a) {
        int re = Integer.MIN_VALUE;
        int arg = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > re) {
                re = a[i];
                arg = i;
            }
        }
        return arg;
    }

    // Move class
    static class Move {
        int vertex;
        int color;

        public Move(int vertex, int color) {
            this.vertex = vertex;
            this.color = color;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/Tournament_TestSuite/phase3_2022_graph11.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);
//          GraphMatrix g = createGraphFromTxt_DIMACS(path);

        System.out.println(TabuCol_kGCP(g, 100000, 11));
//        System.out.println(TabuCol(g));
    }
}
