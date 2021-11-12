package ImportantQ.DynamicProgramming.DistinctWays;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class DiceThrows {
    public int numRollsToTarget(int dice, int faces, int target) {

        if(dice * faces < target || dice == 0)
            return 0;

        int[][] dp = new int[dice + 1][target + 1];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return solve(dice, faces, target, dp);
    }

    int solve(int dice, int faces, int target, int[][] dp) {
        int ways = 0;
        if(dice == 0 && target == 0)
            return 1;

        if(dice < 0 || target < 0)
            return 0;

        if(dp[dice][target] != -1)
            return dp[dice][target];

        for(int i = 1; i <= faces; i++){
            ways += solve(dice - 1, faces, target - i, dp);
            ways = ways % 1000000007;
        }
        return dp[dice][target] = ways;
    }
}
