package ImportantQ.BinarySearch;
import java.util.*;

public class matrixMedian {

    public static int getCount(int[] arr, int mid){ // Binary Search -> Returns Number of elements less tha equal to mid.
        int l = 0; int h = arr.length - 1;

        while(l <= h){
            int m = (l+h)>>1;
            if(arr[m] <= mid)
                l = m + 1;
            else
                h = m -1;
        }
        return l;
    }

    public static int findMedian(int[][] arr, int r, int c){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < r; i++){
            if(arr[i][0] < min)
                min = arr[i][0];

            if(arr[i][c - 1] > max)
                max = arr[i][c - 1];
        }

        while(min <= max){ // Binary Search
            int mid = (min+max)>>1;
            int count = 0;
            for(int i = 0; i < r; i++)
                count += getCount(arr[i], mid); // returns number of number less than equal to mid..

            if(count <= (r*c/2)){
                min = mid + 1;
            }else{
                max = mid-1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {{3,4,5},{2,9,10},{4,10,13}};

        int median = findMedian(arr,3,3);

        System.out.println(median);
    }
}
