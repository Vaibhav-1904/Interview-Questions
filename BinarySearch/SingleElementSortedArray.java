package ImportantQ.BinarySearch;
// You are given a sorted array consisting of only integers where every element appears exactly twice, 
// except for one element which appears exactly once. Find this single element that appears only once.
// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class SingleElementSortedArray {

//    //Brute
////    public int singleNonDuplicate(int[] nums) {
////
////        if(nums.length == 1)
////            return nums[0];
////
////        for(int i = 0; i < nums.length; i=i+2){
////            if(i == nums.length-1)
////                return nums[nums.length-1];
////
////
////            if(nums[i] != nums[i+1]){
////                return nums[i];
////            }
////        }
////
////        return -1;
////    }

    // Optimal T-> O(logn)
    public int singleNonDuplicate(int[] nums){
        int low = 0;
        int high = nums.length - 2; // high = n-2 for the edge case if the single element is at last index

        // xor of 1 with an even number n will give n + 1.
        // for Eg - 1^4 == 5
        // and xor of 1 with odd number n will give n - 1
        // Eg - 1^3 == 2
        while(low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == nums[mid ^ 1]){ // If mid is in left of partition, it will shrink left
                low = mid + 1;
            }else
                high = mid - 1;
        }

        return nums[low];
    }

}
