package txtReader_DIMACS;

import Graph_Implementation.GraphMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class txtReader_DIMACS {
    public static void main(String[] args) throws FileNotFoundException {
        String txtPath = "";
        createGraphFromTxt_DIMACS(txtPath).printGraph();
        //System.out.println(createGraphFromTxt(txtPath).neighbours(45));
    }

    public static GraphMatrix createGraphFromTxt_DIMACS(String txt) throws FileNotFoundException {
        File file = new File(txt);
        Scanner scanner = new Scanner(file);

        int vertNum = 0;
        GraphMatrix graph = null;

        while (scanner.hasNext()) {

            String str = scanner.next();

            if(str.equals("p") && scanner.next().equals("edge")){
                vertNum = Integer.parseInt(scanner.next()) ;
                //System.out.println("size " + vertNum);
                graph = new GraphMatrix(vertNum);
            }
            else if(str.equals("e")){

                //System.out.println(graph.getNumVert() + "numVert");
                int firstVert = Integer.parseInt(scanner.next()) -1;
                int secondVert = Integer.parseInt(scanner.next()) -1;

                //System.out.println("first " + firstVert + " second " + secondVert);

                graph.addEdge(firstVert, secondVert);
                //System.out.println(graph.hasEdge(firstVert, secondVert));
            }
        }
        return graph;
    }

}
