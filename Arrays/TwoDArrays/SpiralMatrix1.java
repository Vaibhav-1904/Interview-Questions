package ImportantQ.Arrays.TwoDArrays;
import java.util.ArrayList;
// https://leetcode.com/problems/spiral-matrix/
// Given an m x n matrix, return all elements of the matrix in spiral order.
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
public class SpiralMatrix1 {
    public ArrayList<Integer> spiralOrder(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        if(r == 0 || c == 0){
            return ans;
        }

        int rowStart = 0;
        int rowEnd = r - 1;
        int colStart = 0;
        int colEnd = c - 1;

        while(rowStart <= rowEnd && colStart <= colEnd){

            for(int i = colStart; i <= colEnd; i++){
                ans.add(arr[rowStart][i]);
            }
            rowStart++;
            if(rowStart > rowEnd)
                break;

            for(int i = rowStart; i <= rowEnd; i++){
                ans.add(arr[i][colEnd]);
            }
            colEnd--;
            if(colStart > colEnd)
                break;

            for(int i = colEnd; i >= colStart; i--){
                ans.add(arr[rowEnd][i]);
            }
            rowEnd--;
            if(rowStart > rowEnd)
                break;

            for(int i = rowEnd; i >= rowStart; i--){
                ans.add(arr[i][colStart]);
            }
            colStart++;
        }
        return ans;
    }
}
