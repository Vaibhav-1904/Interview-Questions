package ImportantQ.Arrays;

public class SortColor {

    // First Sorting the Array -> Nlogn
    // Second Approach is count the no. of 0s, 1s, 2s and the assign it to the array accordingly.

    //Optimal
    public void sortColors(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        int temp;

        while(mid <= high){
            if(arr[mid] == 0){
                // switch elements at low and mid and increment low and mid
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                //if element is 2, switch mid and high
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

}
