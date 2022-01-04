package ImportantQ.BitManipulation;
import java.util.*;
// Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
// Find max XOR of any Pair in given array
// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class MaxXor {
//    // Naive T-> O(n^2)
//    public int findMaximumXOR(int[] nums) {
//
//        int max = 0;
//        int n = nums.length;
//        for(int i = 0; i < n - 1; i++){
//            for(int j = i+1; j < n; j++){
//                max = Math.max(max, nums[i] ^ nums[j]);
//            }
//        }
//        return max;
//    }

    // Better T->O(n logn)
//    public int findMaximumXOR(int[] nums) {
//
//        int mask = 0, max = 0;
//        for(int i = 31; i >= 0; i--){
//            mask = mask | (1<<i);
//            HashSet<Integer> set = new HashSet<>();
//            for(int num : nums)
//                set.add(mask & num);
//
//            int temp = max | (1<<i);
//            for(int prefix:set){
//                if(set.contains(temp ^ prefix)){
//                    max = temp;
//                    break;
//                }
//            }
//        }
//        return max;
//    }

    static class TrieNode{
        TrieNode[] trieNodes = new TrieNode[2];

        TrieNode(){
            trieNodes[0] = trieNodes[1] = null;
        }
    }
    // Optimal T->O(32 * n)
    public static int findMaximumXOR(int[] nums) {
        TrieNode root = buildTrie(nums);
        int ans = 0;
        
        for(int num : nums){
            TrieNode cur = root;
            int cur_max = 0;
            for(int i = 31; i >= 0; i--){
                int bit = (num >> i) & 1;
                bit = (bit == 0) ? 1 : 0;
                if(cur.trieNodes[bit] != null){
                    cur_max = cur_max << 1;
                    cur_max = cur_max | 1; // if opposite bit exists, then add binary 1 to the ans.
                    cur = cur.trieNodes[bit];
                }else {
                    cur_max = cur_max << 1;
                    cur = cur.trieNodes[bit ^ 1]; // if bit was 0, and it doesn't exist, then go 1(right) and vice-versa.
                }
            }
            ans = Math.max(ans, cur_max);
        }
        return ans;
    }
    public static TrieNode buildTrie(int[] arr){
        TrieNode root = new TrieNode();
        for(int num : arr){
            TrieNode cur = root;
            for(int i = 31; i >= 0; i--){
                int bit = (num >> i) & 1;
                if(cur.trieNodes[bit] == null)
                    cur.trieNodes[bit] = new TrieNode();
                cur = cur.trieNodes[bit];
            }
        }
        return root;
    }
}
