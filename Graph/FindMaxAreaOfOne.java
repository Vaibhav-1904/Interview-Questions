package ImportantQ.Graph;
// https://leetcode.com/problems/max-area-of-island/

public class FindMaxAreaOfOne {
    public int findMaxArea(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        int max = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    count = dfs(i, j, grid, visited);

                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    int dfs(int i, int j, int[][] grid, boolean[][] visited){
        int count = 0;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return 0;

        visited[i][j] = true;

        count += dfs(i+1, j, grid, visited);
        count += dfs(i-1, j, grid, visited);
        count += dfs(i, j+1, grid, visited);
        count += dfs(i, j-1, grid, visited);

        // 8 Direction
        count += dfs(i-1, j-1, grid, visited);
        count += dfs(i+1, j+1, grid, visited);
        count += dfs(i-1, j+1, grid, visited);
        count += dfs(i+1, j-1, grid, visited);

        return 1+count;
    }
}
