package ImportantQ.BinarySearch;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class searchRotatedArray {

    public static int rotatedBinary(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high) / 2;
            if(arr[mid] == key)
                return key;

            if(arr[mid] > arr[low]){
                //left part is Sorted.
                if(key >= arr[low] && key < arr[high])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else{
                //Right Part is Sorted
                if(key > arr[mid] && key <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

}
