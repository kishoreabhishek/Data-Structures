package org.example;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int r = s.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}});
        System.out.println(r);
;    }


}
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        HashMap<String,Integer> memo = new HashMap<>();
        int fminsum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            int ttsum = calculateminFallingPathSum(matrix, 0, i,memo);
            if (ttsum < fminsum) fminsum = ttsum;
        }
        return fminsum;
    }

    private int calculateminFallingPathSum(int[][] matrix, int ridx, int cidx,HashMap<String,Integer> memo) {
        if(memo.containsKey(ridx + "," + cidx)) {
            return memo.get(ridx + "," + cidx);
        }
        if (ridx == matrix.length-1) return matrix[ridx][cidx];
        int minsum = Integer.MAX_VALUE;
        for (int j = -1; j <= 1; j++) {
            if(cidx+j>=0 && cidx+j<matrix[0].length ) {
                int tsum = calculateminFallingPathSum(matrix, ridx + 1, cidx + j,memo);
                if (tsum < minsum) minsum = tsum;
            }

        }
        memo.put(ridx + "," + cidx,minsum + matrix[ridx][cidx]);
        return minsum + matrix[ridx][cidx];

    }
}