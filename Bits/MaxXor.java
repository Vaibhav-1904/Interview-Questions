package ImportantQ.Bits;

import java.util.HashSet;

// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
public class MaxXor {
//    // Naive
//    public int findMaximumXOR(int[] nums) {
//
//        int ans = 0, max = 0;
//        int n = nums.length;
//        for(int i = 0; i < n - 1; i++){
//            for(int j = i+1; j < n; j++){
//                ans = nums[i] ^ nums[j];
//
//                if(max < ans)
//                    max = ans;
//            }
//        }
//
//        return max;
//    }

    //Optimal
    public int findMaximumXOR(int[] nums) {

        int mask = 0, max = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1<<i);
            HashSet<Integer> h = new HashSet<>();
            for(int num:nums)
                h.add(mask & num);

            int temp = max | (1<<i);
            for(int prefix:h){
                if(h.contains(temp ^ prefix)){
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}
