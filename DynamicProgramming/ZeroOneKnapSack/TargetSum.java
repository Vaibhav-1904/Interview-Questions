package ImportantQ.DynamicProgramming.ZeroOneKnapSack;
// https://leetcode.com/problems/target-sum/
public class TargetSum {

//    // Naive
//    public static int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        int sum = 0;
//        for(int i : nums)
//            sum += i;
//
//        if(((sum - target) % 2 == 1) || (target > sum))
//            return 0;
//        sum = (sum - target) / 2;
//        return countSubsets(nums, nums.length, sum);
//    }
//    static int countSubsets(int[] nums, int n, int sum){
//        if(sum == 0 && n == 0)
//            return 1;
//        if(n == 0)
//            return 0;
//        return countSubsets(nums, n - 1, sum - nums[n - 1]) + countSubsets(nums, n - 1, sum);
//    }

    // Better T -> O (n*sum)
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;

        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        sum = (sum - target) / 2;
        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++)
                dp[i][j] = -1;
        }

        return countSubsets(nums, nums.length, sum, dp);
    }
    static int countSubsets(int[] nums, int n, int sum, int[][] dp ){
        if(sum < 0)
            return 0;

        if(sum == 0 && n == 0)
            return dp[n][sum] = 1;
        if(n == 0)
            return dp[n][sum] = 0;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        return dp[n][sum] = countSubsets(nums, n - 1, sum - nums[n - 1], dp) + countSubsets(nums, n - 1, sum, dp);
    }


    // Optimal
//    public static int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        int sum = 0;
//        for(int i : nums)
//            sum += i;
//
//        if(((sum - target) % 2 == 1) || (target > sum))
//            return 0;
//
//        sum = (sum - target) / 2;
//
//        int[][] dp = new int[n + 1][sum + 1];
//        for(int i = 1; i <= sum; i++)
//            dp[0][i] = 0;
//        for(int i = 0; i <= n; i++)
//            dp[i][0] = 1;
//
//        dp[0][0] = 1;
//        for(int i = 1; i <= n; i++){
//            for(int j = 0; j <= sum; j++){
//                if(nums[i - 1] <= j)
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[n][sum];
//    }


}
