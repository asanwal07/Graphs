/*IT APPEARS TO BE A COPY OF DIKJSTRA ALGO ,EVEN THE CODE IS SAME BUT INSTEAD OF WTSOFAR AND PATHSOFAR WE HAVE ACQURING VERTEX  AND WT ONLY AND WE PASS THE ACQURING VERTEX THE WEIGHT OF CURRENT EDGE IN THE LOOP.*/

/* MINIMUM SPANNIG TREE IS A ->>
1.SUBGRAPH(INCLUDING SOME EDGES AND VERTICES)
2.TREE TYPE( I.E. CONNECTED HOTA HAI I.E HER NODE SE DUSRA NODE REACEBLE HOTA H AND ACYCLIC HOTA HAI )
3.SPANNING( AND IS GRAPH MAI SARI VERTICES INCLUDED HOTI HAI )
*/

// APPLICATION IN QUES ->> MIMIMUM WIRE REQUIRED TO CONNECT ALL THE EDGES

import java.io.*;
import java.util.*;

public class primsAlgo {
      static class Edge {
            int src;
            int nbr;
            int wt;

            Edge(int src, int nbr, int wt) {
                  this.src = src;
                  this.nbr = nbr;
                  this.wt = wt;
            }
      }

      static class pair implements Comparable<pair> {

            int v;
            int av;
            int wt;

            pair(int v, int av, int wt) {
                  this.v = v;
                  this.av = av;
                  this.wt = wt;
            }

            public int compareTo(pair o) {
                  return this.wt - o.wt;
            }
      }

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int vtces = Integer.parseInt(br.readLine());
            ArrayList<Edge>[] graph = new ArrayList[vtces];
            for (int i = 0; i < vtces; i++) {
                  graph[i] = new ArrayList<>();
            }

            int edges = Integer.parseInt(br.readLine());
            for (int i = 0; i < edges; i++) {
                  String[] parts = br.readLine().split(" ");
                  int v1 = Integer.parseInt(parts[0]);
                  int v2 = Integer.parseInt(parts[1]);
                  int wt = Integer.parseInt(parts[2]);
                  graph[v1].add(new Edge(v1, v2, wt));
                  graph[v2].add(new Edge(v2, v1, wt));
            }

            PriorityQueue<pair> pq = new PriorityQueue<>();

            pq.add(new pair(0, -1, 0));

            boolean[] visited = new boolean[vtces];

            while (pq.size() > 0) {

                  pair rem = pq.remove();

                  if (visited[rem.v] == true) {
                        continue;
                  }
                  visited[rem.v] = true;
                  if (rem.av != -1) {
                        System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
                  }

                  for (Edge e : graph[rem.v]) {
                        if (visited[e.nbr] == false) {
                              pq.add(new pair(e.nbr, rem.v, e.wt));
                        }
                  }
            }

      }

}