package Special_Checks;

import java.io.FileNotFoundException;
import Graph_Implementation.GraphMatrix;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class CheckEmptyVertices {

    //loop through each vertex and return the amount of disconnected ones in graph g
    public static int getEmptyVerticesAmount(GraphMatrix g) {
        int disconnectedVertices = 0;
        int vertNum = g.getNumVert();

        for (int i = 0; i < vertNum; i++) {
            if (g.neighbours(i).size() == 0)
                disconnectedVertices++;
        }

        return disconnectedVertices;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:/Users/lucaw/Downloads/Tournament_TestSuite/phase3_2022_graph07.txt";
        GraphMatrix g = createGraphFromTxt_Matrix(path);

        // GraphMatrix h = new GraphMatrix(6);
        // h.addEdge(0, 1);
        // h.addEdge(0, 2);
        // h.addEdge(1, 2);
        // h.addEdge(1, 3);
        // h.addEdge(2, 3);

        System.out.println(getEmptyVerticesAmount(g));
    }
}