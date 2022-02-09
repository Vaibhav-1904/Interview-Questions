package ImportantQ.DynamicProgramming.Dp_MinMax;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostStairs {
//    // Recursion Memoization Bottom-Up T->O(n)
//    public int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//
//        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
//    }
//
//    int solve(int[] cost, int index, int[] dp) {
//
//        if(index >= cost.length)
//            return 0;
//
//        if(dp[index] != -1)
//            return dp[index];
//
//        int one = solve(cost, index + 1, dp);
//        int two = solve(cost, index + 2, dp);
//
//        return dp[index] = cost[index] + Math.min(one, two);
//    }

//    // Tabulation
//    public int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int[] dp = new int[n];
//
//        dp[n - 1] = cost[n - 1];
//        dp[n - 2] = cost[n - 2];
//
//        for(int i = n - 3; i >= 0; i--) {
//            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
//        }
//
//        return Math.min(dp[0], dp[1]);
//    }

    // Optimal
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int one = cost[n - 1];
        int two = cost[n - 2];


        for(int i = n - 3; i >= 0; i--) {
            int result = cost[i] + Math.min(one, two);

            one = two;
            two = result;
        }

        return Math.min(one , two);
    }
}
