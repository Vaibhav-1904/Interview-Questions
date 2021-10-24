package ImportantQ.DynamicProgramming.UnBoundedKnapSack;
// Same as Unbounded Knapsack
// https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
public class CuttingRod {
    // Same as Unbounded Knapsack
    static int cuttingRod(int length, int[] prices)
    {
        if(length == 0)
            return 0;

        int[] len = new int[length];
        for(int i = 0; i < length; i++)
            len[i] = i+1;

        int[][] dp = new int[length + 1][length + 1];

        for(int i = 0; i <= length; i++){
            for(int j = 0; j <= length; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(len[i - 1] <= j)
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - len[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[length][length];
    }

    public static void main(String[] args) {
        int[] prices = {3, 5, 8, 9, 10, 17,17, 20};
        System.out.println(cuttingRod(prices.length, prices));
    }
}
