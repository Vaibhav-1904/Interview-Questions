package ImportantQ.Sorting;
//Inversion Count for an array indicates – how far (or close) the array is from being sorted.
// If array is already sorted then inversion count is 0. If array is sorted in reverse
// order that inversion count is the maximum.
// two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
// Find the Inversion Count
// https://www.geeksforgeeks.org/counting-inversions/
public class CountInversions {

    public static int mergeCount(int[] arr, int left, int mid, int right)
    {
        int inv_count = 0;

        // Find sizes of two subArrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */
        // Initial indexes of first and second subArrays
        int i = 0, j = 0;

        // Initial index of merged subArray array
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
                inv_count += (mid + 1) - (left + i);// if L[i] > R[j], then all elements on right of L[i] must be greater than R[j]
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
            arr[k++] = L[i++];

        /* Copy remaining elements of R[] if any */
        while (j < n2)
            arr[k++] = R[j++];

        return inv_count;
    }

    // Optimal Approach T->O(nlogn)
    public static int MergesortCount(int[] arr, int l, int r)
    {
        int inv_count = 0;
        if (l < r) {
            // Find the middle point
            int m = (l + r) >> 1;
            inv_count += MergesortCount(arr, l, m);
            inv_count += MergesortCount(arr, m + 1, r);
            inv_count += mergeCount(arr, l, m, r);
        }
        return inv_count;
    }

    public static void main(String[] args){

        //Brute Approach
        int count = 0;
        int[] arr = {2, 4, 1, 3, 5};
//        for(int i = 0; i < arr.length-1; i++){
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[i] > arr[j]){
//                    count++;
//                }
//            }
//        }

        System.out.println("Count is : " + MergesortCount(arr,0,arr.length - 1));
    }
}