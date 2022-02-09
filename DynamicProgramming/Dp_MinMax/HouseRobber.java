package ImportantQ.DynamicProgramming.Dp_MinMax;
// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    //Memoization
    int solve(int[] arr, int index, int[] dp) {

        if(index == 0)
            return arr[0];

        if(index < 0)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        int rob = arr[index] + solve(arr, index - 2, dp);

        int notRob = solve(arr, index - 1, dp);

        return dp[index] = Math.max(rob, notRob);
    }


    // Tabulation
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0)
            return 0;
        else if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[n]; // It will tell the maximum value that can be robbed at any given position.
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return Math.max(dp[n-1], dp[n-2]);
    }

    // Optimal
//    public int rob(int[] nums) {
//        int n = nums.length;
//
//        if(n == 1)
//            return nums[0];
//        else if(n == 2)
//            return Math.max(nums[0], nums[1]);
//        else{
//            int rob = 0;
//            int notRob = 0;
//
//            for(int i : nums){
//                int cur = i + notRob;
//
//                notRob = Math.max(rob, notRob);
//                rob = cur;
//            }
//
//            return Math.max(rob, notRob);
//        }
//    }
}
