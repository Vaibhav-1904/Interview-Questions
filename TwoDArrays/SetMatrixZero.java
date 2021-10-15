package ImportantQ.TwoDArrays;
// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {
    public static void main(String[] args){
        int[][] arr = {
                {1,1,1},
                {1,0,1},
                {1,1,1},
                {1,1,1}
        };;

        // Brute Force Approach
//        int count = 0;
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j < arr[i].length; j++){
//                if(arr[i][j] == 0){
//                    count++;
//                    for(int k = 0;k < arr.length; k++ ){
//                        if(arr[k][j] != 0){
//                            arr[k][j] = -1;
//                        }
//                    }
//                    for(int k = 0;k < arr[i].length; k++ ){
//                        if(arr[i][k] != 0){
//                            arr[i][k] = -1;
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i = 0; i< arr.length; i++){
//            for(int j = 0; j < arr[i].length; j++){
//                if(arr[i][j] == -1 && count != 0){
//                    arr[i][j] = 0;
//                }
//                System.out.print(arr[i][j]);
//            }
//        }



        // Better Approach
//        int[] row = new int[arr.length];
//        int[] column = new int[arr[0].length];
//        Arrays.fill(row,1);
//        Arrays.fill(column,1);
//
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j < arr[i].length; j++){
//                if(arr[i][j] == 0){
//                    row[i] = 0;
//                    column[j] = 0;
//                }
//            }
//        }
//
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j <arr[i].length; j++){
//                if(row[i] == 0 || column[j] == 0){
//                    arr[i][j] = 0;
//                }
//            }
//
//
//
//        }


        int col = 1; // True, variable used for denoting 0th column zeros
        int row = arr.length;
        int column = arr[0].length;

        for(int i = 0; i < row; i++){
            if(arr[i][0] == 0){
                col = 0;
            }
            for(int j = 1; j < column; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for(int i = row - 1; i >= 0; i--){
            for(int j = column - 1; j >= 1; j--){
                if(arr[i][0] == 0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
            if(col == 0){
                arr[i][0] = 0;
            }
        }
    }
}
