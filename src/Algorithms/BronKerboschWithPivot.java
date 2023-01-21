package Algorithms;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;
import Graph_Implementation.GraphMatrix;

public class BronKerboschWithPivot {
    
    //ArrayList of maximal cliques
    static ArrayList<Set<Integer>> maximalCliques = new ArrayList<Set<Integer>>();
    
    static int lowerBound = 0;

    public static int bronKerboschWithPivot(GraphMatrix g, Set<Integer> R, Set<Integer> P, Set<Integer> X) {

        if (P.isEmpty() && X.isEmpty()) {
            // R is a maximal clique
            maximalCliques.add(R);
            if(lowerBound < R.size()) {
                lowerBound = R.size();
//                System.out.println("The new largest lower bound is: " + lowerBound);
            }
//            return lowerBound;
        }
        
        Set<Integer> PunionX = union(P, X);
        Set<Integer> Pcopy = new HashSet<Integer>(P);

        //Define the pivot as the vertex with the highest degree from P union X
        int pivot = getMaxDegree(g, PunionX);

        //Remove the neighbours of the pivot from P
        Pcopy.removeAll(g.neighbours(pivot));

        //Execute the final algorithm
        for (int v : Pcopy) {
            R.add(v);
            bronKerboschWithPivot(g, R, intersection(P, g.neighbours(v)), intersection(X, g.neighbours(v)));
            R.remove(v);
            P.remove(v);
            X.add(v);
        }
        return lowerBound;
    }

    /////////////////////////Helper methods/////////////////////////

    //Get the vertex with the max degree (for the pivot)
    public static int getMaxDegree(GraphMatrix g, Set<Integer> set1) {
        ArrayList<Integer> set1List = new ArrayList<Integer>(set1);
        int vertexNum = 0;
        int maxDegree = 0;
        int maxDegreeVertex = 0;

        for (int i = 0; i < set1List.size(); i++) {
            vertexNum = set1List.get(i);
            if(g.neighbours(vertexNum).size() > maxDegree) {
                maxDegree = g.neighbours(vertexNum).size();
                maxDegreeVertex = set1List.get(i);
            }
        }

        return maxDegreeVertex;
    }

    //Intersection of two sets
    public static Set<Integer> intersection(Set<Integer> set1, List<Integer> neighbours) {
        Set<Integer> set2 = new HashSet<>(neighbours);
        Set<Integer> intersection = new HashSet<Integer>(set1); 
        intersection.retainAll(set2);
        return intersection;
    }
    
    //Union of two sets
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) { 
        Set<Integer> union = new HashSet<Integer>(set1); 
        union.addAll(set2); 
        return union; 
    } 

    public static void main(String[] args) throws FileNotFoundException {
        //Timer start
        long start = System.currentTimeMillis();

        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/Tournament_TestSuite/phase3_2022_graph14.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);
        int vertNum = g.getNumVert();
        Set<Integer> R = new HashSet<Integer>();
        Set<Integer> P = new HashSet<Integer>();
        Set<Integer> X = new HashSet<Integer>();

        //fill in P with all vertices from graph g
        for (int i = 0; i < vertNum; i++) {
            P.add(i);
        }

        System.out.println(bronKerboschWithPivot(g, R, P, X));

        //Timer end
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format(end - start) + " milliseconds");
    }
}