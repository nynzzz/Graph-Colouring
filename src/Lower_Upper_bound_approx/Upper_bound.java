package Lower_Upper_bound_approx;

import Graph_Implementation.GraphMatrix;

import java.util.Arrays;

public class Upper_bound {

    public static void main(String[] args){

    }

    //upper bound based on maximum degree of the graph
    public static int maxDegreeBound_maxDegree(GraphMatrix g){

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
    public static int maxDegreeBound_vertCov(GraphMatrix g){

        return 1;
    }
}
