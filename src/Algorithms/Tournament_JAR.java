package Algorithms;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Set;

import static Algorithms.BronKerboschWithPivot.bronKerboschWithPivot;
import static Special_Checks.FullyConnected.isFullyConnected;
import static Special_Checks.isBipartite.isBipartite;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;
import static Algorithms.TabuCol.TabuCol;

public class Tournament_JAR {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/Tournament_TestSuite/phase3_2022_graph15.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);
        // Check for Complete graph
        boolean complete = isFullyConnected(g);
        if(complete){
            System.out.println("CHROMATIC NUMBER = " + g.getNumVert());
        }
        // Check for Bipartite graph
        else{
            boolean bipartite = isBipartite(g);
            if(bipartite){
                System.out.println("CHROMATIC NUMBER = " + 2);
            }
            // Find Lower and Upper bounds
            else{
                // Lower Bound
                int vertNum = g.getNumVert();
                Set<Integer> R = new HashSet<Integer>();
                Set<Integer> P = new HashSet<Integer>();
                Set<Integer> X = new HashSet<Integer>();
                for (int i = 0; i < vertNum; i++) {
                    P.add(i);
                }
                int lb = bronKerboschWithPivot(g, R, P, X);
                System.out.println("NEW BEST LOWER BOUND = " + lb);

                // Upper Bound
                TabuCol(g);
            }
        }
    }
}
