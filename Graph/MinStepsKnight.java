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
    public int minStepToReachTarget(int[] KnightPos, int[] TargetPos, int N) {
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
        q.add(new Pos(x1 - 1, y1 - 1));

        while(!q.isEmpty()){
            Pos p = q.poll();
            int x = p.i;
            int y = p.j;

            if(x+1 < N && y+2 < N && visited[x+1][y+2] == 0){
                visited[x+1][y+2] = visited[x][y] + 1;
                q.add(new Pos(x+1, y+2));
            }
            if(x+1 < N && y-2 >= 0 && visited[x+1][y-2] == 0){
                visited[x+1][y-2] = visited[x][y] + 1;
                q.add(new Pos(x+1, y-2));
            }
            if(x-1 >= 0 && y+2 < N && visited[x-1][y+2] == 0){
                visited[x-1][y+2] = visited[x][y] + 1;
                q.add(new Pos(x-1, y+2));
            }
            if(x-1 >= 0 && y-2 >= 0 && visited[x-1][y-2] == 0){
                visited[x-1][y-2] = visited[x][y] + 1;
                q.add(new Pos(x-1, y-2));
            }

            if(x+2 < N && y+1 < N && visited[x+2][y+1] == 0){
                visited[x+2][y+1] = visited[x][y] + 1;
                q.add(new Pos(x+2, y+1));
            }
            if(x+2 < N && y-1 >= 0 && visited[x+2][y-1] == 0){
                visited[x+2][y-1] = visited[x][y] + 1;
                q.add(new Pos(x+2, y-1));
            }
            if(x-2 >= 0 && y+1 < N && visited[x-2][y+1] == 0){
                visited[x-2][y+1] = visited[x][y] + 1;
                q.add(new Pos(x-2, y+1));
            }
            if(x-2 >= 0 && y-1 >= 0 && visited[x-2][y-1] == 0){
                visited[x-2][y-1] = visited[x][y] + 1;
                q.add(new Pos(x-2, y-1));
            }
        }
        return visited[x2-1][y2-1];
    }
}
