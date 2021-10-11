package ImportantQ.Arrays;
import java.util.Arrays;
// https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        // Naive Apprach is -> We can use 3 for loops and keep track using i, j, k.
        // let sum of i,j,k elements be sum.
        // And we need to find Math.min(closest_sum, Math.abs(sum - key))

        // Optimal Approach using 2 Pointer Algo
        // T-> O(n^2)
        int n = nums.length;
        Arrays.sort(nums);
        long ans = Integer.MAX_VALUE;

        for(int i = 0; i < n - 2; i++){

            int left = i + 1;
            int right = n - 1;

            while(left < right){

                long sum = nums[i] + nums[left] + nums[right];

                if(Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }

                if(sum > target)
                    right--;
                else
                    left++;
            }
        }
        return (int)ans;
    }
}
