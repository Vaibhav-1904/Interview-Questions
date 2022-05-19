package ImportantQ.Arrays;
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.
// https://leetcode.com/problems/trapping-rain-water/
// Input: height = [4,2,0,3,2,5]
//Output: 9
public class TrappingRainWater {

//    // Brute Force S->O(n)
//    public int trap(int[] height) {
//
//        int n = height.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//
//        int water = 0;
//
//        int max = 0;
//        for(int i = 0; i < n; i++) {
//
//            max = Math.max(max, height[i]);
//
//            left[i] = max;
//        }
//
//        max = 0;
//        for(int i = n - 1; i >= 0; i--) {
//            max = Math.max(max, height[i]);
//
//            right[i] = max;
//        }
//
//
//        for(int i = 0; i < n; i++) {
//            int min = Math.min(left[i], right[i]);
//
//            if(min > height[i])
//                water += (min - height[i]);
//        }
//
//        return water;
//    }

    //Optimal S->O(1)
    public int trap(int[] height) {

        int ans = 0;
        int n = height.length;

        int left_max = 0, right_max = 0;

        int left = 0, right = n - 1;

        while(left <= right){
            if(height[left] < height[right]){
                if(height[left] > left_max){
                    left_max = height[left];
                }else{
                    ans += (left_max - height[left]);
                }
                left++;
            }else{
                if(height[right] > right_max)
                    right_max = height[right];
                else
                    ans += (right_max - height[right]);

                right--;
            }
        }
        return ans;
    }

}
