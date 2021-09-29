package ImportantQ.DynamicProgramming.ZeroOneKnapSack;
// KnapSack is Standard Parent Problem
public class ZeroOneKnapsack {

    // 0-1 KnapSack
    // Recursive Approach T -> O2^n)
//    public int knapSack(int[] weight, int[] values, int W, int n) {
//        if(W == 0 || n == 0)
//            return 0;
//
//        if(weight[n - 1] <= W){ // Include and Not Include
//            return Math.max(values[n - 1] + knapSack(weight, values, W - weight[n-1], n-1), knapSack(weight, values, W, n-1));
//        }
//        else
//            return knapSack(weight, values, W, n - 1);
//    }

//    // Memoization T -> O(n*W)  S -> O(n*W)
//    // In memoization we create matrix for those variables which change recursively
//    static int[][] dp = new int[101][1001];
//    static int knapSack(int W, int[] weight, int[] values, int n)
//    {
//        if(W == 0 || n == 0)
//            return 0;
//
//        int[][] dp = new int[n + 1][W + 1];
//        for(int i = 0; i <= n; i++){
//            for(int j  = 0; j <= W; j++)
//                dp[i][j] = -1;
//        }
//
//        return memoization(weight, values, W, n, dp);
//    }
//
//    static int memoization(int[] weight, int[] values, int W, int n, int[][] dp ) {
//
//        if(W == 0 || n == 0)
//            return 0;
//
//        if(dp[n][W] != -1)
//            return dp[n][W];
//
//        if(weight[n - 1] <= W) // Include and Not Include
//            return dp[n][W] = Math.max(values[n - 1] + memoization(weight, values, W - weight[n-1], n-1, dp), memoization(weight, values, W, n-1, dp));
//
//        else
//            return dp[n][W] = memoization(weight, values, W, n - 1, dp);
//
//    }

    // Top-Down Approach
    public static int knapSack(int[] weight, int[] values, int W, int n) {
        if(W == 0 || n == 0)
            return 0;

        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= W; w++){

                if(i == 0 || w == 0)
                    dp[i][w] = 0;
                else if(weight[i - 1] <= w){ // You have 2 options, either to include or not include
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                    // we need to subtract weight[i-1] coz already include weight + current weight[i-1] might cross w ( w < )
                }else
                    dp[i][w] = dp[i - 1][w];

            }
        }

        return dp[n][W];
    }

}
