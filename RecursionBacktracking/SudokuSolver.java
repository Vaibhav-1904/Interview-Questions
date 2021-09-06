package ImportantQ.RecursionBacktracking;
// Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//T -> O(n^4)
public class SudokuSolver {

    public static boolean validate(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c)
                return false; //check rows
            if(board[row][i] != '.' && board[row][i] == c)
                return false; //check columns
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false; //check 3*3 block
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board){

        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board.length; col++){
                if(board[row][col] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(validate(board, row, col, c)){
                            board[row][col] = c;

                            if(solveSudoku(board)){
                                return true;
                            }else{
                                board[row][col] = '.'; // BackTrack if a value is not making a Sudoku,
                                                   // If every digit from 1 to 9 does not satisfy the condition.
                            }
                        }
                    }
                    return false; // If none of the digits from 1 to 9 able to fill
                                  // up the empty space then return false
                }
            }
        }
        return true; // If board is full
    }

    public static void main(String[] args) {
        char[][] board = new char[9][9];
        solveSudoku(board);
    }
}
