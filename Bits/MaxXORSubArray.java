package ImportantQ.Bits;
// Given an array of integers. find the maximum XOR subarray value in given array. Expected time complexity O(n).
public class MaxXORSubArray {
//    // Naive Approach T->O(n^2)
//    public static int maxSubArrayXor(int[] arr){
//        int n = arr.length;
//        int xor = 0;
//        int max = 0;
//        for(int i = 0; i < n; i++){
//            xor = 0;
//            for(int j = i; j < n; j++){
//                xor = xor ^ arr[j];
//                if(xor > max){
//                    max = xor;
//                }
//            }
//        }
//        return max;
//    }

    // Optimal
//    static class TrieNode{
//        int value;
//        TrieNode[] arr = new TrieNode[2];
//        public TrieNode(){
//            value = 0;
//            arr[0] = null;
//            arr[1] = null;
//        }
//    }
//    static TrieNode root;
}
