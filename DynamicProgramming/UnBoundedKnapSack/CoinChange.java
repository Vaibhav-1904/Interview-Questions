package ImportantQ.DynamicProgramming.UnBoundedKnapSack;
// https://leetcode.com/problems/coin-change/
// Find minimum number of coins needed to complete the amount should be completely completed.
public class CoinChange {

//    // Recursive Approach
//    public int coinChange(int[] coins, int amount) {
//        if(amount == 0)
//            return 0;
//        int ans = minCoins(coins, coins.length, amount);
//
//        if(ans < 0 || ans  > 9000)
//            ans = -1;
//        return ans;
//    }
//
//    public int minCoins(int[] coins, int n, int amount) {
//        if(amount == 0)
//            return 0;
//
//        if(n == 0)
//            return 10000;
//
//        if(coins[n - 1] <= amount)
//            return Math.min(1 + minCoins(coins, n, amount - coins[n - 1]), minCoins(coins, n - 1, amount));
//        else
//            return minCoins(coins, n-1, amount);
//    }

//    //Memoization
//    public int coinChange(int[] coins, int amount) {
//        if(amount == 0)
//            return 0;
//        int[][] dp = new int[coins.length + 1][amount + 1];
//        for(int i = 0; i <= coins.length; i++){
//            for(int j = 0; j <= amount; j++)
//                dp[i][j] = -1;
//        }
//        int ans = minCoins(coins, coins.length, amount, dp);
//
//        if(ans < 0 || ans > 9000)
//            ans = -1;
//        return ans;
//    }
//
//    public int minCoins(int[] coins, int n, int amount, int[][] dp){
//        if(amount == 0)
//            return 0;
//
//        if(n == 0)
//            return 10000;
//
//        if(dp[n][amount] != -1)
//            return dp[n][amount];
//
//        if(coins[n - 1] <= amount)
//            return dp[n][amount] = Math.min(1 + minCoins(coins, n, amount - coins[n - 1], dp), minCoins(coins, n - 1, amount, dp));
//        else
//            return dp[n][amount] = minCoins(coins, n-1, amount, dp);
//    }

    // Optimal
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins){
                if(coin <= i && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}
