// Q1.Bellman Ford->> level 2 graph

// You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai, bi and wi where ai and bi represents an edge from a vertex ai to a vertex bi and wi respresents the weight of that edge.
// Your task is to find the shortest path from source vertex (vertex number 1) to all other vertices.

/*******Given a graph and a source vertex src in graph, find shortest paths from src to all vertices in the given graph. The graph may contain negative weight edges. Dijkstra doesn’t work for Graphs with negative weight cycle, Bellman-Ford works for such graphs. Bellman-Ford is also simpler than Dijkstra and suites well for distributed systems. ******/

/*ye tab kaam ati hai jab  negative weight vale edges bhi present ho but dijkistra tb kaam ni krta this will work*/

//we are ASSUMING THERE IS NO NEGATIVE WIEGHT CYCLE IF THERE IS THEN IT IS IMPOSSIBLE TO CALCULATE SHORTEST PATH AS WE CAN TRAVEL THE CYCLE INFINITE TIMES AND EACH TIME WE WILL GET LESS PATH LENGTH from the last one

// ALGO STEPS->>
/*1.dp ki trh answer array declare krdo phle  then fill it with max value(infinity distance*/
/*2. ASSUME KI SOURCE 0 HAI ANSWER[0]= 0 DALDO BCZ THERE IS NO NEGATIVE CYCLE SO THE DISTANCE FROM SRC TO SRC WILL BE ZERO*/
/*3. for(i=0->vertices-1){V-1 isle because negative cycle exist ni kr skti and for N vertices only N-1 edges can be thier same like   tree} 
       {for(j=0->m)
            {
                  inme u, v ,wt nikal array kr se
                  5 5
                  1 2 5
                  1 3 2
                  3 4 1
                  1 4 6
                  3 5 5
                  then calculte-->>
                  1.agr infinite store hai answer[u] pe then continue otherwise
                  2.check the below condition and update.
                  if (path[u] + wt < path[v]) {
                              path[v] = path[u] + wt;
                        }
            }
4.ab last mai asnwer array mai traverse kr and dekh ki jisme infinite ni pda hai usko print kra de
               */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class bellmanford {
      public static void main(String[] args) throws NumberFormatException, IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] st = br.readLine().split(" ");

            int n = Integer.parseInt(st[0]);/* n verices hai */
            int m = Integer.parseInt(st[1]);/* m edges hai */

            int[][] arr = new int[m][3];

            for (int i = 0; i < m; i++) {
                  st = br.readLine().split(" ");
                  arr[i][0] = Integer.parseInt(st[0]) - 1;
                  arr[i][1] = Integer.parseInt(st[1]) - 1;
                  arr[i][2] = Integer.parseInt(st[2]);
            }
            // TAKING INPUT LIKE THESE THATS WHY ARRAY.
            // 5 5
            // 1 2 5
            // 1 3 2
            // 3 4 1
            // 1 4 6
            // 3 5 5

            int[] path = new int[n];

            Arrays.fill(path, Integer.MAX_VALUE);

            path[0] = 0;

            for (int i = 0; i < n - 1; i++) {
                  for (int j = 0; j < m; j++) {
                        int u = arr[j][0];
                        int v = arr[j][1];
                        int wt = arr[j][2];

                        if (path[u] == Integer.MAX_VALUE) {
                              continue;
                        }

                        if (path[u] + wt < path[v]) {
                              path[v] = path[u] + wt;
                        }
                  }
            }

            for (int i = 1; i < n; i++) {
                  if (path[i] != Integer.MAX_VALUE) {
                        System.out.print(path[i] + " ");
                  } else {
                        System.out.println(1000000000);
                  }
            }
            System.out.println();
      }

}
