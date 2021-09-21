// public class bfs {

// }

// BFS ->> BREADTH FIRST SEARCH 
/*YE RADIUS MAU GROW KRTI HAI LIKE GOVEN SOURCE SE PHLE UNKE RASTE NIKLENGAY JO USS SE 1 PATH KI DISTANCE PE HAIN THEN WE WILL CALCULATE DESTINATIONS WHICH ARE AT A DISTANCE OF 2 PATH LENGTH AND SO ON.*/

// QUEUE DS USE HOGA AND WE HAVE TO DO 4 OPERATIONS ONLY 1->REMOVE-> 2 MARK STAR 3->WORK(IN BFS WE HAVE TO PRINT PATH)->4 -> ADD UNVISITED NEIGHBOURS

import java.io.*;
import java.util.*;

public class Main {
      static class Edge {
            int src;
            int nbr;

            Edge(int src, int nbr) {
                  this.src = src;
                  this.nbr = nbr;
            }
      }

      // ********1.MAKE A PAIR CLASS FOR BFS********
      static class pair {
            int v;
            String psf;

            pair(int v, String psf) {
                  this.v = v;
                  this.psf = psf;
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
                  graph[v1].add(new Edge(v1, v2));
                  graph[v2].add(new Edge(v2, v1));
            }

            int src = Integer.parseInt(br.readLine());

            // ****** */ 2.DECLARE A QUEUE OF TYPE PAIR****

            ArrayDeque<pair> q = new ArrayDeque<>();
            // 3.ADD FIRST PAIR TO QUEUE WITH SOURCE AND PATH OF SOURCE(WHICH OFCOURSE IS
            // ONLY SOURCE)
            q.add(new pair(src, src + ""));
            // 4.MAKE A BOOLEAN ARRAY OF TO MARK FOR THE VISITED VERTICES
            boolean[] visited = new boolean[vtces];

            while (q.size() > 0) {
                  // remove ->> mark star->>work(in this case it printing)-->add(neighbpurs)

                  // 5.REMOVE THE FIRST PAIR
                  pair rem = q.removeFirst();

                  // 6.NOW MARK STAR (SO THAT IF IT IS ALREADY VISITED VERTEX THEN WE WILL NOT DO
                  // ANY WORK FOR THIS ..INSTEAD WE WILL CONTINUE FROM HERE)
                  if (visited[rem.v] == true) {
                        continue;
                  }
                  // 7.IF IT IS NOT A VISITED VERTEX MARK IT TRUE AND DO THE WORK->>
                  visited[rem.v] = true;
                  // 8.DO WORK (IN THIS CASE WE HAVE TO PRINT PATH FROM SRC TO OTHER VERTICES)
                  System.out.println(rem.v + "@" + rem.psf);
                  // 9.THEN IF THE NEIGHBOUR OF CURRENT VERTEX IS NOT VISITED THEN WE ADD THEM
                  // INTO QUEUE.
                  for (Edge e : graph[rem.v]) {
                        if (visited[e.nbr] == false) {
                              q.add(new pair(e.nbr, rem.psf + e.nbr));
                        }
                  }
            }
      }
}