// Given an array of n distinct elements, find the minimum number of swaps required to sort the array.
// Sample Input
// 5
// 10 19 6 3 5
// Sample Output
// 2

/* SIMPLE APPROACH HAI JO ARRAY GIVEN HAI USKO USKO PAIR CLASS KI HELP SE USKE INDEX KE SATH STORE KRVALO PHLE EG.arr[i],i 
   FIR USKO SORT KRDO INDEX NUMBER K SATH HI RHENGAY VO BUS NUMBER K BASIS PE SORT HOJAEGA .. OK
   
   EK VISITED KA BOOLEAN ARRAY LELO

   AB LOOP CHLA AND CURRENT ELEMENT KA IDX CHECK KR AGR VO LOOP K i EQUAL THAT MEANS VO APNI SHI JGH PE HAI 
   NHI TOH SIMPLY TERKO CYCLE DETECT KRNI HAI I.E. KAUNSE ELEMENTS HAI JO AAPS MAI CYCLE BNARE HAI 
   SO , SUPPOSE N CYCLES HAI TOH N-1 SWAPS KRENGAY.AND COUNT RETURN KRDENGAY

*/

import java.io.*;
import java.util.*;

public class MinSwapsreqtoSortarray {
      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            String[] st = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                  arr[i] = Integer.parseInt(st[i]);
            }

            System.out.println(minSwaps(arr));
      }

      public static int minSwaps(int[] arr1) {

            int n = arr1.length;

            pair[] arr = new pair[n];

            for (int i = 0; i < arr1.length; i++) {
                  arr[i] = new pair(arr1[i], i);
            }
            Arrays.sort(arr);

            boolean[] visited = new boolean[arr.length];
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                  /*
                   * TOH VISITED MAI HR JGH FALSE PDA HAI AGR TRUE HOGA TOH THAT MEANS VO KISI
                   * CYCLE KA PART THA AND DUSRI CONDITON YE CHECK KRRI KI VO SHI INDEX PE TOH NI
                   * HAI IF IT IS TOH SIDHE CONTINUE KR JAO
                   */
                  if (visited[i] == true || arr[i].idx == i) {
                        continue;
                  }
                  /*
                   * J POINTER I PE RKD DE AUR I VALE ELEMENT K SATH JO IDX JUDA VHA PE J KO JUMP
                   * KRATE RH JAISE HI J KHI PE TRUE MILTA HAI THAT MEANS CYCLE PURI TOH EXIT KR
                   * JA CYCLE SE
                   */
                  int cyclen = 0;
                  int j = i;
                  while (visited[j] == false) {
                        visited[j] = true;
                        cyclen++;
                        j = arr[j].idx;
                  }
                  /* cycle n ki hai toh n-1 SWAPS */
                  ans += (cyclen - 1);
            }
            return ans;
      }

      private static class pair implements Comparable<pair> {
            int val;
            int idx;

            pair(int val, int idx) {
                  this.val = val;
                  this.idx = idx;
            }

            @Override
            public int compareTo(pair o) {
                  return this.val - o.val;
            }
      }
}
