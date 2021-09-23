// public class rottingoranges {

// }
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class rottingoranges {

      public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                  st = br.readLine().split(" ");
                  for (int j = 0; j < m; j++) {
                        arr[i][j] = Integer.parseInt(st[j]);
                  }
            }

            System.out.println(orangesRotting(arr));

      }

      public static class pair {
            int row;
            int col;

            pair(int row, int col) {
                  this.row = row;
                  this.col = col;
            }

      }

      public static int orangesRotting(int[][] grid) {
            /* declare a queue first just like bfs */
            LinkedList<pair> q = new LinkedList<>();
            int fresh = 0;
            /*
             * iterate through the given array and add all the rotten oranges to the queue
             * and also calculate the count of fresh oranges.
             */
            for (int i = 0; i < grid.length; i++) {
                  for (int j = 0; j < grid[0].length; j++) {

                        if (grid[i][j] == 2) {
                              q.add(new pair(i, j));
                        } else if (grid[i][j] == 1) {
                              fresh++;
                        }
                  }
            }
            /*
             * now if after iteraing the array , count of fresh oranges is zero then return
             * 0 from here because if there is no fresh oranges , rotten one cant do
             * anything and time remains 0
             */
            if (fresh == 0) {
                  return 0;
            }
            int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
            int level = -1;

            /*
             * now from here applying bfs using two while loops outer loop is maintaning
             * levels beacuse eventually the count of level is your answer now suppose at
             * first only 2 rotten oranges are there in the grid then the inner loop will
             * run only two times and add their neighbours(i.e if fresh oranges present)
             * using the dirs 2d array.after that we check in if condition that if the
             * neighbours we are adding are valid or not . If neighbours are valid then we
             * add them at last of queue and mark 0 at there places so that they are not
             * counted again and do fresh--. now if after finishing this while loop the
             * count of fresh oranges is zero then we will simply return level and if it is
             * not then return -1(that means there is a oranges we are able to reach ).
             */

            while (q.size() > 0) {
                  int size = q.size();
                  level++;
                  while (size-- > 0) {

                        pair rem = q.removeFirst();

                        for (int i = 0; i < dirs.length; i++) {
                              int rdash = rem.row + dirs[i][0];
                              int cdash = rem.col + dirs[i][1];

                              if (rdash >= 0 && cdash >= 0 && rdash < grid.length && cdash < grid[0].length
                                          && grid[rdash][cdash] == 1) {
                                    q.addLast(new pair(rdash, cdash));
                                    grid[rdash][cdash] = 0;
                                    fresh--;
                              }
                        }

                  }
            }

            if (fresh == 0) {
                  return level;
            }

            else {
                  return -1;
            }

      }
}