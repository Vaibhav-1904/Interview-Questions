package ImportantQ.Graph;
import java.util.*;
// https://www.youtube.com/watch?v=ce4vjUVfrhU
public class MinStepsKnight {
    static class Pos{
        int i;
        int j;
        Pos(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    // T = O(N^2)  S = O(N^2)
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N)
    {
        // Code here
        Queue<Pos> q = new LinkedList<>();
        int x1 = KnightPos[0];
        int y1 = KnightPos[1];
        int x2 = TargetPos[0];
        int y2 = TargetPos[1];

        if(x1 == x2 && y1 == y2)
            return 0;

        int[][] visited = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                visited[i][j] = 0;
            }
        }
        q.add(new Pos(x1-1, y1-1));

        while(!q.isEmpty()){
            Pos p = q.poll();
            int i = p.i;
            int j = p.j;

            if(i+1 >= 0 && i+1 < N && j+2 >= 0 && j+2 < N && visited[i+1][j+2] == 0){
                visited[i+1][j+2] = visited[i][j] + 1;
                q.add(new Pos(i+1, j+2));
            }
            if(i+1 >= 0 && i+1 < N && j-2 >= 0 && j-2 < N && visited[i+1][j-2] == 0){
                visited[i+1][j-2] = visited[i][j] + 1;
                q.add(new Pos(i+1, j-2));
            }
            if(i-1 >= 0 && i-1 < N && j+2 >= 0 && j+2 < N && visited[i-1][j+2] == 0){
                visited[i-1][j+2] = visited[i][j] + 1;
                q.add(new Pos(i-1, j+2));
            }
            if(i-1 >= 0 && i-1 < N && j-2 >= 0 && j-2 < N && visited[i-1][j-2] == 0){
                visited[i-1][j-2] = visited[i][j] + 1;
                q.add(new Pos(i-1, j-2));
            }

            if(i+2 >= 0 && i+2 < N && j+1 >= 0 && j+1 < N && visited[i+2][j+1] == 0){
                visited[i+2][j+1] = visited[i][j] + 1;
                q.add(new Pos(i+2, j+1));
            }
            if(i+2 >= 0 && i+2 < N && j-1 >= 0 && j-1 < N && visited[i+2][j-1] == 0){
                visited[i+2][j-1] = visited[i][j] + 1;
                q.add(new Pos(i+2, j-1));
            }
            if(i-2 >= 0 && i-2 < N && j+1 >= 0 && j+1 < N && visited[i-2][j+1] == 0){
                visited[i-2][j+1] = visited[i][j] + 1;
                q.add(new Pos(i-2, j+1));
            }
            if(i-2 >= 0 && i-2 < N && j-1 >= 0 && j-1 < N && visited[i-2][j-1] == 0){
                visited[i-2][j-1] = visited[i][j] + 1;
                q.add(new Pos(i-2, j-1));
            }
        }
        return visited[x2-1][y2-1];
    }
}
