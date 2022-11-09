package Phase_2;

import Graph_Implementation.GraphMatrix;
import Graph_Implementation.Vertex;

import java.util.ArrayList;
import java.util.List;

public class RandomOrder {

    public static void main(String[] args){
        GraphMatrix g = new GraphMatrix(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        ArrayList<Vertex> sequence =  RandomVertexSequence(g);

        for (int i = 0; i < sequence.size(); i++) {
            System.out.println(sequence.get(i).getVertexNum());
        }
    }


    public static ArrayList<Vertex> RandomVertexSequence(GraphMatrix graph){
//        boolean[] alreadyVisited = new boolean[graph.getNumVert()];
        graph.createVertexGraph();
        ArrayList<Vertex> vertexArrayList = (ArrayList<Vertex>) graph.getVertexGraph();
        ArrayList<Vertex> randomSequence = new ArrayList<>();

        while(vertexArrayList.size() != randomSequence.size()){

            int IDofVertexToAdd = getRandomInteger(vertexArrayList.size(), 0);
            randomSequence.add(vertexArrayList.get(IDofVertexToAdd));
            vertexArrayList.remove(IDofVertexToAdd);
        }
        return randomSequence;
    }

    //////////////////helper methods/////////////////////

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
