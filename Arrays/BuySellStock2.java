package ImportantQ.Arrays;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if(n < 2)
            return 0;

        int profit = 0;

        for(int i = 0; i < n - 1; i++){
            if(prices[i] < prices[i + 1]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
