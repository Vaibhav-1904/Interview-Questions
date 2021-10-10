package ImportantQ.ArrayList;
// You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j)
// for all 1 ≤ i, j ≤ N.
// https://www.geeksforgeeks.org/maximum-absolute-difference-value-index-sums/
//f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
import java.util.ArrayList;

public class MaxAbsolutePair {

    // A naive brute force approach is to calculate the value f(i, j)
    // by iterating over all such pairs (i, j),  T->O(n^2)

    // There can be 4 conditions in maximising |A[i] - A[j]| + |i - j|
    // 1) A[i] > A[j] and i > j, this is (max1 & min1)
    // 2) A[i] < A[j] and i < j, this is (max1 & min1)
    // 3) A[i] < A[j] and i > j, this is (max2 & min2)
    // 4) A[i] > A[j] and i < j, this is (max2 & max2)

    // Cases 1 and 2 are same, and so cases 3 and 4
    public int maxArr(ArrayList<Integer> A) {
        // Optimal
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;

        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0; i < A.size(); i++){

            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);

            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }

        return Math.max(max1 - min1, max2 - min2);
    }

}
