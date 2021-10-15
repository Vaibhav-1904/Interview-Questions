package ImportantQ.BinarySearch;

public class BinarySearch {

    public static int binarySearch(int[] arr, int l, int r, int target){

        int mid = (l + r) / 2;

        if(target == arr[mid])
            return target;
        else if(target < arr[mid])
            return binarySearch(arr, l, mid, target);
        else if(target > arr[mid] && l != r)
            return binarySearch(arr,mid + 1, r, target);

        return -1;
    }

}
