package ImportantQ.DynamicProgramming.Dp_MinMax;
// https://leetcode.com/problems/house-robber/
public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0)
            return 0;
        else if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return Math.max(dp[n-1], dp[n-2]);
    }

//    public int rob(int[] nums) {
//        int a = 0; // house robbed
//        int b = 0; // house not robbed
//        for (int num : nums) {
//            int curr = b + num; // not robbed earlier, so rob curr one i.e. i th one, as let i-1 is not robbed
//            b = Math.max(a, b); // max of robed and not robbed house
//            a = curr; // robbed curr house
//        }
//        return Math.max(a, b); // max of robbed and not robbed
//    }
}
