// public class detectnegativevecycle {

// }
// You are given 2 integers N and M , N is the number of vertices, M is the
// number of edges. You'll also be given ai, bi and wi where ai and bi
// represents an edge from a vertex ai to a vertex bi and wi respresents the
// weight of that edge.

// Task is to find if it contains a negative weight cycle or not.

// Negative Weight Cycle Detection

// ******SAME LOGIC/CODE hai BELLMAN FORD VALA BUS LAST MAI EK AUR AUR BAR LOOP CHLA DO AGR USS LOOP MAI KI UPDATE HUI THAT MEANS KI NEGATIVE CYCLE hai/////

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class detectnegativevecycle {
      public static void main(String[] args) throws NumberFormatException, IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] st = br.readLine().split(" ");

            int n = Integer.parseInt(st[0]);/* n verices hai */
            int m = Integer.parseInt(st[1]);/* m edges hai */

            int[][] arr = new int[m][3];

            for (int i = 0; i < m; i++) {
                  st = br.readLine().split(" ");
                  arr[i][0] = Integer.parseInt(st[0]);
                  arr[i][1] = Integer.parseInt(st[1]);
                  arr[i][2] = Integer.parseInt(st[2]);
            }
            // TAKING INPUT LIKE THESE THATS WHY ARRAY.
            // 5 5
            // 1 2 5
            // 1 3 2
            // 3 4 1
            // 1 4 6
            // 3 5 5
            System.out.print(negativewtcycledetect(n, arr));
      }

      public static int negativewtcycledetect(int n, int[][] arr) {

            int[] path = new int[n];

            Arrays.fill(path, Integer.MAX_VALUE);

            path[0] = 0;

            for (int i = 0; i < n - 1; i++) {
                  for (int j = 0; j < arr.length; j++) {
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
            for (int j = 0; j < arr.length - 1; j++) {
                  int u = arr[j][0];
                  int v = arr[j][1];
                  int wt = arr[j][2];

                  if (path[u] == Integer.MAX_VALUE) {
                        continue;
                  }

                  if (path[u] + wt < path[v]) {
                        return 1;
                  }

            }
            return 0;
      }

}