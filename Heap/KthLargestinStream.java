package ImportantQ.Heap;
import java.util.Arrays;
import java.util.PriorityQueue;
//https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/#:~:text=An%20Efficient%20Solution%20is%20to,in%20O(1)%20time.
//https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1/
// Given an input stream arr[] of n integers. Find the Kth largest element for each element in
// the stream and if the Kth element doesn't exist, return -1.
public class KthLargestinStream {

    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k); // min-heap
        int[] result = new int[arr.length];
        for(int i  = 0; i < arr.length; i++){
            if(pq.size() < k)
                pq.add(arr[i]);
            else{
                if(arr[i] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }

            if(pq.size() >= k)
                result[i] = pq.peek();
            else
                result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(kthLargest(4, arr, 6)));
    }
}
