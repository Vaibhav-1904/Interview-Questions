package ImportantQ.DynamicProgramming.DistinctWays;
// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
//    // Recursive
//    public int climbStairs(int n) {
//
//        if(n <= 2)
//            return n;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//
//    }

    // Memoization
    public int climbStairs(int n, int[] dp) {
        if(n <= 2)
            return n;

        if(dp[n] != -1)
            return dp[n];
        else
            return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }

//    // Tabular
//    public int climbStairs(int n) {
//        if(n == 1)
//            return 1;
//        int[] dp = new int[n];
//
//        dp[0] = 1;
//        dp[1] = 2;
//
//        for(int i = 2; i < n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        return dp[n - 1];
//    }

    // Optimal
    public int climbStairs(int n) {
        if(n == 1)
            return 1;

        int first = 1;
        int second = 2;
        int result = 2;
        for(int i = 2; i < n; i++) {
            second = result;
            result = second + first;
            first = second;
        }

        return result;
    }

}
