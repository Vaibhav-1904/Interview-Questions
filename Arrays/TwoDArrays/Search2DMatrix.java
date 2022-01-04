package ImportantQ.Arrays.TwoDArrays;

import java.util.Scanner;
// https://leetcode.com/problems/search-a-2d-matrix/
//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//Integers in each row/column are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
public class Search2DMatrix {

    // Optimal Method T->O(n+m)
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0)
            return false;

        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0;
        int r = m*n - 1;

        while(l <= r){
            int mid = (l+r) >> 1;

            if(matrix[mid / m][mid % m] == target)
                return true;
            else if(matrix[mid / m][mid % m] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public static Boolean binary(int[] arr, int l,int r,int target){
        boolean found = false;
        int mid = (l+r)/2;

        if(target == arr[mid])
            found=true;
        else if(target < arr[mid] && l != r)
            found = binary(arr,l,mid,target);
        else if(target > arr[mid] && l != r)
            found = binary(arr,mid+1,r,target);

        return found;
    }

    public static void main(String[] args){
        Scanner scan  = new Scanner(System.in);

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean found = false;
        int target = 23;

        // Better Method
        for (int[] i : matrix) {
            found = binary(i, 0, i.length - 1, target);
            if(found)
                break;
        }
        System.out.println("Target Number is found " + found);
    }
}
