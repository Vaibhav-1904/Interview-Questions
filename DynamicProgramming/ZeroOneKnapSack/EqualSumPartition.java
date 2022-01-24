package ImportantQ.DynamicProgramming.ZeroOneKnapSack;
// https://leetcode.com/problems/partition-equal-subset-sum/
public class EqualSumPartition {
//    // Naive -> Memoization
//    public boolean canPartition(int[] nums) {
//
//        int sum = 0;
//        for(int i : nums)
//            sum += i;
//
//        if(sum % 2 == 1)
//            return false;
//
//        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
//
//        return isSumSubset(nums.length, nums, sum>>1, dp);
//    }
//
//    boolean isSumSubset(int n, int[] arr, int sum, boolean[][] dp){
//        if(sum == 0)
//            return dp[n][sum] = true;
//        if(n == 0)
//            return dp[n][sum] = false;
//
//        if(arr[n - 1] <= sum)
//            return dp[n][sum] = isSumSubset(n - 1, arr, sum - arr[n-1], dp) || isSumSubset(n-1, arr, sum, dp);
//        else
//            return dp[n][sum] = isSumSubset(n-1, arr, sum, dp);
//    }

    // Top-Down Approach T->O(n*sum) S->O(n*sum)
//    public boolean canPartition(int[] nums) {
//        int n = nums.length;
//
//        int sum = 0;
//        for(int i : nums)
//            sum += i;
//
//        if(sum % 2 == 1)
//            return false;
//
//        sum = (sum>>1);
//        boolean[][] dp = new boolean[n + 1][sum + 1];
//
//        for(int i = 1; i <= sum; i++)
//            dp[0][i] = false;
//        for(int i = 0; i <= n; i++)
//            dp[i][0] = true;
//
//        for(int i = 1 ; i <= n; i++)
//        {
//            for(int s = 1; s <= sum; s++)
//            {
//                if(nums[i - 1] <= s)
//                    dp[i][s] = dp[i - 1][s] || dp[i - 1][s - nums[i - 1]];
//                else
//                    dp[i][s] = dp[i - 1][s];
//            }
//        }
//        return dp[n][sum];
//    }

    // Optimal Approach S->O(sum)
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int i : nums)
            sum += i;

        if(sum % 2 == 1)
            return false;

        sum = sum>>1;
        boolean[] dp = new boolean[sum + 1];

        for(int i = 0; i < n; i++){
            for(int s = sum; s >= nums[i]; s--){
                if(dp[s - nums[i]] || s == nums[i]) // dp[s - nums[i]] tells if sum was true at s-nums[i],
                    dp[s] = true; // if it was true at that point, then it will be true at current point (s-nums[i]+nums[i])
            }
        }
        return dp[sum];
    }

}
