package ImportantQ.BinarySearch;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class searchRotatedArray {

    public int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int mid = (l + r) >> 1;

            if(arr[mid] == target)
                return mid;

            if(arr[l] <= arr[mid]){
                if(target >= arr[l] && target < arr[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }else{
                if(target > arr[mid] && target <= arr[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
