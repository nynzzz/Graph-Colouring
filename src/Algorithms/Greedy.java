package Algorithms;

import Graph_Implementation.GraphList;
import Graph_Implementation.GraphMatrix;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;

import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_List;
import static txtReader_ForGivenGraphs.txtReader.createGraphFromTxt_Matrix;

public class Greedy {
    public static int greedy (GraphList g){
        //num of vert
        int v = g.getNumVert();
        int[] result = new int[v];

        //all vert are unassigned
        Arrays.fill(result, -1);

        //assign 1st color
        result[0] = 0;

        //available colors
        boolean[] avail = new boolean[v];
        Arrays.fill(avail, true);

        //assign color to remain vert
        for (int i = 1; i < v; i++) {
            //mark adj vert color as unvlbl
            Iterator<Integer> it = g.getAdj()[i].iterator();
            while(it.hasNext()){
                int j = it.next();
                if(result[j] != -1){
                    avail[result[j]] = false;
                }
            }
            //find first avail color
            int col;
            for(col = 0; col < v; col++){
                if(avail[col] == true){
                    break;
                }
            }
            result[i] = col;
            //reset values for next iteration
            Arrays.fill(avail, true);
        }

        //chromatic number
        int k = 0;
        Arrays.sort(result);
        int maxColorNum = result[result.length - 1];
        k = maxColorNum + 1;

//        System.out.println("chromatic number = " + k);
        return k;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        GraphList g = new GraphList(5);
//        g.addEdge(0,1);
//        g.addEdge(0,2);
//        g.addEdge(1,2);
//        g.addEdge(1,3);
//        g.addEdge(2,3);
//        g.addEdge(3,4);

        String path = "/Users/mymac/Desktop/Graph_Coloring_1.1/Graph_Coloring_1.1/src/txtReader_ForGivenGraphs/graph01_2022.txt";
        GraphList g = createGraphFromTxt_List(path);

        greedy(g);
    }
}
