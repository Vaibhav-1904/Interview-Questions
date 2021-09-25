package ImportantQ.Graph;
import java.util.*;
// https://leetcode.com/problems/snakes-and-ladders/submissions/
public class SnakeLadder {
    // T = O(N) as every cell is added and removed only once from queue
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Map<Integer, Integer> level = new HashMap<>(); // To Store point-vertex-> mapping to number of moves done till that point
        level.put(1, 0);// if someone is at 1(origin), he has travelled 0 moves
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        //
        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int i = vertex+1; i <= vertex+6; i++) { // if i=14 for n=6
                int row = (i - 1) / n; // row = 2, 0 based indexing
                int col = (i - 1) % n; // col = 1

                if (row % 2 == 1)  // When row is odd, numbers on board are in reverse order
                    col = n - 1 - col;

                int newVal = i;
                // in board matrix, values are stored upside down, therefore n- 1 - r
                if (board[n - 1 - row][col] > 0) { // If there is a snake or ladder
                    newVal = board[n - 1 - row][col];
                }

                if (newVal == n*n) { // If we have reached our final destination.
                    return level.get(vertex) + 1;
                }

                if (level.get(newVal) == null) { // if it has not been visited previously
                    level.put(newVal, level.get(vertex) + 1);
                    queue.add(newVal);
                }
            }
        }
        return -1;
    }
}
