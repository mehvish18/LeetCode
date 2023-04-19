class Solution {
    int m,n;
    int[][] visited;
    int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public void bfs(char[][] grid, int i, int j){
        visited[i][j]=1;
        Queue<int[]> q = new LinkedList<>();
        int [] cord = {i,j};
        q.add(cord);
        while(q.size()>0){
            int [] pos = q.poll();
            for(int[] d:dir){
                int x = pos[0]+d[0];
                int y = pos[1]+d[1];
                if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==0 && grid[x][y]=='1'){
                        int[] cords={x,y};
                        q.add(cords);
                        visited[x][y]=1;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int c=0;
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){ 
                    bfs(grid,i,j);
                    c++;  
                }
            }
        
        }

        return c;
    }
}