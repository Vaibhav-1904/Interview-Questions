package ImportantQ.DynamicProgramming.Dp_MinMax;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(i == triangle.size() - 1){
                    dp[j] = triangle.get(i).get(j);
                }else{
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}
