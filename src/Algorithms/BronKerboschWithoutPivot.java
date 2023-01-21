package Algorithms;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static txtReader_DIMACS.txtReader_DIMACS.createGraphFromTxt_DIMACS;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;
import Graph_Implementation.GraphMatrix;

public class BronKerboschWithoutPivot {
    
    //ArrayList of maximal cliques
    static ArrayList<Set<Integer>> maximalCliques = new ArrayList<Set<Integer>>();
    static int lowerBound = 0;

    public static int bronKerboschWithoutPivot(GraphMatrix g, Set<Integer> R, Set<Integer> P, Set<Integer> X) {

        if (P.isEmpty() && X.isEmpty()) {
            // R is a maximal clique
            maximalCliques.add(R);
            if(lowerBound < R.size()) {
                lowerBound = R.size();
//                System.out.println("The new biggest lower bound is: " + lowerBound);
            }
        }
        
        Set<Integer> Pcopy = new HashSet<Integer>(P);

        for (int v : Pcopy) {
            R.add(v);
            bronKerboschWithoutPivot(g, R, intersection(P, g.neighbours(v)), intersection(X, g.neighbours(v)));
            R.remove(v);
            P.remove(v);
            X.add(v);
        }
        return lowerBound;
    }

    //Intersection of two sets - SAME
    public static Set<Integer> intersection(Set<Integer> set1, List<Integer> neighbours) {
        Set<Integer> set2 = new HashSet<>(neighbours);
        Set<Integer> intersection = new HashSet<Integer>(set1); 
        intersection.retainAll(set2);
        return intersection;
    }
    
    //Union of two sets - EVERYTHING
    public static Set<Integer> union(Set<Integer> set1, List<Integer> neighbours) { 
        Set<Integer> set2 = new HashSet<>(neighbours);
        Set<Integer> union = new HashSet<Integer>(set1); 
        union.addAll(set2); 
        return union; 
    } 

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_DIMACS/dsjc125.1_5.txt";
//        GraphMatrix g = createGraphFromTxt_Matrix(path);
        GraphMatrix g = createGraphFromTxt_DIMACS(path);
        int vertNum = g.getNumVert();
        Set<Integer> R = new HashSet<Integer>();
        Set<Integer> P = new HashSet<Integer>();
        Set<Integer> X = new HashSet<Integer>();

        //fill in P
        for (int i = 0; i < vertNum; i++) {
            P.add(i);
        }
        System.out.println("Lower bound BKWP: " + bronKerboschWithoutPivot(g, R, P, X));
    }
    
}