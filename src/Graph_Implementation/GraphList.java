package Graph_Implementation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphList {
    private int NumVert;
    private List<Integer>[] adj;

    private int maxColour;

    public GraphList(int NumVert) {
        this.maxColour = 0;
        this.NumVert = NumVert;
        adj = (List<Integer>[]) new List[NumVert];
        for (int i = 0; i < NumVert; i++)
            adj[i] = new ArrayList<Integer>();
    }

    public int getMaxColour(){
        return maxColour;
    }
    public void setMaxColour(int color){
        this.maxColour = color;
    }

    public int getNumVert(){
        return NumVert;
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
        adj[j].add(i);
    }

    public void removeEdge(int i, int j) {
        Iterator<Integer> it = adj[i].iterator();
        while (it.hasNext()) {
            if (it.next() == j) {
                it.remove();
                break;
            }
        }
        Iterator<Integer> it2 = adj[j].iterator();
        while (it2.hasNext()) {
            if (it2.next() == i) {
                it2.remove();
                return;
            }
        }
    }
    public boolean hasEdge(int i, int j) {
        return adj[i].contains(j);
    }

    public List<Integer> neighbours(int vertex) {
        return adj[vertex];
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
    public List<Integer>[] getAdj(){
        return adj;
    }
}