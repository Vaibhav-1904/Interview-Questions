package ImportantQ.hashing2Pointer;
import java.util.*;
// https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
// and nums[i] + nums[j] + nums[k] == 0.
public class ThreeSum {

    // Bruter Force
//    public List<List<Integer>> threeSum(int[] arr) {
//
//        List<List<Integer>> ans = new ArrayList<>();
//        int n = arr.length;
//
//        for(int i = 0; i < n - 2; i++){
//            HashSet<Integer> h = new HashSet<>();
//            for(int j = i + 1; j < n; j++){
//                int sum = (arr[i] + arr[j]) * -1;
//                if(h.contains(sum)){
//                    ArrayList<Integer> Triplet = new ArrayList<>();
//                    Triplet.add(sum);
//                    Triplet.add(arr[i]);
//                    Triplet.add(arr[j]);
//                    if(!ans.contains(Triplet))
//                        ans.add(Triplet);
//                }else
//                    h.add(arr[j]);
//            }
//        }
//        return ans;
//    }

    // Optimal
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < n - 1; i++){
            int left = i + 1;
            int right = n - 1;

            while(left < right){
                sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    left++;
                }else if(sum > 0)
                    right--;
                else{
                    List<Integer> Triplet = new ArrayList<>();
                    Triplet.add(nums[i]);
                    Triplet.add(nums[left]);
                    Triplet.add(nums[right]);

                    if(!ans.contains(Triplet)){
                        ans.add(Triplet);
                    }
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }


}
