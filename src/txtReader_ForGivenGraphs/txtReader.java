package txtReader_ForGivenGraphs;

import Graph_Implementation.GraphMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtReader{
    public static void main(String[] args) throws FileNotFoundException {
        String txtPath = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph01_2022.txt";
        createGraphFromTxt(txtPath).printGraph();
        //System.out.println(createGraphFromTxt(txtPath).neighbours(45));
    }

    public static GraphMatrix createGraphFromTxt(String txt) throws FileNotFoundException {
        File file = new File(txt);
        Scanner scanner = new Scanner(file);

        int vertNum = 0;
        GraphMatrix graph = null;

        while (scanner.hasNext()) {

            String str = scanner.next();

            if(str.equals("VERTICES") && scanner.next().equals("=")){
                vertNum = Integer.parseInt(scanner.next()) ;

                System.out.println("size " + vertNum);

                graph = new GraphMatrix(vertNum);
            }
            else if(str.equals("EDGES") && scanner.next().equals("=")) {

                int numOfEdges = Integer.parseInt(scanner.next());
                System.out.println("Num of Edges " + numOfEdges);
                System.out.println(graph.getNumVert() + " numVert");
            }
            else{
                    int firstVert = Integer.parseInt(scanner.next()) - 1;
                    int secondVert = Integer.parseInt(scanner.next()) - 1;

                    System.out.println("first " + firstVert + " second " + secondVert);

                    graph.addEdge(firstVert, secondVert);
                    System.out.println(graph.hasEdge(firstVert, secondVert));
            }
        }
        return graph;
    }

}

