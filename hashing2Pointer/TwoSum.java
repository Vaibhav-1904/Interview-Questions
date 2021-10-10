package ImportantQ.hashing2Pointer;
import java.util.*;
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
// https://leetcode.com/problems/two-sum/

public class TwoSum {
    // T-> O(n) S->O(n)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> m = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < n; i++){
            if(m.containsKey(target - nums[i])){
                ans[0] = m.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            else
                m.put(nums[i],i);
        }
        return ans;
    }

}
