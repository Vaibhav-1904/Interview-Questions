package ImportantQ.ArrayList;
// Given an array of positive integers of size n. Find the maximum sum of triplet( ai + aj + ak ) such that
// 0 <= i < j < k < n and ai < aj < ak.
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class MaxSumTriplet {
    // Brute Approach is to Run 3 for loops and calculate each Triplet Sum.

//    // Better
    public int solve(ArrayList<Integer> A) {

        int ans = 0;
        for(int i = 1; i < A.size() - 1; i++){

            int max1 = 0, max2 = 0;
            for(int j = 0; j < i; j++){
                if(A.get(i) > A.get(j)){
                    max1 = Math.max(A.get(j), max1);
                }
            }

            for(int j = i+1; j < A.size(); j++){
                if(A.get(i) < A.get(j)){
                    max2 = Math.max(A.get(j), max2);
                }
            }
            if(max1 > 0 && max2 > 0){
                ans = Math.max(ans, max1 + A.get(i) + max2);
            }
        }
        return ans;
    }

    // Optimal
    public static int maxTripletSum(ArrayList<Integer> A){
        int[] maxSuffixArr = new int[A.size() + 1];
        maxSuffixArr[A.size()] = 0;
        // Calculate suffix-array containing maximum
        // value for index i, i+1, i+2, ... n-1 in
        // ArrayList A
        for(int j = A.size() - 1; j >= 1; j--)
            maxSuffixArr[j] = Math.max(maxSuffixArr[j+1], A.get(j));

        int ans = 0;
        // Insert minimum value for first comparison
        // in the set
        TreeSet<Integer> lowerBound = new TreeSet<>();
        lowerBound.add(Integer.MIN_VALUE);
        for(int j = 0; j < A.size() - 1; j++){
            if(maxSuffixArr[j+1] > A.get(j)){
                ans = Math.max(ans,lowerBound.lower(A.get(j)) + A.get(j) + maxSuffixArr[j + 1]);
            }
            lowerBound.add(A.get(j));
        }

        return ans;
    }
}
