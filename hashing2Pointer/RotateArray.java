package ImportantQ.hashing2Pointer;
// https://leetcode.com/problems/rotate-array/
public class RotateArray {
//    // Naive T->O(n)   S->O(n)
//    public void rotate(int[] nums, int k) {
//
//        int n = nums.length;
//        if(k > n)
//            k = k % n;
//        int[] arr = new int[n];
//
//        for(int i = 0; i < k; i++){
//            arr[i] = nums[n - k + i];
//        }
//
//        for(int i = k; i < n; i++){
//            arr[i] = nums[i - k];
//        }
//
//        for(int i = 0; i < n; i++){
//            nums[i] = arr[i];
//        }
//    }

    // Optimal
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k > n)
            k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    void reverse(int[] arr, int i, int j){

        while(i < j){
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
            i++;
            j--;
        }
    }
}
