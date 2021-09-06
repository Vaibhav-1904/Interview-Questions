package ImportantQ.sorting;

public class ReversePairs {
    //Optimal approach
    public static int merge(int[] arr, int l, int mid, int r){
        int rev_count = 0;
        int j = mid + 1;
        // Count elements which satisfy the condition.
        for(int i = l; i <= mid; i++){
            while(j <= r && arr[i] > arr[j] * 2L){
                j++;
            }
            rev_count += (j - (mid + 1));
        }
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for (j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, k = l;
        j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }
        while (j < n2) {
            arr[k++] = R[j++];
        }
        return rev_count;
    }

    public static int MergeSort(int[] arr, int l, int r){
        int rev_count = 0;
        if(l < r){
            int mid = (l + r)>>1;
            rev_count += MergeSort(arr, l, mid);
            rev_count += MergeSort(arr, mid + 1, r);
            rev_count += merge(arr, l, mid, r);
        }
        return rev_count;
    }

    //    //Brute-Force
//    public static int reversePairs(int[] nums) {
//        int count = 0;
//        for(int i = 0; i < nums.length -1; i++){
//            for(int j = i+1; j < nums.length; j++){
//                if(nums[i] > 2*nums[j]){
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
    public static void main(String[] args){

        int[] arr = {1,3,2,3,1};
        System.out.println("Count is : " + MergeSort(arr,0,4) );
    }
}
