package ImportantQ.Graph;
import java.util.*;
// https://leetcode.com/problems/rotting-oranges/
public class RottenOranges {
    // Optimal
    static class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != 0)
                    total++;
                if(grid[i][j] == 2)
                    q.add(new Pair(i,j));
            }
        }

        int time = 0;
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            count += size;

            for(int i = 0; i < size; i++){
                Pair current = q.poll();
                int x = current.i;
                int y = current.j;
                // Down
                if(x + 1 < r && grid[x+1][y] == 1){
                    q.add(new Pair(x + 1, y));
                    grid[x + 1][y] = 2;
                }
                // Up
                if(x - 1 >= 0 && grid[x - 1][y] == 1){
                    q.add(new Pair(x - 1, y));
                    grid[x - 1][y] = 2;
                }
                // Right
                if(y + 1 < c && grid[x][y + 1] == 1){
                    q.add(new Pair(x, y + 1));
                    grid[x][y + 1] = 2;
                }
                // Left
                if(y - 1 >= 0 && grid[x][y - 1] == 1){
                    q.add(new Pair(x, y - 1));
                    grid[x][y - 1] = 2;
                }
            }
            if(!q.isEmpty())
                time++;
        }
        if(count != total)
            return -1;
        else
            return time;
    }

//    // Striver
//    public int orangesRotting(int[][] grid) {
//        if(grid == null || grid.length == 0)
//            return 0;
//        int rows = grid.length;
//        int cols = grid[0].length;
//        Queue<int[]> queue = new LinkedList<>();
//        int total = 0;
//        //Put the position of all rotten oranges in queue
//        //count the number of fresh oranges
//        for(int i = 0 ; i < rows ; i++) {
//            for(int j = 0 ; j < cols ; j++) {
//                if(grid[i][j] == 2) {
//                    queue.offer(new int[]{i , j});
//                }
//                if(grid[i][j] != 0) {
//                    total++;
//                }
//            }
//        }
//
//        if(total == 0)
//            return 0;
//
//        int time = 0, count = 0;
//        int[] dx = {0, 0, 1, -1};
//        int[] dy = {1, -1, 0, 0};
//
//        //bfs starting from initially rotten oranges
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            count += size;
//            for(int i = 0 ; i < size ; i++) {
//                int[] point = queue.poll();
//
//                for(int j = 0;j < 4; j++) {
//                    int x = point[0] + dx[j];
//                    int y = point[1] + dy[j];
//                    // If it is not a fresh orange -1-
//                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)
//                        continue;
//
//                    grid[x][y] = 2;
//                    queue.offer(new int[]{x , y});
//                }
//            }
//            if(queue.size() != 0) {
//                time++;
//            }
//        }
//        return total == count ? time : -1;
//    }
}
