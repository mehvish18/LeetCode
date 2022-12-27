class Solution {
    public int dfs(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0)
            return 0;
        grid[row][col] = 0; // mark as visited
        
        // there is no need to give 1 back to grid like gird[row][col] = 1
		// dont forget to add 1 before return
        return 1 + dfs(grid, row, col-1) + dfs(grid, row+1, col) + dfs(grid, row, col+1) + dfs(grid, row-1, col);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    max = Math.max(max, dfs(grid, i, j));
            }
        }
        
        return max;
    }
}