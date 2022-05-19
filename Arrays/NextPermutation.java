package ImportantQ.Arrays;
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // reverses array from ith index to j
    public static void reverse(int[] arr,int i,int j){
        while(i < j)
            swap(arr, i++, j--);
    }

    public static void nextPermutation(int[] arr) {
        if(arr == null || arr.length <= 1)
            return;

        int i = arr.length - 2;
        // Traverse from back and find an element at i such that arr[i] <= arr[i+1]
        while( i >= 0 && arr[i] >= arr[i + 1] )
            i--;

        if(i >= 0){
            int j = arr.length - 1;
            // Traverse from back and find an element which is greater than arr[i]
            while(arr[j] <= arr[i])
                j--;
            swap(arr, i, j);
        }
        // reverse everything after ith position to get the ANS
        reverse(arr,i + 1,arr.length - 1);
    }
}
