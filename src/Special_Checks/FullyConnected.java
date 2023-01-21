package Special_Checks;

import static Special_Checks.CheckEmptyVertices.getEmptyVerticesAmount;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;
import java.io.FileNotFoundException;
import Graph_Implementation.GraphMatrix;


public class FullyConnected {

    //Checks if the graph is fully connected using the n : (n(n-1))/2 ratio for vertices : edges
    public static boolean isFullyConnected(GraphMatrix g) {
        int vertNum = getTrueVert(g);
        int edgeNum = g.getNumEdg();
        if(edgeNum == ((vertNum * (vertNum - 1))/2)) {
            return true;
        }
        else return false;
    }

    ///////////helper methods///////////

    //Returns the amount of vertices minus the amount disconnected vertices
    public static int getTrueVert(GraphMatrix g) {
        int vertNum = g.getNumVert();
        int trueVertNum = vertNum - getEmptyVerticesAmount(g);
        return trueVertNum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/Tournament_TestSuite/phase3_2022_graph01.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);
        
        System.out.println(getEmptyVerticesAmount(g) + " disconnected vertex/vertices");
        System.out.println(getTrueVert(g) + " total amount of vertices with edges");
        System.out.println(g.getNumEdg() + " total amount of edges");
        if(isFullyConnected(g)) {
            System.out.println("The selected graph is fully connected! The chromatic number is " + getTrueVert(g));
        }
        else {
            System.out.println("The selected graph is not fully connected.");
        }
    }
}
