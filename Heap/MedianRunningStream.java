package ImportantQ.Heap;
import java.util.*;
// https://www.youtube.com/watch?v=Yv2jzDzYlp8
//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianRunningStream {

    // Naive approach -> Use Sorting
//    ArrayList<Integer> arr;
//    /** initialize your data structure here. */
//    public MedianRunningStream() {
//        arr = new ArrayList<>();
//    }
//    public void addNum(int num) {
//        arr.add(num);
//        Collections.sort(arr);
//    }
//    public double findMedian() {
//        int n = arr.size();
//        if((n % 2) == 1){
//            return arr.get(n/2);
//        }else{
//            double sum = arr.get(n/2) + arr.get(n/2 - 1);
//            return sum / 2;
//        }
//    }

    // Optimal T -> O(n * log n), S->O(n)
    // log n is to insert into heap and n for n elements
    PriorityQueue<Integer> minHeap, maxHeap;
    public MedianRunningStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    // If total numbers are ODD, then one extra median element will be present in maxHeap
    public void addNum(int num) {

        if(maxHeap.size() == 0 || num < maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        if(maxHeap.size() - minHeap.size() > 1)
            minHeap.add(maxHeap.remove());
        else if(minHeap.size() - maxHeap.size() > 0)
            maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            double sum = maxHeap.peek() + minHeap.peek();
            return sum / 2;
        }
        return maxHeap.peek();
    }
}
