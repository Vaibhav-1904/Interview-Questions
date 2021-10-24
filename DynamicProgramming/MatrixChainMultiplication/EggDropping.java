package ImportantQ.DynamicProgramming.MatrixChainMultiplication;
// https://leetcode.com/problems/super-egg-drop/
public class EggDropping {
    Integer[][] dp = new Integer[101][10001];

    public int superEggDrop(int e, int f) {

        if(e == 1)
            return f;

        if(f == 0 || f == 1)
            return f;

        if(dp[e][f] != null)
            return dp[e][f];

        int min = Integer.MAX_VALUE;
        int i = 1;
        int j = f;

        while(i <= j){
            int mid = (i + j) / 2;

            int brek = superEggDrop(e - 1, mid - 1);
            int notBreak = superEggDrop(e, f - mid);
            int temp = 1 + Math.max(brek, notBreak);

            if(brek < notBreak)
                i = mid + 1;
            else
                j = mid - 1;

            min = Math.min(min, temp);
        }

        return dp[e][f] = min;
    }
}
