package ImportantQ.sorting;
import java.util.*;
// https://leetcode.com/problems/largest-number/

public class LargestNumber {
    // T -> O(nlogn)
    public String largestNumber(int[] nums) {
        if(nums.length == 1)
            return String.valueOf(nums[0]);

        String[] arr = new String[nums.length];
        // Copying Integer array to String Array
        for(int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b)); // here a and b are two numbers

        if(arr[0].equals("0"))
            return "0";

        StringBuilder ans = new StringBuilder();
        for(String s: arr)
            ans.append(s);

        return ans.toString();
    }
}
