package ImportantQ.BinarySearch;
import java.util.*;
//Given a matrix of integers A of size N x M in which each row is sorted.
//
//Find and return the overall median of the matrix A.
// https://www.interviewbit.com/problems/matrix-median/
public class matrixMedian {

    public static int getCount(int[] arr, int mid){ // Binary Search -> Returns Number of elements less tha equal to mid.
        int l = 0; int h = arr.length - 1;

        while(l <= h){
            int m = (l+h) >> 1;
            if(arr[m] <= mid)
                l = m + 1;
            else
                h = m - 1;
        }
        return l;
    }
    // r*c will always be odd, number of elements in matrix is always odd
    // T->O(32 * r * log(c) ), 32 because max value can go upto 10^9 which is == 2^32
    public static int findMedian(int[][] arr, int r, int c){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++){
            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][c - 1]);
        }
        // Our Search space will lie between minimum and maximum values present in the matrix

        while(min <= max){ // Binary Search
            int mid = (min+max) >> 1;
            int count = 0;

            for(int[] i : arr)
                count += getCount(i, mid);// returns number of number less than equal to mid..

            if(count <= (r*c / 2))
                min = mid + 1;
            else
                max = mid - 1;
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {{3,4,5},{2,9,10},{4,10,13}};

        int median = findMedian(arr,3,3);

        System.out.println(median);
    }
}
