package ImportantQ.Arrays;
//Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
// Merge them in sorted order without using any extra space. Modify arr1 so that it
// contains the first N elements and modify arr2 so that it contains the last M elements.
// https://leetcode.com/problems/merge-sorted-array/
public class MergeSortedArrays {

    //Brute
    public static long[] merge(long[] arr1, long[] arr2, int n, int m) {
        long[] temp = new long[n+m];
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while(p1 < n && p2 < m){
            if(arr1[p1] <= arr2[p2]){
                temp[i++] = arr1[p1++];
            }else{
                temp[i++] = arr2[p2++];
            }
        }
        while(p1 < n){
            temp[i] = arr1[p1];
            p1++;
            i++;
        }
        while(p2 < m){
            temp[i] = arr2[p2];
            p2++;
            i++;
        }
        return temp;
    }

//    //Better Approach T-> O(n*m)
//    public static void merge(long[] arr1, long[] arr2, int n, int m){
//
//        int i = 0, j = 0;
//        while(i < n && j < m){
//            j = 0;
//            if(arr1[i] <= arr2[j])
//            {
//                i++;
//            }
//            else{
//                long temp = arr1[i];
//                arr1[i] = arr2[j];
//                arr2[j] = temp;
//                // After swapping, the arr2 might not be in sorted form, so we sort it using Insertion sort
//                for(j = 1; j < arr2.length; j++) { // Insertion Sort
//                    if(arr2[j] < arr2[j - 1]){
//                        temp = arr2[j];
//                        arr2[j] = arr2[j - 1];
//                        arr2[j - 1] = temp;
//                    }
//                }
//            }
//        }
//    }


    public static int nextGap(int gap){
        if(gap <= 1)
            return 0;
        else
            return gap/2 + gap % 2;
    }

    //Optimal method  T->O(LogN*N) N = n+m
    public void mergeSortedArrays(int[] arr1, int[] arr2) {
        int gap = arr1.length + arr2.length;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            int i;
            int j;
            //Comparing elements in First array
            for(i = 0; i + gap < arr1.length; i++){

                if(arr1[i] > arr1[i + gap]){
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[gap + i] = temp;
                }
            }

            //Comparing elements in both arrays
            for(j = 0; j < arr2.length && i < arr1.length; j++){
                if(arr1[i] > arr2[j]){
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
                i++;
            }

            //Comparing elements in Second array
            for(int k = 0; j < arr2.length; k++){
                if(arr2[k] > arr2[j]){
                    int temp = arr1[k];
                    arr1[k] = arr1[j];
                    arr1[j] = temp;
                }
                j++;
            }
        }
    }

    // T->On+m) Leetcode
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--; n--;

        while(m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]){
                nums1[index--] = nums1[m--];
            }
            else{
                nums1[index--] = nums2[n--];
            }
        }
        while(n >= 0){
            nums1[index--] = nums2[n--];
        }
    }

    public static void main(String[] args){

        int[] arr1 = {10 ,27 ,38 , 43, 82};
        int[] arr2 = {2, 3, 8, 9, 50, 100};



        for(long e:arr1){
            System.out.print(e + " ");
        }
        System.out.println();
        for(long e:arr2){
            System.out.print(e + " ");
        }
    }
}
