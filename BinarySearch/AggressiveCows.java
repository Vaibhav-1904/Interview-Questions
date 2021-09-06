package ImportantQ.BinarySearch;
// Given an array of stalls where cow can come,
//  The stalls are located along a straight line at positions x1,...,xN
//  assign the cows to the stalls, such that the minimum distance between
//  any two of them is as large as possible. What is the largest minimum distance?
// arr.length = n >=2 and 2<= cows <=n

import java.util.Arrays;
public class AggressiveCows {

    public static boolean canPlace(int[] arr, int cows, int d){

        int n = arr.length;
        int position = arr[0];
        int count = 1;

        for(int i = 1; i < n; i++){
            if((arr[i] - position) >= d){
                count++;
                position = arr[i] - position;
            }
            if(count == cows)
                return true;
        }
        return false;
    }

    public static int minDistance(int[] arr, int cows){

        Arrays.sort(arr);

        int low = 1; // Minimum distance between any 2 cows
        int high = arr[arr.length - 1] - 1;
        while (low <= high){
            int distance = (low + high) / 2;
            if(canPlace(arr, cows, distance))
                low = distance + 1;
            else
                high = distance - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 5, 6, 7, 15, 18};
        int cows = 3;

        System.out.println("Minimum Distance between Cows is : " + minDistance(arr, cows));
    }

}
