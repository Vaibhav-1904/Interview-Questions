package ImportantQ.hashing2Pointer;

import java.util.Arrays;
import java.util.HashMap;

// Given an array of n distinct elements.
// Find the minimum number of swaps required to sort the array in strictly increasing order.
public class MinSwapArraySort {
//    //Naive
//    public static int count(int[] nums){
//        int count = 0;
//        int n = nums.length;
//        for(int i = 0; i < n - 1; i++){
//            int minIndex = i;
//            for(int j = i + 1; j < n; j++){
//                if(nums[j] < nums[minIndex]){
//                    minIndex = j;
//                }
//            }
//            if(i != minIndex){
//                nums[minIndex] = nums[i] ^ nums[minIndex];
//                nums[i] = nums[i] ^ nums[minIndex];
//                nums[minIndex] = nums[i] ^ nums[minIndex];
//                count++;
//            }
//        }
//        return count;
//    }

    // Optimal
    public static void swap(int[] arr, int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static int minSwap(int[] arr){
        int n = arr.length;
        int count = 0;

        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n; i++){
            map.put(arr[i], i);
        }

        for(int i = 0; i < n; i++){
            if(arr[i] != temp[i]){ // If element is not in correct position, the set it to correct
                // position using temp array, in the main array and count++.
                count++;

                int num = arr[i]; // Not in correct position

                swap(arr, i, map.get(temp[i]));

                map.put(num, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return count;
    }
}
