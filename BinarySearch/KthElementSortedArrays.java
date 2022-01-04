package ImportantQ.BinarySearch;
//Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. 
//The task is to find the element that would be at the k’th position of the final sorted array.
// https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
// https://www.youtube.com/watch?v=nv7F4PiLUzo&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=67
public class KthElementSortedArrays{

    // // Brute Force T-> O(n + m)
    // public static int KthElement(int[] arr1, int[] arr2, int k){

    //     int n = arr1.length; int m = arr2.length;
    //     int counter = 0;

    //     int i = 0, j = 0;
        
    //     while(i < n && j < m){
    //         if(arr1[i] <= arr2[j]){
    //             counter = arr1[i];
    //             k--;
    //             i++;
    //         }else{
    //             counter = arr2[j];
    //             k--;
    //             j++;
    //         }

    //         if(k == 0){
    //             return counter;
    //         }
    //     }
    //     while(i < n){
    //         counter = arr1[i];
    //         i++;
    //         k--;
    //         if(k == 0){
    //             return counter;
    //         }
    //     }
    //     while(j < m){
    //         counter = arr2[j];
    //         k--;
    //         j++;
    //         if(k == 0){
    //             return counter;
    //         }
    //     }

    //     return -1;
    // }

    // Optimal
    public static int KthElement(int[] arr1, int[] arr2, int k){

        if(arr1.length > arr2.length)
            return KthElement(arr2, arr1, k);

        int low = 0;
        int high = arr1.length; // max elements which can be picked

        while(low <= high){
            int cut1 = (low + high) / 2; //  partitioning arr1 into left array and right array
            int cut2 = k - cut1; //  partitioning arr2 into left array and right array, remaining elements after taking some elements from arr1

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right1 = (cut1 == k) ? Integer.MAX_VALUE : arr1[cut1];
            int right2 = (cut2 == k) ? Integer.MAX_VALUE : arr2[cut2];

            if(left1 <= right2 && left2 <= right1){
                return Math.max(left1, left2);
            }else{
                if(left1 > right2)
                    high = cut1 - 1;
                else
                    low = cut1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr1 = {1,4,6,7,8,11,12,45};
        int[] arr2 = {5,8,9,10};
        
        System.out.println("Kth Element is : " + KthElement(arr1, arr2, 5));
        
    }
}