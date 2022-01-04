package ImportantQ.Arrays.TwoDArrays;
// https://leetcode.com/problems/01-matrix/
public class Matrix {
    public int[][] updateMatrix(int[][] mat) {

        int r = mat.length;
        int c = mat[0].length;

        int[][] result = new int[r][c];

        int maxPossible = r + c;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(mat[i][j] == 0)
                    continue;

                result[i][j] = maxPossible;

                if(i > 0)
                    result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);

                if(j > 0)
                    result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
            }
        }
        for(int i = r-1; i >= 0; i--) {
            for(int j = c-1; j >= 0; j--) {
                if(mat[i][j] == 0)
                    continue;

                if(i < r-1)
                    result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);

                if(j < c-1)
                    result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
            }
        }
        return result;
    }
}
