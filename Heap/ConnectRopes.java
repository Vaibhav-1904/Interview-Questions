package ImportantQ.Heap;
import java.util.*;
// https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
public class ConnectRopes {
    // Naive Solution is to Sort the array First
    // Start traversing in array and add first 2 ropes
    // Now after adding, insert the sum in its appropriate position in array
    // so that array remains in sorted form
    // And while adding every 2 smallest ropes, maintain a cost variable
    // keep adding sum to that cost variable each time.
    // T = O(n^2)

    // Optimal Approach
    long minCost(long[] arr, int n)
    {
        PriorityQueue<Long> q = new PriorityQueue<>(n);
        for(long i:arr)
            q.add(i);

        long cost = 0;
        for(int i = 0; i < n - 1; i++){
            long sum = q.remove() + q.remove();
            cost += sum;
            q.add(sum);
        }
        return cost;
    }
}
