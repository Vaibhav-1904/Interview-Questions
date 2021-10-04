package ImportantQ.DynamicProgramming.UnBoundedKnapSack;
// https://leetcode.com/problems/coin-change-2/
// given a list of coins and an amount, we need to find different number of ways in which we can make the
// amount using given coins
public class CoinChange2 {
//    // Recursive Approach T -> O(2^n)
//    int coinChange(int[] coins, int amount, int n){
//        if(amount == 0)
//            return 1;
//        if(n == 0 || amount < 0)
//            return 0;
//
//        if(coins[n - 1] <= amount)
//            return coinChange(coins, amount - coins[n - 1], n) + coinChange(coins, amount, n - 1);
//        else
//            return coinChange(coins, amount, n - 1);
//    }

//    // Memoization
//    public int change(int amount, int[] coins) {
//        int[][] dp = new int[coins.length + 1][amount + 1];
//        for(int i = 0; i <= coins.length; i++)
//        {
//            for(int j = 0; j <= amount; j++)
//                dp[i][j] = -1;
//        }
//
//        return coinChange(coins, amount, coins.length, dp);
//    }
//
//    int coinChange(int[] coins, int amount, int n, int[][] dp){
//        if(amount == 0)
//            return dp[n][amount] = 1;
//        if(n == 0 || amount < 0)
//            return dp[n][amount] = 0;
//        if(dp[n][amount] != -1)
//            return dp[n][amount];
//
//        if(coins[n - 1] <= amount)
//            return dp[n][amount] = coinChange(coins, amount - coins[n - 1], n, dp) + coinChange(coins, amount, n - 1, dp);
//        else
//            return dp[n][amount] = coinChange(coins, amount, n - 1, dp);
//    }

    // TopDown
//    public int change(int amount, int[] coins) {
//        int n = coins.length;
//        int[][] dp = new int[n + 1][amount + 1];
//        for(int i = 0; i <= n; i++)
//            dp[i][0] = 1;
//        for(int i = 1; i <= amount; i++)
//            dp[0][i] = 0;
//
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= amount; j++){
//                if(coins[i - 1] <= j)
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[n][amount];
//    }

    // Optimal
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = 0; j <= amount; j++) {
                if (coin <= j)
                    dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }

}
