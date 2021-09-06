package ImportantQ.ArrayList;
import java.util.*;
public class FirstMissingInteger {
//    // Naive, T -> O(n + nlog(n)), S -> O(n)
//    public int firstMissingPositive(int[] nums) {
//
//        HashSet<Integer> h = new HashSet<>();
//        for (int num : nums) {
//            h.add(num);
//        }
//
//        for(int i = 1; i <= nums.length + 1; i++){
//            if(!h.contains(i))
//                return i;
//        }
//        return 1;
//    }

    //Optimal
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        int i;
        for(i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                int correctPos = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctPos];
                nums[correctPos] = temp;
            }
        }
        for(i = 0; i < n; i++){
            if(i + 1 != nums[i]){
                return i + 1;
            }
        }
        return n + 1;
    }
}
