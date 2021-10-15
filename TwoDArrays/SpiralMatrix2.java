package ImportantQ.TwoDArrays;
// https://leetcode.com/problems/spiral-matrix-ii/
// Given an Integer N, you need to return NxN matrix in a spiral form matrix
// Eg - for n = 3
//[1  2  3]
//[8  9  4]
//[7  6  5]
public class SpiralMatrix2 {

    public static int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;

        int count = 1;
        while(rowStart <= rowEnd && colStart <= colEnd){

            for(int i = colStart; i <= colEnd; i++){
                ans[rowStart][i] = count;
                count++;
            }
            rowStart++;

            for(int i = rowStart; i <= rowEnd; i++){
                ans[i][colEnd] = count;
                count++;
            }
            colEnd--;

            for(int i = colEnd; i >= colStart; i--){
                ans[rowEnd][i] = count;
                count++;
            }
            rowEnd--;

            for(int i = rowEnd; i >= rowStart; i--){
                ans[i][colStart] = count;
                count++;
            }
            colStart++;
        }

        // For ArrayList<ArrayList<Integer>> return, create new and add elements using 2 for-looops

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
}
