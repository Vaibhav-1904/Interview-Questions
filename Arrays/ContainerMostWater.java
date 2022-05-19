package ImportantQ.Arrays;
// https://www.geeksforgeeks.org/container-with-most-water/
// https://leetcode.com/problems/container-with-most-water/
// Given n non-negative integers a1, a2, ...,an, where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
// Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 // Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
public class ContainerMostWater {

    // Brute Force -> Use 2 for loops to calculate water between each subarray and find the maximum

    // Optimal T-> O(n)
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int area = 0;
        while(left < right){

            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return area;
    }

}
