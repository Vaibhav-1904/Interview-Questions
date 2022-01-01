package ImportantQ.Arrays.TwoDArrays;
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
// You are given a row-column wise sorted Matrix, you need to find Kth Smallest Element in that Matrix
// mat[][] =     {{16, 28, 60, 64},
//                   {22, 41, 63, 91},
//                   {27, 50, 87, 93},
//                   {36, 78, 87, 94 }}
//K = 3
//Output: 27
public class KthSmallestElement {

    public static int kthSmallestElement(int[][] arr, int k){
        int r = arr.length;
        int low  = arr[0][0];
        int high = arr[r - 1][r - 1];

        while(low <= high){
            int mid = (low + high) / 2;

            int count = 0;
            for(int[] i: arr)
                count += getCount(i, mid); // log(n)


            if(count < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static int getCount(int[] arr, int mid){ // Returns Number of elements less tha equal to mid.
        int low = 0; int high = arr.length - 1;

        while(low <= high){
            int m = (low + high) / 2;
            if(arr[m] > mid){
                high = m - 1;
            }else{
                low = m + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 8},{5, 9, 11},{7, 16, 20}};
        int k = 5;

        System.out.println("Kth Smallest Element is : " + kthSmallestElement(arr, k));
    }
}
