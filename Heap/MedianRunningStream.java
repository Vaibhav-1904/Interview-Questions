package ImportantQ.Heap;
import java.util.*;

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

    // Optimal T -> O(n * long n), S->O(n)
    // log n is to insert into heap and n for n elements
    PriorityQueue<Integer> min, max;
    public MedianRunningStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        if(max.size() == 0 || num < max.peek())
            max.add(num);
        else
            min.add(num);

        if(max.size() - min.size() > 1)
            min.add(max.remove());
        else if(min.size() - max.size() > 0)
            max.add(min.remove());
    }

    public double findMedian() {
        if(max.size() == min.size()){
            double sum = max.peek() + min.peek();
            return sum / 2;
        }
        return max.peek();
    }
}
