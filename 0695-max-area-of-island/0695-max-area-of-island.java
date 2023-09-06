class Solution {
    int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int n=0,m=0;
    int c=0;
    public void dfs(int[][] grid ,int i, int j){
        //System.out.println(i+" "+j);
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0)
            return;
        c++;
        grid[i][j] = 0;
        for(int k=0;k<4;k++){
           int x = i + dir[k][0];
           int y = j + dir[k][1];
           dfs(grid,x,y) ;
        }
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int max=0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                c=0;
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                }
                max = Math.max(max,c);
            }
        }
        return max;
    }
}