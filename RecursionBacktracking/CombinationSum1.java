package ImportantQ.RecursionBacktracking;
// Given an array of distinct integers arr and a target integer target, return a list of all unique combinations
// of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from arr, an unlimited number of times. Two combinations are unique
// if the frequency of at least one of the chosen numbers is different.
import java.util.*;
// https://leetcode.com/problems/combination-sum/

public class CombinationSum1 {
    //  T -> O(2^n * k) k is  we can take one element more than one time, and therefore for each
    // element ou can check at an average k times.
    public void combinationSum(int index, int sum, int[] nums, ArrayList<Integer> arr, List<List<Integer>> result){
        if(sum == 0){
            result.add(new ArrayList<>(arr));
            return;
        }

        if(index == nums.length || sum < 0){
            return;
        }
        combinationSum(index + 1, sum, nums, arr, result); // not taking current index

        if(nums[index] <= sum){// taking current index but after checking.
            arr.add(nums[index]);
            combinationSum(index, sum - nums[index], nums, arr, result); // taking same index again. 
            arr.remove(arr.size() - 1);
        }
    }
}
