
/*****01BFS*********/
// Pepcoder And Reversing
// important question baby
// You are given 2 integers N and M , N is the number of vertices, M is the number of edges. You'll also be given ai and bi where ai and bi represents an edge from a vertex ai to a vertex bi.

// You have to find the minimum number of edges you have to reverse in order to have atleast one path from vertex 1 to N, where the vertices are numbered from 1 to N.
// 7 7
// 1 2 
// 3 2
// 3 4
// 7 4
// 6 2
// 5 6
// 7 5

// Given a graph where every edge has weight as either 0 or 1. A source vertex is also given in the graph. Find the shortest path from source vertex to every other vertex. 

// SAME BFS HAI BUS LINKED LIST USE HOTI HAI QKI WEIGHT KE HISAB SE UNKO AGEY PICHE ADD KRNA HOTA HAI BUS ISKA INPUT THODA ALAG HAI TOH DEKHLENA


import java.io.*;
import java.util.*;

public class 01BFS {

      public static void main(String[] args) throws NumberFormatException, IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String st[] = br.readLine().split(" ");

            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            ArrayList<ArrayList<pair>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                  graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {

                  st = br.readLine().split(" ");

                  int u = Integer.parseInt(st[0]) - 1;
                  int v = Integer.parseInt(st[1]) - 1;

                  graph.get(u).add(new pair(v, 0));
                  graph.get(v).add(new pair(u, 1));

            }

            LinkedList<pair> q = new LinkedList<>();

            boolean[] visited = new boolean[n];

            q.addLast(new pair(0, 0));

            while (q.size() > 0) {

                  pair rem = q.removeFirst();

                  if (rem.vt == n - 1) {
                        System.out.println(rem.wt);
                        return;
                  }

                  visited[rem.vt] = true;

                  for (pair nbr : graph.get(rem.vt)) {
                        if (visited[nbr.vt] == true) {
                              continue;
                        }

                        if (nbr.wt == 0) {
                              q.addFirst(new pair(nbr.vt, rem.wt + 0));
                        }

                        else {
                              q.addLast(new pair(nbr.vt, rem.wt + 1));
                        }
                  }
            }

            System.out.println("-1");

      }

      static class pair {
            int vt;
            int wt;

            pair(int vt, int wt) {
                  this.vt = vt;
                  this.wt = wt;
            }
      }
}
