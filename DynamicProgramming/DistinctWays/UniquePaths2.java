package ImportantQ.DynamicProgramming.DistinctWays;
// https://leetcode.com/problems/unique-paths-ii/
public class UniquePaths2 {
    // Recursion Memoization DP
    public int uniquePathsWithObstacles1(int[][] o) {
        int m  = o.length;
        int n = o[0].length;

        int[][] dp = new int[m][n];

        return findPath(o, 0, 0, m, n, dp);
    }

    int findPath(int[][] o, int i, int j, int m, int n, int[][] dp) {
        if(i == m || j == n || o[i][j] == 1)
            return 0;
        if(i == m - 1 && j == n - 1)
            return 1;

        if(dp[i][j] != 0)
            return dp[i][j];


        return dp[i][j] = findPath(o, i + 1, j, m, n, dp) + findPath(o, i, j + 1, m, n, dp);
    }

    // Tabulation
//    public int uniquePathsWithObstacles2(int[][] grid) {
//
//        if(grid[0][0] == 1)
//            return 0;
//
//        int m  = grid.length;
//        int n = grid[0].length;
//
//        int[][] dp = new int[m][n];
//
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                if(grid[i][j] == 1)
//                    dp[i][j] = 0;
//                else if(i == 0 && j == 0)
//                    dp[i][j] = 1;
//                else{
//                    int up = 0;
//                    int left = 0;
//
//                    if(i > 0)
//                        up = dp[i - 1][j];
//                    if(j > 0)
//                        left = dp[i][j - 1];
//
//                    dp[i][j] = up + left;
//                }
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    // Optimal
    public int uniquePathsWithObstacles(int[][] grid) {

        if(grid[0][0] == 1)
            return 0;

        int m  = grid.length;
        int n = grid[0].length;

        int[] prev = new int[n];

        for(int i = 0; i < m; i++) {
            int[] cur = new int[n];
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1)
                    cur[j] = 0;
                else if(i == 0 && j == 0)
                    cur[j] = 1;
                else{
                    int up = 0;
                    int left = 0;

                    if(i > 0)
                        up = prev[j];
                    if(j > 0)
                        left = cur[j - 1];

                    cur[j] = up + left;
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }
}
