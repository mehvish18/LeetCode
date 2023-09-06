class Solution {
    int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int n=0,m=0;
    public void dfs(char[][] grid ,int i, int j){
        //System.out.println(i+" "+j);
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        for(int k=0;k<4;k++){
           int x = i + dir[k][0];
           int y = j + dir[k][1];
           dfs(grid,x,y) ;
        }
        
    }
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int c = 0 ;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;
    }
}