package ImportantQ.Queue;
import java.util.*;
// https://leetcode.com/problems/sliding-window-maximum/
public class SlidingWindowMaximum {

//    // Naive T  -> O(n*k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//
//        for(int i = 0; i < nums.length - k + 1; i++){
//            int max = Integer.MIN_VALUE;
//            for(int j = i; j < i + k; j++){
//                max = Math.max(max, nums[j]);
//            }
//            result[i] = max;
//        }
//        return result;
//    }

    // Optimal T -> O(2n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // we will try to store max elements in front of dq
        Deque<Integer> dq = new ArrayDeque<>();
        int j = 0;

        for(int i = 0; i < nums.length; i++){
            // remove index out of range of k
            if(!dq.isEmpty() && dq.peekFirst() == i - k)
                dq.removeFirst();

            // remove numbers which are less than current element
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.removeLast();

            dq.addLast(i);
            if((i - k + 1) == j)
                result[j++] = nums[dq.getFirst()];
        }
        return result;
    }
}
