package ImportantQ.TwoDArrays;

import java.util.Arrays;
//https://leetcode.com/problems/unique-paths/
//A robot is located in the top-left corner of  m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the
// bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
public class GridUniquePath {
//    //BruteForce -> recursive
//    // (m - 1,n - 1) are the target coordinates
//    public static int countPaths1(int i, int j, int m, int n){
//
//        if(i == m || j == n)
//            return 0;
//        else if(i == m-1 && j == n-1)
//            return 1;
//        else
//            return countPaths1(i+1, j, m, n) + countPaths1(i, j+1, m, n);
//    }

    ///Better Approach in which recursive calls are stored in an array
//    public static int countPaths2(int i, int j, int m, int n){
//
//        // Create a 2D table to store results
//        // of subProblems, Dynamic Programming
//        int[][] count = new int[m][n];
//        for(int[] a:count)
//            Arrays.fill(a,-1);
//
//        if(i == m || j == n)
//            return 0;
//        if(i == m - 1 && j == n - 1)
//            return 1;
//
//        if(count[i][j] != -1)
//            return count[i][j];
//        else
//            return count[i][j] = countPaths2(i + 1, j, m, n) + countPaths2(i, j + 1, m, n);

//    }

    //Optimal
    public static int countPaths3(int m, int n){
        // We observe that certain numbers of Rights and Downs are fixed in all unique Paths
        // In every Unique paths, there are n-1 rights and m-1 downs
        // So we need to find Total number of combinations that exits between right and Down

        int totalSteps = m + n - 2;
        int totalRights = n - 1;
        double ans = 1;

        for(int i = 1; i <= totalRights; i++){
            ans = ans * (totalSteps - totalRights + i) / i;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        int[][] a = new int[3][7];
        for (int[] ints : a) {
            Arrays.fill(ints, 0);
        }

        int count = countPaths3( 3, 7);
        System.out.println("Count is : " + count);
    }
}
