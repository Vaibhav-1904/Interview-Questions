package ImportantQ.RecursionBacktracking;
// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
// Find all possible paths that the rat can take to reach from source to destination. The directions in which
// the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents
// that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
//Note: In a path, no cell can be visited more than one time.
// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
import java.util.ArrayList;
public class RatMaze {
    // T -> O(3^(n^2))
    // S -> O(3^(n^2))
    public static void findPath(int row, int col, int[][] maze, int n, ArrayList<String> result, boolean[][] isVisited, String path){
        if(row == n - 1 && col == n - 1){
            result.add(path);
            return;
        }

        //Down
        if(row + 1 < n && maze[row + 1][col] != 0 && !isVisited[row + 1][col]){
            isVisited[row][col] = true;
            findPath(row + 1, col, maze, n, result, isVisited, path + "D");
            isVisited[row][col] = false;
        }

        //Left
        if(col - 1 >= 0 && maze[row][col-1] != 0 && !isVisited[row][col-1]){
            isVisited[row][col] = true;
            findPath(row, col - 1, maze, n, result, isVisited, path + "L");
            isVisited[row][col] = false;
        }

        //Right
        if(col + 1 < n && maze[row][col+1] != 0 && !isVisited[row][col+1]){
            isVisited[row][col] = true;
            findPath(row, col + 1, maze, n, result, isVisited, path + "R");
            isVisited[row][col] = false;
        }

        //Up
        if(row - 1 >= 0 && maze[row-1][col] != 0 && !isVisited[row-1][col]){
            isVisited[row][col] = true;
            findPath(row - 1, col, maze, n, result, isVisited, path + "U");
            isVisited[row][col] = false;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int n = m.length;
        boolean[][] isVisited = new boolean[n][n];
        ArrayList<String> result = new ArrayList<>();
        if(m[0][0] != 0){
            findPath(0, 0, m, n, result, isVisited, "");
        }

        if(result.size() == 0){
            result.add("-1");
        }

        System.out.println(result);
    }
}
