package ImportantQ.Arrays;

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


        //Brute Approach
//        int[][] ans = new int[n][n];
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//
//                ans[j][n-1-i] = matrix[i][j];
//
//            }
//        }

        rotateMatrix(matrix,n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

               System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }




    }
}
