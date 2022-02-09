package ImportantQ.DynamicProgramming.Dp_MinMax;
// https://leetcode.com/problems/minimum-path-sum/
public class MinPathSum {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//
//        return backtrack(grid, 0, 0, m, n, dp);
//    }
//
//    int backtrack(int[][] grid, int x, int y, int m, int n, int[][] dp) {
//
//        if (x == m || y == n)
//            return 1000000;
//
//        if (x == m - 1 && y == n - 1)
//            return dp[x][y] = grid[x][y];
//
//        if (dp[x][y] != 0)
//            return dp[x][y];
//
//        return dp[x][y] = Math.min(grid[x][y] + backtrack(grid, x + 1, y, m, n, dp), grid[x][y] + backtrack(grid, x, y + 1, m, n, dp));
//    }

//    // DP Table -> Bottom Up
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//
//        for(int i = m - 1; i >= 0; i--){
//            for(int j = n- 1; j >= 0; j--){
//                if(i == m-1 && j == n-1){
//                    dp[i][j] = grid[i][j];
//                }else if(i == m-1){
//                    dp[i][j] = grid[i][j] + dp[i][j + 1];
//                }else if(j == n-1){
//                    dp[i][j] = grid[i][j] + dp[i + 1][j];
//                }else{
//                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
//                }
//            }
//        }
//        return dp[0][0];
//    }

    // Optimal
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for(int i = 0; i < n; i++) {
            int[] cur = new int[m];

            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0)
                    cur[j] = grid[i][j];
                else{
                    int up = grid[i][j];

                    if(i > 0)
                        up += prev[j];
                    else
                        up += (int)Math.pow(10,9);

                    int left = grid[i][j];

                    if(j > 0)
                        left += cur[j-1];
                    else
                        left += (int)Math.pow(10,9);

                    cur[j] = Math.min(up, left);
                }
            }
            prev = cur;
        }
        return prev[m - 1];
    }
}