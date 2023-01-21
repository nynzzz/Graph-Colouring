package Graph_Implementation;

import java.util.List;
import java.util.ArrayList;

public class GraphMatrix {
    private int NumVert;
    private boolean[][] adj;
    private int NumEdg;
    private List<Vertex> vertexGraph;

    private int maxColour;

    public GraphMatrix(int NumVert) {
        this.maxColour = -1;
        this.NumVert = NumVert;
        adj = new boolean[NumVert][NumVert];
        vertexGraph = new ArrayList<Vertex>();
    }
    public int getNumEdg(){
        return this.NumEdg;
    }
    public void setNumEdg(int numEdg){
        this.NumEdg = numEdg;
    }

    public int getMaxColour(){
        return maxColour;
    }
    public void setMaxColour(int color){
        this.maxColour = color;
    }

    public boolean[][] getAdj(){
        return adj;
    }
    public void addEdge(int i, int j) {
//        System.out.println("yep");
        adj[i][j] = adj[j][i] = true;
    }

    public void removeEdge(int i, int j) {
        adj[i][j] = adj[j][i] = false;
    }

    public boolean hasEdge(int i, int j) {
        return adj[i][j];
    }

    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int i = 0; i < NumVert; i++)
            if (adj[vertex][i])
                edges.add(i);
        return edges;
    }

    public void printGraph() {
        for (int i = 0; i < NumVert; i++) {
            List<Integer> edges = neighbours(i);
            System.out.print(i + ": ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j) + " ");
            }
            System.out.println();
        }
    }
    public int getNumVert(){
        return NumVert;
    }

    //create a vertex graph
    public void createVertexGraph(){
        for (int i = 0; i < this.getNumVert(); i++) {
            Vertex vertexi = new Vertex(this, i);
            this.vertexGraph.add(vertexi);
        }
    }

    public List<Vertex> getVertexGraph(){
        return this.vertexGraph;
    }

}