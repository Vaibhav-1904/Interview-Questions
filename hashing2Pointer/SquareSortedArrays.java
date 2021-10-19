package ImportantQ.hashing2Pointer;
// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquareSortedArrays {

    // T->O(n)   S->O(n)
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int leftsqr = 1;
        int rightsqr = 1;
        int[] arr = new int[nums.length];

        int n = nums.length - 1;
        while(left <= right){
            leftsqr = nums[left] * nums[left];
            rightsqr = nums[right] * nums[right];
            if(rightsqr > leftsqr){
                arr[n] = rightsqr;
                right--;
            }else{
                arr[n] = leftsqr;
                left++;
            }
            n--;
        }
        return arr;
    }

}
