package ImportantQ.DynamicProgramming.Dp_MinMax;
// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int max = 0;
        for(int i = 0; i < n; i++) {

            if(i > max)
                return false;

            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
