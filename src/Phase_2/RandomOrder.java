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

//        ArrayList<Vertex> sequence =  RandomVertexSequence(g);
//
//        for (int i = 0; i < sequence.size(); i++) {
//            System.out.println(sequence.get(i).getVertexNum());
//        }
    }


    public static ArrayList<Vertex> RandomVertexSequence(ArrayList<Vertex> vertexArrayList ){
        ArrayList<Vertex> arr_copy = new ArrayList<>(vertexArrayList);
        ArrayList<Vertex> randomSequence = new ArrayList<Vertex>();

        while(randomSequence.size() != vertexArrayList.size()){
            //System.out.println("here");
            Vertex toCheck = arr_copy.get(getRandomInteger(arr_copy.size(),0));
            if(!randomSequence.contains(toCheck)) {
                randomSequence.add(toCheck);
            }
            arr_copy.remove(toCheck);
        }
        return randomSequence;
    }

    //////////////////helper methods/////////////////////

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

}
