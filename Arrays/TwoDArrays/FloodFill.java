package ImportantQ.Arrays.TwoDArrays;
// https://leetcode.com/problems/flood-fill/
import java.util.*;
public class FloodFill {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // boolean[][] isVisited = new boolean[image.length][image[0].length];
        if(image[sr][sc] == newColor)
            return image;
        int m = image.length;
        int n = image[0].length;
        Queue<Pair> q = new LinkedList<>();
        int color = image[sr][sc];
        q.add(new Pair(sr, sc));

        while(!q.isEmpty()){
            Pair p = q.poll();
            image[p.x][p.y] = newColor;

            if(p.x + 1 < m  && image[p.x + 1][p.y] == color)
                q.add(new Pair(p.x + 1, p.y));

            if(p.x - 1 >= 0  && image[p.x - 1][p.y] == color)
                q.add(new Pair(p.x - 1, p.y));

            if(p.y + 1 < n && image[p.x][p.y + 1] == color)
                q.add(new Pair(p.x, p.y + 1));

            if(p.y - 1 >= 0  && image[p.x][p.y - 1] == color)
                q.add(new Pair(p.x, p.y - 1));
        }
        return image;
    }
}
