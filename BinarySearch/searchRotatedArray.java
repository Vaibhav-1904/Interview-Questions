package ImportantQ.BinarySearch;

public class searchRotatedArray {

    public static int roatedBinary(int[] arr, int key){

        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
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
                if(key <= arr[high] && key > arr[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }


}
