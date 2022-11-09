package Phase_2;

import Algorithms.Backtrack;
import Graph_Implementation.GraphMatrix;

public class TheBitterEnd {

    public static boolean compareAmountColours(GraphMatrix graph){
        int maxColour = graph.getMaxColour();
        int backtrackResult = Backtrack.backTrack(graph);

        if(maxColour == backtrackResult){
            return true;
        }
        System.out.println("You used wrong number of colours");
        return false;
    }
}
