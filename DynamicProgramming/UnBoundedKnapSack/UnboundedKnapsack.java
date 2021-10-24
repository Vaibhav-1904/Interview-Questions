package ImportantQ.DynamicProgramming.UnBoundedKnapSack;
// https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
// Given a knapsack weight W and a set of n items with certain value val(i) and weight wti, we need
// to calculate the maximum amount that could make up this quantity exactly. This is different
// from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.

public class UnboundedKnapsack {
    // recursive Approach
//    static int knapSack(int n, int W, int val[], int wt[])
//    {
//        if(W <= 0 || n == 0)
//            return 0;
//
//        if(wt[n - 1] <= W){
//            return Math.max(val[n - 1] + knapSack(n, W - wt[n - 1], val, wt), knapSack(n - 1, W, val, wt));
//        }else{
//            return knapSack(n-1, W, val, wt);
//        }
//    }

    static int unBoundedKnapSack(int n, int W, int[] values, int[] weight)
    {
        if(W == 0 || n == 0)
            return 0;

        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= W; w++){

                if(i == 0 || w == 0)
                    dp[i][w] = 0;
                else if(weight[i - 1] <= w) // (i-1) is for not include
                    dp[i][w] = Math.max(values[i - 1] + dp[i][w - weight[i - 1]], dp[i - 1][w]);
                // but if we include, we can again include it back, so dp[i][w]  and not i-1
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }
}
