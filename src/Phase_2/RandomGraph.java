package Phase_2;

import java.util.Random;
public class RandomGraph {

    public static void generateRandom(int vertices, int edges){
        int graph[][] = new int [vertices][vertices];
        int edgeCount=0;
        while(edgeCount<=edges)
        {
            Random rand = new Random();
            int ran1 = rand.nextInt(vertices  );
            int ran2=  rand.nextInt(vertices );

            if(graph[ran1][ran2]==0){
                graph[ran1][ran2] = 1;
            }
            else if(graph[ran1][ran2]==1){
                edgeCount--;
            }
            edgeCount++;
        }

        for (int i = 0; i<vertices; i++) {
            for (int j = 0; j<vertices; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }


    }
}
