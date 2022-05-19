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
//    public int maxTripletSum(ArrayList<Integer> arr) {
//        int ans = 0;
//        for(int i = 1; i < arr.size() - 1; i++){
//
//            int max1 = 0, max2 = 0;
//            for(int j = 0; j < i; j++) {
//                if(arr.get(j) < arr.get(i))
//                    max1 = Math.max(arr.get(j), max1);
//            }
//
//            for(int j = i + 1; j < arr.size(); j++){
//                if(arr.get(i) < arr.get(j)){
//                    max2 = Math.max(arr.get(j), max2);
//                }
//            }
//            if(max1 > 0 && max2 > 0){
//                ans = Math.max(ans, max1 + arr.get(i) + max2);
//            }
//        }
//        return ans;
//    }

    // Optimal T-> O(NlogN)
    public static int maxTripletSum(ArrayList<Integer> arr) {
        int[] maxSuffixArr = new int[arr.size() + 1];
        maxSuffixArr[arr.size()] = 0;
        // Calculate suffix-array containing maximum
        // value for index i, i+1, i+2, ... n-1 in ArrayList arr

        for(int j = arr.size() - 1; j >= 1; j--)
            maxSuffixArr[j] = Math.max(arr.get(j), maxSuffixArr[j + 1]);

        int ans = 0;
        // Insert minimum value for first comparison
        // in the set
        TreeSet<Integer> lowerBound = new TreeSet<>();
        // TreeSet.lower(n) function returns a number which is just smaller than n in TreeSet
        lowerBound.add(Integer.MIN_VALUE);
        for(int j = 0; j < arr.size() - 1; j++) {
            if(maxSuffixArr[j + 1] > arr.get(j))
                ans = Math.max(ans, lowerBound.lower(arr.get(j)) + arr.get(j) + maxSuffixArr[j + 1]);
            lowerBound.add(arr.get(j));
        }

        return ans;
    }
}
