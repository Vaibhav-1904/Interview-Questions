package ImportantQ.Heap;

import java.util.*;

// It can also be Kth Smallest Element
public class KthLargestElement {
    // Naive approach is to Sort the array and return the kth element from end

    // T = O(n), Optimal
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k); // minheap
        for(int i = 0; i < k; i++)
            q.add(nums[i]);
        for(int i = k;i < nums.length; i++)
        {
            if(q.peek() < nums[i]){
                q.remove();
                q.add(nums[i]);
            }
        }
        return q.peek();
    }
}
