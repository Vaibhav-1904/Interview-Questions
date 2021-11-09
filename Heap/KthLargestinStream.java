package ImportantQ.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestinStream {

    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[arr.length];
        for(int i  = 0; i < arr.length; i++){
            if(pq.size() < k)
                pq.add(arr[i]);
            else{
                if(arr[i] > pq.peek()){
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
