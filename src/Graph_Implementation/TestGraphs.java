package Graph_Implementation;

public class TestGraphs {

    public static void main(String[] args) {
        GraphMatrix g1 = new GraphMatrix(5);

        System.out.println("Adjacency Matrix:");

        // add Edges
        g1.addEdge(0, 1);
        g1.addEdge(1, 3);
        g1.addEdge(1, 4);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);

        // print Graph
        g1.printGraph();

        GraphList g2 = new GraphList(5);

        System.out.println("Adjacency List:");

        // add Edges
        g2.addEdge(0, 1);
        g2.addEdge(1, 3);
        g2.addEdge(1, 4);
        g2.addEdge(2, 3);
        g2.addEdge(3, 4);

        // print Graph
        g2.printGraph();

    }
}