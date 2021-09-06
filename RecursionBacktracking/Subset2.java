package ImportantQ.RecursionBacktracking;
import java.util.*;
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.
public class Subset2 {
    // Naive Approach T -> O(2^n * (longn + nlong))
//    public static List<List<Integer>> subsetsWithDup(int[] nums) {
//        HashSet<List<Integer>> ans = new HashSet<>();
//        int n = nums.length;
//        for(int num = 0; num < (1<<n); num++){
//            List<Integer> arr = new ArrayList<>();
//            for(int i = 0; i < n; i++){
//                if((num & (1<<i)) > 0)
//                    arr.add(nums[i]);
//            }
//            Collections.sort(arr);
//            ans.add(arr);
//        }
//        return new ArrayList<>(ans);
//    }

    //  Optimal - Recursive T -> O(2^n * n)
    public static void subsetsWithDup(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // adding it in new ArrayList coz if in future current is changed, then it is a reference type
        // and will create a problem in  result
        result.add (new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i - 1] == nums[i]) {
                continue;
            }

            current.add(nums[i]);
            subsetsWithDup(nums, i + 1, current, result);

            // BackTrack
            current.remove (current.size () - 1);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
//        List<List<Integer>> result = subsetsWithDup(arr);
//        for (List<Integer> i:result)
////            System.out.println(i);
    }
}
