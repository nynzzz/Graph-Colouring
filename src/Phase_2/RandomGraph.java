package Phase_2;

import Graph_Implementation.GraphMatrix;

public class RandomGraph {

    public static void main (String[] args){
//        GraphMatrix graph = randomGraph(7, 10, 6);
//        graph.printGraph();
//        for (int i = 0; i < graph.getNumVert(); i++) {
//            System.out.println(graph.neighbours(i).size());
//        }
        GraphMatrix graph2 = randomGraph_GUI(7,10);
        graph2.printGraph();

    }

    // edge num max = (vertNum * maxDegree) / 2
    // edge num max = vertNum * (vertNum - 1)
    // maxDegree = numVert - 1
    public static GraphMatrix randomGraph(int vertNum, int edgeNum, int maxDegree){

        if(maxDegree >= vertNum){
            throw new IllegalArgumentException("to high max degree, change the input");
        }

        int maxAllowedEdgesByDegree = (maxDegree * vertNum) / 2;
        int maxPossibleNumberOfEdges = vertNum * (vertNum - 1) / 2;
        if(edgeNum > Math.min(maxAllowedEdgesByDegree, maxPossibleNumberOfEdges)){
            throw new IllegalArgumentException("to many edges, change the input");
        }

        GraphMatrix graph = new GraphMatrix(vertNum);

        int remaining = edgeNum;
        while (remaining > 0) {

            int vert1 = getVertex_lessMaxDegree(graph, maxDegree);
            int vert2 = getVertex_lessMaxDegree(graph, maxDegree);

            if(vert1 == vert2){
                continue;
            }
            if(graph.hasEdge(vert1, vert2)){
                continue;
            }
            graph.addEdge(vert1, vert2);

            remaining --;
        }
        return graph;
    }

    //version without maxDegree
    // edge num max = (vertNum * maxDegree) / 2
    // edge num max = vertNum * (vertNum - 1)
    // maxDegree = numVert - 1
    public static GraphMatrix randomGraph_GUI(int vertNum, int edgeNum){

        GraphMatrix graph = new GraphMatrix(vertNum);

        int remaining = edgeNum;
        while (remaining > 0) {

            int vert1 = getRandomInteger(vertNum,0);
            int vert2 = getRandomInteger(vertNum,0);

            if(vert1 == vert2){
                continue;
            }
            if(graph.hasEdge(vert1, vert2)){
                continue;
            }
            graph.addEdge(vert1, vert2);

            remaining --;
        }
        return graph;
    }



    public static int getVertex_lessMaxDegree(GraphMatrix graph, int maxDegree){
        // find a vertex with smaller or equeal degree
        while(true){
            // System.out.println("here");
            int vert1 = getRandomInteger(graph.getNumVert(), 0);
            if (graph.neighbours(vert1).size() < maxDegree)
                return vert1;
        }
    }

    ///////helper methods///////
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}
