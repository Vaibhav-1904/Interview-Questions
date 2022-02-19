package ImportantQ.Heap;
import java.util.*;

// It can also be Kth Smallest Element
public class KthLargestElement {
    // Naive approach is to Sort the array and return the kth element from end

    // T = O(n), Optimal
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k); // minheap
        for(int i = 0; i < nums.length; i++)
        {
            if(pq.size() < k)
                pq.add(nums[i]);
            else if(pq.peek() < nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
