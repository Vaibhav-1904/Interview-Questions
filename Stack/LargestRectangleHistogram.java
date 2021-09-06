package ImportantQ.Stack;
import java.util.Stack;
// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleHistogram {
//    // T -> O(n^2)
//    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int area = 0;
//        int max = 0;
//
//        for(int i = 0; i < n; i++){
//            int l = heights[i];
//            int b = 1;
//            for(int j = i - 1; j >= 0; j--){
//                if(heights[j] < l)
//                    break;
//                else
//                    b++;
//            }
//            for(int j = i + 1; j < n; j++){
//                if(heights[j] < l)
//                    break;
//                else
//                    b++;
//            }
//
//            max = Math.max(max, l*b);
//        }
//        return max;
//    }

    // Better Approach --> Two Pass -> O(n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>(); // wll store indexes of elements in increasing order

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])// pop till we encounter any smaller element than h[i] in array to the left side
                stack.pop();
            // Add 1 because from index(stack.peek) + 1, your boundary of that bar starts
            left[i] = (stack.isEmpty()) ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        while(!stack.isEmpty())
            stack.pop();

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])// pop till we encounter any smaller element in array to the right side
                stack.pop();
            // we subtract 1 because our boundary will be -1 for that h[i]
            right[i] = (stack.isEmpty()) ? n-1 : stack.peek() - 1;
            stack.push(i);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, heights[i] * (right[i] - left[i] + 1));
        }
        return max;
    }

    //Optimal
//    public int largestRectangleArea(int[] heights) {
//        Stack<Integer> stack = new Stack<>();
//        int n = heights.length;
//        int area = 0;
//
//        for(int i = 0; i < n + 1; i++){
//            while(!stack.isEmpty() && (i == n || heights[i] <= heights[stack.peek()])){
//                int l = heights[stack.pop()];
//                int b = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
//                area = Math.max(area, l*b);
//            }
//            stack.push(i);
//        }
//        return area;
//    }
}
