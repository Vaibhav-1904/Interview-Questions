package ImportantQ.BinarySearch;
import ImportantQ.BinarySearch.binarySearch;

public class InfiniteSearch {

    public static int binarySearch(int[] arr, int l,int r,int target){

        int mid = (l+r)/2;

        if(target == arr[mid])
            return target;
        else if(target < arr[mid])
            return binarySearch(arr,l,mid,target);
        else if(target > arr[mid] && l != r)
            return binarySearch(arr,mid+1,r,target);

        return -1;
    }

    public static int searchInfinite(int[] arr, int key){

        int low = 0;
        int high = 1;
        while(arr[high] < key){
            low  = high;
            high = high * 2;
        }

        return binarySearch(arr, low, high, key);
    }
    public static void main(String[] args) {
        
    }
}
