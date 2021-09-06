package ImportantQ.RecursionBacktracking;
import java.util.*;

// Given a collection of arr numbers  and a target number (target), find all unique combinations
// in candidates where the candidate numbers sum to target.
//
//Each number in arr may only be used once in the combination.
// The Answer should be in Lexicographical Order
public class CombinationSum2 {
    //  Naive Approach //  T -> O(2^n * k * logk) k is  we can take one element more than one time, and therefore for each
    // element ou can check at an average k times and logk for adding elements in a HashSet,
    // we need to remove this log k
    public void combinationSum2(int index, int sum, int[] nums, ArrayList<Integer> arr, HashSet<List<Integer>> result){
        if(sum == 0){
            result.add(new ArrayList<>(arr));
            return;
        }
        if(index == nums.length || sum < 0){
            return;
        }
        arr.add(nums[index]);
        combinationSum2(index + 1, sum - nums[index], nums, arr, result);
        arr.remove(arr.size() - 1);

        combinationSum2(index + 1, sum, nums, arr, result);
    }

    // Optimal T-> O(2^n * k)
    public void combinationSum2(List<List<Integer>> result, List<Integer> arr, int[] nums, int target, int index){
        if(target < 0)
            return;
        else if(target == 0){
            result.add(new ArrayList<>(arr));
            return;
        }
        else{
            for(int i = index; i < nums.length; i++){
                if(i > index && nums[i] == nums[i - 1]) continue;

                arr.add(nums[i]);
                combinationSum2(result, arr, nums, target - nums[i], i + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }
}
