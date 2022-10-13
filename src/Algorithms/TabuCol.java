package Algorithms;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.*;

import static txtReader_DIMACS.txtReader_DIMACS.createGraphFromTxt_DIMACS;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class TabuCol {

    public static HashMap<Integer, Integer> tabuCol(GraphMatrix graph, int numOfColors) {

        int graphLen = graph.getNumVert();

        int tabuSize = 10;
        int reps = 150;         //number of neigh generated
        int maxIter = 1000000;

        int iterations = 0;

        ArrayList<Integer> colors = new ArrayList<>();
        for (int i = 0; i < numOfColors; i++) {
            colors.add(i);
        }

        Queue<int[]> tabu = new LinkedList<>();

        //initial random solution
        HashMap<Integer, Integer> solution = new HashMap<>();
        for (int i = 0; i < graphLen; i++) {
            int colorToAdd = getRandomInteger(colors.size(), 0);
            solution.put(i, colorToAdd);
        }

        //Aspiration level A(z), represented by a mapping: f(s) -> best f(s') seen so far
        // TODO change later !!!
        HashMap<Integer, Integer> aspirationLevel = new HashMap<>();


        int conflictCount = 0;

        while (iterations < maxIter) {
            conflictCount = 0;
            ArrayList<Integer> moveCandidates = new ArrayList<>();

            for (int i = 0; i < graphLen; i++) {
                for (int j = i + 1; j < graphLen; j++) {
                    if (graph.hasEdge(i, j)) {
                        if (solution.get(i).equals(solution.get(j))) {
                            moveCandidates.add(i);
                            moveCandidates.add(j);
                            conflictCount = conflictCount + 1;
                        }
                    }
                }
            }
            if (conflictCount == 0)
                break;

            HashMap<Integer, Integer> newSolution = new HashMap<>();
            int node = 0;
            for (int i = 0; i < reps; i++) {
                //choose a node to move
                //if no candidates then return solution //TODO
                if (moveCandidates.isEmpty()) {
                    System.out.println("coloring found, no candidates to move :");
                    return solution;
                }

                node = moveCandidates.get(getRandomInteger(moveCandidates.size(), 0));
                //System.out.println("node " + node);

                //choose color but not current
                int newColor = colors.get(getRandomInteger(colors.size() - 1, 0));
                if (solution.get(node) == newColor) {
                    // swap last color and current color for this calc
                    newColor = colors.get(colors.size() - 1);
                    //System.out.println("1");
                }
                // a node to check later in tabu
                int[] nodeToCheck = {node, newColor};
                //System.out.println("Node_To_Check " + Arrays.toString(nodeToCheck));

                //create a neigh solution
                newSolution.putAll(solution);
                newSolution.replace(node, newColor);

                //adj pairs with the same color in newSolution
                int newConflicts = 0;

                for (int j = 0; j < graphLen; j++) {
                    for (int k = j + 1; k < graphLen; k++) {
                        if (graph.hasEdge(j, k) && newSolution.get(j).equals(newSolution.get(k))) {
                            newConflicts = newConflicts + 1;
                            //System.out.println("2");
                        }
                    }
                }
//                System.out.println("NEW conf " + newConflicts);
//                System.out.println("OLD conf " + conflictCount);
                //TODO Something wrong with heuristic
                //found an improved solution?
                if (newConflicts < conflictCount) {
                    //System.out.println("3");
                    aspirationLevel.computeIfAbsent(conflictCount, c -> c - 1);

                    if (newConflicts <= aspirationLevel.get(conflictCount)) {
                        //System.out.println("5");
                        aspirationLevel.replace(conflictCount, newConflicts - 1);
//                        System.out.println("conflictCount " + conflictCount);
//                        System.out.println("newConglicts " + newConflicts + " aspirationLevel.get(conflictCount) " + aspirationLevel.get(conflictCount));
                        if (tabu.contains(nodeToCheck)) {
                            //System.out.println("6");
                            tabu.remove(nodeToCheck);
                        }
                    } else if (tabu.contains(nodeToCheck)) {            //tabu move is not good
                        continue;
                    }
                }
                //System.out.println("new conflicts " + newConflicts);
            }
            //print the tabu
//            for(int[] s : tabu) {
//                System.out.println("tabu " + Arrays.toString(s));
//            }
//            System.out.println("-----------------------------------------");


            // found a better solution or ran out of reps using the last solution generated

            //current node/color becomes tabu
            //TODO should probably be nodeToCheck
            int[] currentNode = {node, solution.get(node)};
            tabu.add(currentNode);

            if (tabu.size() > tabuSize) {
                tabu.remove();
            }
            // next iteration with new solution
            solution.putAll(newSolution);
            iterations = iterations + 1;

//            if (iterations % 100 == 0) {
//                System.out.println("iterations " + iterations);
//            }
        }

        // conflictCount = 0 and solution found or iterations > maxIterations and no solution
        System.out.println("conflict count " + conflictCount);
        if (conflictCount != 0) {
            System.out.println("no coloring found");
            return null;
        } else {
            System.out.println("coloring found");
            return solution;
        }
    }


    //////////////////////// helper methods /////////////////////
    public static int getRandomInteger(int maximum, int minimum){
            return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph20_2022.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);

//        GraphMatrix g = new GraphMatrix(5);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(1, 3);
//        g.addEdge(2, 3);
//        g.addEdge(3, 4);
//
        System.out.println(tabuCol(g, 10));
    }
}
