package ImportantQ.Stack;
import java.util.Stack;
// https://www.geeksforgeeks.org/the-stock-span-problem/
public class StockSpan {
//    // Naive T -> O(n^2)
//    static int[] calculateSpan(int[] prices){
//        int[] span = new int[prices.length];
//        for(int i = 0; i < prices.length; i++){
//            int ans = 1;
//            for(int j = i - 1; j >= 0; j--){
//                if(prices[j] <= prices[i]){
//                    ans++;
//                }else
//                    break;
//            }
//            span[i] = ans;
//        }
//        return span;
//    }

    // Optimal T -> O(n)
    static int[] calculateSpan(int[] prices){
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
        for(int i = 1; i < prices.length; i++){
            while(!stack.isEmpty() && prices[i] >= prices[stack.peek()])
                stack.pop();

            span[i] = (stack.isEmpty()) ? (i+1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }


    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] span = calculateSpan(prices);
        for(int i:span)
            System.out.print(i + " ");
    }
}
