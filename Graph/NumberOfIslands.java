package ImportantQ.Graph;
// https://leetcode.com/problems/number-of-islands/submissions/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int i, int j, char[][] grid, boolean[][] visited){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0')
            return;

        visited[i][j] = true;

        dfs(i+1, j, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);

        // For 8 Directions
        // dfs(i-1, j-1, grid, visited);
        // dfs(i+1, j+1, grid, visited);
        // dfs(i-1, j+1, grid, visited);
        // dfs(i+1, j-1, grid, visited);
    }
}
