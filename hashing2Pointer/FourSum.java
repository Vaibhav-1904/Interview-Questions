package ImportantQ.hashing2Pointer;
import java.util.*;
// Given an array nums of n integers, return an array of all the unique quadruplets
// [nums[a], nums[b], nums[c], nums[d]] such that:
// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
public class FourSum {

    //Optimal Approach
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return ans;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0;i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++){
                int left = j + 1;
                int right = n - 1;
                int target2 = target - (nums[i] + nums[j]);
                while(left < right){

                    if(nums[left] + nums[right] < target2)
                        left++;
                    else if(nums[left] + nums[right] > target2)
                        right--;
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]); // First
                        quad.add(nums[j]); // Second
                        quad.add(nums[left]); // Third
                        quad.add(nums[right]); //Fourth

                        if(!ans.contains(quad))
                            ans.add(quad);

                        while(left < right && nums[left] == quad.get(2)) // To get rid of Duplicates in Array
                            left++;

                        while(left < right && nums[right] == quad.get(3)) // To get rid of Duplicates in Array
                            right--;
                    }
                }
                while(i < n - 1 && nums[i] == nums[i+1]) // To get rid of Duplicates in Array
                    i++;

                while(j < n - 1 && nums[j] == nums[j+1]) // To get rid of Duplicates in Array
                    j++;
            }
        }
        return ans;
    }

    public static void main(String[] args){

        int[] arr ={-3,-2,-1,0,0,1,2,3};
        int target = 0;

        // Brute Force
//        List<List<Integer>> ans = new ArrayList<>();
//
//        for(int i = 0; i < arr.length - 3; i++){
//            for(int j = i+1; j < arr.length - 2; j++){
//                int t = target - (arr[i]+arr[j]);
//                Map<Integer,Integer> m = new HashMap<>();
//
//                for(int k = j+1; k < arr.length; k++){
//                    if(m.containsKey(t - arr[k]) ){
//                        List<Integer> a = new ArrayList<>();
//                        a.add(arr[i]); // First element
//                        a.add(arr[j]); // Second
//                        a.add(arr[m.get(t - arr[k])]); // Third
//                        a.add(arr[k]); // Fourth
//                        if(!ans.contains(a)){
//                            ans.add(a);
//                        }
//                    }
//                    else {
//                        m.put(arr[k], k);
//                    }
//                }
//            }
//        }
//        System.out.println(ans);
    }
}
