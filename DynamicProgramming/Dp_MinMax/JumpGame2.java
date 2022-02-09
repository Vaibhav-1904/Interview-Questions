package ImportantQ.DynamicProgramming.Dp_MinMax;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGame2 {
//    // Recursive T-> O(n^n)
//    public int jump(int[] nums) {
//        return solve(nums, 0, nums.length - 1);
//    }
//
//    int solve(int[] nums, int start, int end) {
//
//        if(start == end)
//            return 0;
//
//        if(nums[start] == 0)
//            return Integer.MAX_VALUE;
//
//        int min = Integer.MAX_VALUE;
//
//        for(int i = start + 1; i <= end && i <= start + nums[start]; i++) {
//            int jump = solve(nums, i, end);
//
//            if(jump < min)
//                min = jump + 1;
//        }
//
//        return min;
//    }

//    // Memoization
//    int solve(int[] nums, int start, int end, int[] dp) {
//
//        if(start == end)
//            return 0;
//
//        if(nums[start] == 0)
//            return Integer.MAX_VALUE;
//
//        if(dp[start] != -1)
//            return dp[start];
//
//        int min = Integer.MAX_VALUE;
//
//        for(int i = start + 1; i <= end && i <= start + nums[start]; i++) {
//            int jump = solve(nums, i, end, dp);
//
//            if(jump < min)
//                min = jump + 1;
//        }
//        return dp[start] = min;
//    }

    // DP
//    public int jump(int[] nums) {
//        int n = nums.length;
//        if(n == 0 || nums[0] == 0)
//            return 0;
//
//        int[] dp = new int[n]; // The array will tell minimum number of jumps to reach a position i, where i is 0->n
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//
//        for(int i = 1; i < n; i++) {
//            int jump = Integer.MAX_VALUE;
//
//            for(int j = 0; j < i; j++) {
//                if(dp[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
//                    dp[i] = Math.min(dp[i], 1 + dp[j]);
//                }
//            }
//        }
//        return dp[n - 1];
//    }

    // Optimal Greedy Algorithm
    // https://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/
    public int jump(int[] arr) {
        int n = arr.length;
        if(n == 0 || arr[0] == 0)
            return 0;

        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for(int i = 1; i < n; i++) {
            if(i == n-1)
                return jump;

            maxReach = Math.max(maxReach, arr[i] + i);

            step--;

            if(step == 0) {
                jump++;

                if(i >= maxReach)
                    return 0;
                step = maxReach - i;
            }
        }
        return 0;
    }
}
