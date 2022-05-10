package ImportantQ.Arrays.ArrayList;
// Given an array of positive integers of size n. Find the maximum sum of triplet( ai + aj + ak ) such that
// 0 <= i < j < k < n and ai < aj < ak.
// https://www.geeksforgeeks.org/find-maximum-sum-triplets-array-j-k-ai-aj-ak/
import java.util.*;

public class MaxSumTriplet {
    // Brute Approach is to Run 3 for loops and calculate each Triplet Sum.

    // T->O(n^2)
    // Better, run a loop from 1 to n - 1 elements and take it as 2nd element, (ith element).
    // Run a loop to find max element from 0 to i as 1st max element
    // and a loop from i+1 to n to find 3rd max element
//    public int maxTripletSum(ArrayList<Integer> A) {
//        int ans = 0;
//        for(int i = 1; i < A.size() - 1; i++){
//
//            int max1 = 0, max2 = 0;
//            for(int j = 0; j < i; j++){
//                if(A.get(i) > A.get(j)){
//                    max1 = Math.max(A.get(j), max1);
//                }
//            }
//
//            for(int j = i + 1; j < A.size(); j++){
//                if(A.get(i) < A.get(j)){
//                    max2 = Math.max(A.get(j), max2);
//                }
//            }
//            if(max1 > 0 && max2 > 0){
//                ans = Math.max(ans, max1 + A.get(i) + max2);
//            }
//        }
//        return ans;
//    }

    // Optimal T-> O(
    public static int maxTripletSum(ArrayList<Integer> A){
        int[] maxSuffixArr = new int[A.size() + 1];
        maxSuffixArr[A.size()] = 0;
        // Calculate suffix-array containing maximum
        // value for index i, i+1, i+2, ... n-1 in
        // ArrayList A
        for(int j = A.size() - 1; j >= 1; j--)
            maxSuffixArr[j] = Math.max(maxSuffixArr[j + 1], A.get(j));

        int ans = 0;
        // Insert minimum value for first comparison
        // in the set
        TreeSet<Integer> lowerBound = new TreeSet<>();
        // TreeSet.lower(n) function returns a number which is just smaller than n in TreeSet
        lowerBound.add(Integer.MIN_VALUE);
        for(int j = 0; j < A.size() - 1; j++) {
            if(maxSuffixArr[j + 1] > A.get(j))
                ans = Math.max(ans, lowerBound.lower(A.get(j)) + A.get(j) + maxSuffixArr[j + 1]);

            lowerBound.add(A.get(j));
        }

        return ans;
    }
}
