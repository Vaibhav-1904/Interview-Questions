package ImportantQ.Arrays;
//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

public class NextPermutation {
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int[] arr,int i,int j){
        while(i < j)
            swap(arr,i++,j--);
    }

    public static void nextPermutation(int[] arr) {
        if(arr == null || arr.length <= 1)
            return;

        int i = arr.length-2;
        while( i >= 0 && arr[i] >= arr[i+1] )
            i--;

        if(i>=0){
            int j = arr.length-1;
            while(arr[j] <= arr[i])
                j--;
            swap(arr,i,j);
        }
        reverse(arr,i+1,arr.length-1);
    }
}
