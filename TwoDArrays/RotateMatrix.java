package ImportantQ.TwoDArrays;
//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise)
public class RotateMatrix {

    static void rotateMatrix(int[][] arr,int n){
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] = temp;
            }
        }

    }

    public static void main(String[] args){

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int n= matrix.length;


//        //Brute Approach
//        int r = matrix.length;
//        int c = matrix[0].length;
//
//        int[][] arr = new int[r][c];
//
//        for(int i = 0; i < r; i++){
//            for(int j = 0; j < c; j++){
//                arr[i][j] = matrix[c - j - 1][i];
//            }
//        }


        rotateMatrix(matrix,n);

        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
