package GUI;

import Graph_Implementation.Vertex;

public class colorVertexGui {

    public static void colorVertexGUI(Vertex vertex, int colorID, boolean randOrder){
        vertex.setColour(colorID);
        if(randOrder){
            vertex.setColorFixed(true);
        }
    }
}
