package Lower_Upper_bound_approx;

import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class Upper_bound {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph01_2022.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);

        System.out.println("Max Degree approximation " + upperBound_maxDegree(g));
        System.out.println("Vertex Cover  approximation " + upperBound_vertCov(g));
    }

    //upper bound based on maximum degree of the graph
    public static int upperBound_maxDegree(GraphMatrix g) {

        int vertNum = g.getNumVert();
        int[] degree = new int[vertNum];

        for (int i = 0; i < degree.length; i++) {
            degree[i] = g.neighbours(i).size();
        }

        Arrays.sort(degree);
        int maxDegree = degree[degree.length - 1];
        //upper bound = max. degree of the graph + 1
        int bound = maxDegree + 1;

        return bound;
    }

    //upper bound based on the size of vertex cover
    public static int upperBound_vertCov(GraphMatrix g) {

        ArrayList<Integer> vc = new ArrayList<>();
        boolean[][] adjCopy = g.getAdj();
        int rows = adjCopy.length;
        int col = adjCopy[0].length;

        //while adj matrix is NOT empty do
        while (!adjMatrixIsEmpty(adjCopy)) {

            int[] arbitraryEdge = chooseRandomEdgeFrom(adjCopy);
            int vertex1 = arbitraryEdge[0];
            int vertex2 = arbitraryEdge[1];

            if (!vc.contains(vertex1)) {
                vc.add(vertex1);
            }
            if (!vc.contains(vertex2)) {
                vc.add(vertex2);
            }

            for (int i = 0; i < rows; i++) {
                adjCopy[i][vertex1] = false;
                adjCopy[vertex1][i] = false;
            }
        }

        int vcSize = vc.size();
        int bound = vcSize + 1;

        return bound;
    }

    /////////helper methods//////////

    public static boolean adjMatrixIsEmpty(boolean[][] arr) {

        int rows = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    public static int[] chooseRandomEdgeFrom(boolean[][] arr) {

        int rows = arr.length;
        int col = arr[0].length;

        ArrayList<int[]> listOfNeighInArr = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == true) {
                    int[] pair = {i, j};
                    listOfNeighInArr.add(pair);
                }
            }
        }
        int listSize = listOfNeighInArr.size();
        int randomIndex = getRandomInteger(listSize, 0);
        int[] randomEdge = listOfNeighInArr.get(randomIndex);

        return randomEdge;
    }

}
