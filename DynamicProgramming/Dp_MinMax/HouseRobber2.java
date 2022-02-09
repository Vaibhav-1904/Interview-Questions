package ImportantQ.DynamicProgramming.Dp_MinMax;
// https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7
// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2 {
    // same as houseRob1
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);
        else{
            int rob1 = 0;
            int notRob1 = 0;

            for(int i = 0; i < n-1; i++) {
                int cur = nums[i] + notRob1;

                notRob1 = Math.max(rob1, notRob1);
                rob1 = cur;
            }

            rob1 = Math.max(rob1, notRob1);

            int rob2 = 0;
            int notRob2 = 0;

            for(int i = 1; i < n; i++) {
                int cur = nums[i] + notRob2;

                notRob2 = Math.max(rob2, notRob2);
                rob2 = cur;
            }

            rob2 = Math.max(rob2, notRob2);

            return Math.max(rob1, rob2);
        }
    }
}
