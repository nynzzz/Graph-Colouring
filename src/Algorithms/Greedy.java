package Algorithms;

import Graph_Implementation.GraphList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

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

//        //print result
//        for(int u = 0; u < v; u++){
//            System.out.println("Vertex " + u + "-------> Color " + result[u]);
//        }

        //chromatic number
        int k = 0;
        Arrays.sort(result);
        int maxColorNum = result[result.length - 1];
        k = maxColorNum + 1;

        System.out.println("chromatic number = " + k);
        return k;
    }

    public static void main(String[] args) {
        GraphList g = new GraphList(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(3,4);

        g.printGraph();
        greedy(g);
    }
}
