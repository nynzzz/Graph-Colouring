package Lower_Upper_bound_approx;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class Lower_bound {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph03_2022.txt";
//        GraphMatrix g = createGraphFromTxt_Matrix(path);

        GraphMatrix g = new GraphMatrix(3);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);

//        g.addEdge(0,4);
//        g.addEdge(1,2);
//        g.addEdge(1,3);
//        g.addEdge(1,4);
//        g.addEdge(2,4);
//        g.addEdge(3,4);

        System.out.println("lowerBound_cycle " + lowerBound_cycle(g));
//        System.out.println("cycle-clique " + checkIfCycle(g));
    }

    //lower bound approximation based on the odd/even length cycles
    public static int lowerBound_cycle(GraphMatrix g){
        if(hasOddCycle(g, 0)){
            return 3;
        }
        return 2;
    }
    public static boolean hasOddCycle(GraphMatrix g, int v) {

        boolean[][] adjCopy = g.getAdj();
        int[][] adjCopy_int = new int[adjCopy.length][adjCopy[0].length];

        for (int i = 0; i < adjCopy.length; i++) {
            for (int j = 0; j < adjCopy[0].length; j++) {
                if (adjCopy[i][j]){
                    System.out.println("here");
                    adjCopy_int[i][j] = 1;
                }
                adjCopy_int[i][j] = 0;
            }
        }
        for (int i = 0; i < adjCopy_int.length; i++) {
            for (int j = 0; j < adjCopy_int[0].length; j++) {
                System.out.println("old " + adjCopy_int[i][j]);
            }
        }


        int numVert = g.getNumVert();
        int colourArray[] = new int[numVert];
        for (int i = 0; i < numVert; i++)
            colourArray[i] = -1;

        colourArray[v] = 1;

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(v);

        while (!q.isEmpty()) {

            for (int i = 0; i < adjCopy_int.length; i++) {
                for (int j = 0; j < adjCopy_int[0].length; j++) {
                    System.out.println(adjCopy_int[i][j]);
                }
            }

            int vertex = q.peek();
            q.pop();

            for (int notCol = 0; notCol < numVert; notCol++) {
                System.out.println("vertex " + vertex + " notCol " + notCol);
                System.out.println("adjCopy_int[vertex][notCol] " + adjCopy_int[vertex][notCol]);
                System.out.println("adjCopy[vertex][notCol] " + adjCopy[vertex][notCol]);
                System.out.println("-------------------------");
                if (adjCopy_int[vertex][notCol] == 1 && colourArray[notCol] == -1) {
                    colourArray[notCol] = 1 - colourArray[v];
                    q.push(notCol);
                }
                else if (adjCopy_int[vertex][notCol] == 1 && colourArray[notCol] == colourArray[vertex])
                    return true;
            }
        }
        return false;
    }

    //lower bound approximation based on the size of the largest MAXIMAL clique
    //uses Bron-Kerbosch algorithm (originally returns all maximal matchings)

    static ArrayList<ArrayList<Integer>> maximalCliques = new ArrayList<>();

    public static int lowerBound_Clique(GraphMatrix g){

        ArrayList<Integer> r = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();

        boolean[][] adjCopy = g.getAdj();

        for (int i = 0; i < adjCopy.length; i++) {
            for (int j = 0; j < adjCopy[0].length; j++) {
                if(adjCopy[i][j] == true){
                    if(!p.contains(i)){
                        p.add(i);
                    }
                    else if(!p.contains(j)){
                        p.add(j);
                    }
                }
            }
        }
        Bron_Kerbosch_WithoutPivot(g, r, p, x);

//        for (int i = 0; i < maximalCliques.size(); i++) {
//            System.out.println("maximal cliques " + maximalCliques.get(i));
//        }

        ArrayList<Integer> largestMaximalClique = new ArrayList<>();
        for (int i = 0; i < maximalCliques.size(); i++) {
            ArrayList<Integer> ith = maximalCliques.get(i);
            int ithSize = ith.size();
            if(largestMaximalClique.size() < ithSize){
                largestMaximalClique = ith;
            }
        }
        int largestMaximalClique_Size = largestMaximalClique.size();

        return largestMaximalClique_Size;
    }
    static int vert = 0;
    public static void  Bron_Kerbosch_WithoutPivot(GraphMatrix g, ArrayList<Integer> r, ArrayList<Integer> p, ArrayList<Integer> x) {

//        System.out.println("p size " + p.size());
//        System.out.println("x size " + x.size());

        if(p.size() == 0 && x.size() == 0) {
//            System.out.println("IF_1");
            if (!maximalCliques.contains(r)) {
//                System.out.println("IF_2");
//                System.out.println("r " + r);
                maximalCliques.add(r);
            }
        }

        ArrayList<Integer> p1 = new ArrayList<Integer>(p);



        while(!p.isEmpty()){
//            int v = p.get(vertex);
//            int pSize = p.size();
            for (int i = 0; i < p.size(); i++) {
                int v = p.get(i);
                vert = i;
//                System.out.println("while");
                r = new ArrayList<>(set_Union_v(r, v));
                p = new ArrayList<>(set_intersection_neighOfV(g, p1, v));
                x = new ArrayList<>(set_intersection_neighOfV(g, x, v));
                Bron_Kerbosch_WithoutPivot(g, r, p, x);
//                System.out.println("vert " + vert);
            }
//            System.out.println("vert " + vert);
//            System.out.println("r size " + r.size());
//            System.out.println("p1 size " + p1.size());
            r.remove(vert);
            if(p1.size() != 0){
                //System.out.println("here");
                p1.remove(vert);
            }
            x.add(vert);

        }

    }

    ////////helper methods//////////

    public static ArrayList<Integer> set_Union_v(ArrayList<Integer> r, int v){;
        if(!r.contains(v)) {
            r.add(v);
//            System.out.println("v " + v);
//            System.out.println("r elem: " + r);
        }
        return r;
    }
    public static ArrayList<Integer> set_intersection_neighOfV(GraphMatrix g, ArrayList<Integer> p, int v){
        ArrayList<Integer> neighOfv = (ArrayList<Integer>) g.neighbours(v);
//        System.out.println("neigh of v " + neighOfv);
        int pSize = p.size();
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < pSize; i++) {
            if(p.contains(i) && neighOfv.contains(i)){
                intersection.add(i);
//                System.out.println("intersection " + intersection);
            }
        }
        return intersection;
    }
}
