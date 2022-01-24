package ImportantQ.DynamicProgramming.DistinctWays;
// https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/

// Given an integer N and a 2D array cost[][3], where cost[i][0], cost[i][1], and cost[i][2] is the
// cost of painting ith house with colors red, blue, and green respectively, the task is to find the
// minimum cost to paint all the houses such that no two adjacent houses have the same color.
public class MinCostHousePainting {
    public int minCost(int[][] cost, int n) {
        if(n == 0)
            return 0;

        int[][] dp = new int[n][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);

            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);

            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
