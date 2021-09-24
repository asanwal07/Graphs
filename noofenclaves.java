// LEETCODE QUES NO 1020

// You are given an m x n binary matrix grid, where 0 represents a sea cell and
// 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent
// (4-directionally) land cell or walking off the boundary of the grid.

// Return the number of land cells in grid for which we cannot walk off the
// boundary of the grid in any number of moves.

// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is
// not enclosed because its on the boundary.

/***** simply question ye hai ki kitne one aise hai jinpe chl k hum boundary pe ni phochungay sirf grid pe hi rhengay ..TOH SIMPLE LOGIH HAI GET CONNECTED COMPMONENTS NIKAL LE SIRF BOUNDARY VALE 1 K LIE AND UNKO 0 MARK KRDE TOH JOH AT LAST ONE COUNT BCHA HOGA USKA VO ANSWER HOGA       ******/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

class noofenclaves {

      public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] st = br.readLine().split(" ");
            int m = Integer.parseInt(st[0]);
            int n = Integer.parseInt(st[1]);

            int[][] arr = new int[m][n];

            for (int i = 0; i < m; i++) {
                  st = br.readLine().split(" ");
                  for (int j = 0; j < n; j++) {
                        arr[i][j] = Integer.parseInt(st[j]);
                  }
            }

            System.out.println(numEnclaves(arr));

      }

      public static int numEnclaves(int[][] arr) {

            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        if (i == 0 || j == 0 || i == arr.length - 1 || j == arr[i].length - 1) {
                              if (arr[i][j] == 1) {
                                    dfs(arr, i, j);
                              }
                        }
                  }
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[i].length; j++) {
                        if (arr[i][j] == 1) {
                              count++;
                        }
                  }
            }
            return count;
      }

      public static void dfs(int a[][], int i, int j) {
            if (i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
                  a[i][j] = 0;
                  dfs(a, i + 1, j);
                  dfs(a, i - 1, j);
                  dfs(a, i, j + 1);
                  dfs(a, i, j - 1);
            }
      }

}