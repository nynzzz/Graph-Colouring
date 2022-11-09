package Graph_Implementation;

public class Vertex {

    private GraphMatrix graph;

    private int vertexNum;

    private boolean colorFixed;

    private int colour;

    public Vertex(GraphMatrix graph, int vertexNum){
        this.graph = graph;
        this.vertexNum = vertexNum;
        this.colorFixed = false;
        this.colour = -1;
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public boolean getColorFixed() {
        return colorFixed;
    }

    public void setColorFixed(boolean colorFixed) {
        this.colorFixed = colorFixed;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        if(this.colorFixed == true){
            System.out.println("color is fixed, you cant change it");
        }
        else{
            this.colour = colour;
        }
        if(colour > this.graph.getMaxColour()){
            this.graph.setMaxColour(colour);
        }
    }


}
