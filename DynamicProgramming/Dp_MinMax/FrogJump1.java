package ImportantQ.DynamicProgramming.Dp_MinMax;
// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class FrogJump1 {
//    int frogJump(int[] heights, int index) {
//        if(index == 0)
//            return 0;
//
//        int one = frogJump(heights, index - 1) + Math.abs(heights[index] - heights[index-1]);
//        int two = Integer.MAX_VALUE;
//        if(index > 1)
//            two = frogJump(heights, index - 2) + Math.abs(heights[index] - heights[index-2]);
//
//        return Math.min(one, two);
//    }

    // DP T-> O(n)
    int frogJump(int[] heights, int index, int[] dp) {
        if(index == 0)
            return 0;

        if(dp[index] != -1)
            return dp[index];

        int one = frogJump(heights, index - 1, dp) + Math.abs(heights[index] - heights[index-1]);
        int two = Integer.MAX_VALUE;

        if(index > 1)
            two = frogJump(heights, index - 2, dp) + Math.abs(heights[index] - heights[index-2]);

        return dp[index] = Math.min(one, two);
    }

    // Optimal
    int frogJump(int[] heights) {
        int prev = 0;
        int prev2 = 0;
        for(int i = 1; i < heights.length; i++) {
            int one = prev + Math.abs(heights[i - 1] - heights[i]);

            int two = Integer.MAX_VALUE;
            if(i > 1)
                two = prev2 + Math.abs(heights[i - 2] - heights[i]);

            int cur = Math.min(one, two);

            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

}
