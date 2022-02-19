package ImportantQ.DynamicProgramming.Dp_MinMax;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int lastRow = triangle.size() - 1;
        int[] dp = new int[lastRow + 1];

        for(int i = lastRow; i >= 0; i--) {

            int rowSize = triangle.get(i).size();

            for(int j = 0; j < rowSize; j++) {
                if(i == lastRow)
                    dp[j] = triangle.get(i).get(j);
                else
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
