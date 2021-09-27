package ImportantQ.BinarySearch;

import java.util.Arrays;

// Given arrival and departure times of all trains that reach a railway station.
// Find the minimum number of platforms required for the railway station so that no train is kept waiting.
//Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time
// can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
// At any given instance of time, same platform can not be used for both departure of a train and arrival of another
// train. In such cases, we need different platforms.
public class MinimumPlatform {

    //Optimal
    static int findPlatform(int[] arr, int[] dep, int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0;
        int p = 0, i = 0, j = 0;
        if(arr.length == 1){
            return 1;
        }
        while(i < arr.length && j < arr.length){
            if(arr[i] <= dep[j]){
                i++;
                p++;
            }else{
                j++;
                p--;
            }

            if(p > ans){
                ans = p;
            }
        }
        return ans;
    }

    //Naive
//    public static int findPlatform(int arr[], int dep[], int n)
//    {
//
//        // plat_needed indicates number of platforms
//        // needed at a time
//        int plat_needed = 1, result = 1;
//        int i = 1, j = 0;
//
//        // run a nested  loop to find overlap
//        for (i = 0; i < n; i++) {
//            // minimum platform
//            plat_needed = 1;
//
//            for (j = i + 1; j < n; j++) {
//                // check for overlap
//                if ((arr[i] >= arr[j] && arr[i] <= dep[j])
//                        || (arr[j] >= arr[i]
//                        && arr[j] <= dep[i]))
//                    plat_needed++;
//            }
//
//            // update result
//            result = Math.max(result, plat_needed);
//        }
//
//        return result;
//    }
}
