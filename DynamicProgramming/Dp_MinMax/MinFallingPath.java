package ImportantQ.DynamicProgramming.Dp_MinMax;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinFallingPath {
//    // Recursion Memoization
//    public int minFallingPathSum(int[][] matrix) {
//        int n = matrix.length;
//        int[][] dp = new int[n][n];
//
//        for(int[] arr : dp)
//            Arrays.fill(arr, -1);
//
//        int min = Integer.MAX_VALUE;
//        int lastRow = n-1;
//
//        for(int i = 0; i < n; i++){
//            int cur = solve(matrix, lastRow, i, n, dp);
//            min = Math.min(min, cur);
//        }
//        return min;
//    }
//
//    int solve(int[][] matrix, int row, int col, int n, int[][] dp) {
//        if(col < 0 || col >= n)
//            return 1000000;
//
//        if(row == 0)
//            return matrix[0][col];
//
//        if(dp[row][col] != -1)
//            return dp[row][col];
//
//        int straight = matrix[row][col] + solve(matrix, row - 1, col, n, dp);
//
//        int left = matrix[row][col] + solve(matrix, row - 1, col - 1, n, dp);
//
//        int right = matrix[row][col] + solve(matrix, row - 1, col + 1, n, dp);
//
//        return dp[row][col] = Math.min(straight, Math.min(left, right));
//    }

    // Tabulation Optimal
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];

        int min = Integer.MAX_VALUE;
        int lastRow = n-1;
        int[] prev = new int[n];

        for(int i = 0; i < n; i++) {
            int[] cur = new int[n];
            for(int j = 0; j < n; j++) {
                if(j == 0)
                    cur[j] = matrix[i][j] + Math.min(prev[j], prev[j + 1]);
                else if(j == lastRow)
                    cur[j] = matrix[i][j] + Math.min(prev[j], prev[j - 1]);
                else
                    cur[j] = matrix[i][j] + Math.min(prev[j], Math.min(prev[j - 1], prev[j + 1]));

                if(i == lastRow)
                    min = Math.min(min, cur[j]);
            }
            prev = cur;
        }
        return min;
    }
}
