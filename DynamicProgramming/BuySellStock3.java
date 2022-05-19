package ImportantQ.DynamicProgramming;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int tran1 = 0;
        int buy2 = Integer.MAX_VALUE;
        int bothTranProfit = 0;
        for (int p : prices) {
            // "buy1" -> money you pay for the 1st tran buy.
            // For each buy, we want the price to be as low as possible.
            // So the lower the p is, the more possible profit.
            buy1 = Math.min(buy1, p);
            // "tran1" -> money you make if you sell buy1 at this p.
            // Max tran1 profit: p - (lowest_buy1_at_some_prev_p).
            tran1 = Math.max(tran1, p - buy1);
            // "buy2" -> money you pay for the 2nd tran buy. buy2 must
            // happen AFTER tran1, so the money you pay is "price - tran1".
            // buy2 = min(previous_buy2, current_price - tran1)
            buy2 = Math.min(buy2, p - tran1);
            // "bothTranProfit" -> The money one makes after tran2 is finished.
            // Because buy2 comes from some prev "p[prev] - tran1", so
            // "p - buy2" below means "p[cur] - p[prev] + tran1".
            // => "second_tran_delta + tran1" => "tran2 + tran1"
            bothTranProfit = Math.max(bothTranProfit, p - buy2);
        }
        return bothTranProfit;
    }
}
