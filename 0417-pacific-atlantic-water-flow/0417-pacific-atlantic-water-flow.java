class Solution {
    int [][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    int n=0,m=0;
    public boolean bfs(int[][] heights, int i, int j){
        LinkedList<int[]> q = new LinkedList<>();
        int [][] visited = new int[n][m];
        int[] src = new int[2];
        src[0]=i;
        src[1]=j;
        q.add(src);
        visited[i][j]=1;
        boolean pacific =false;
        boolean atlantic = false;
        if(i==0||j==0)
            pacific = true;
        if(i==n-1 || j==m-1)
            atlantic = true;
        if(atlantic && pacific)
            return true;
        while(q.size()>0){
            int[] pos = q.poll();
            for(int k=0;k<4;k++){
                int x = pos[0]+dir[k][0];
                int y = pos[1]+dir[k][1];
                int[] v = new int[2];
                v[0]=x;
                v[1]=y;
                if(!(x<0||y<0||x>=n||y>=m)){
                    if(visited[x][y]==0 && heights[x][y]<=heights[pos[0]][pos[1]]){
                        if(x==0||y==0)
                            pacific = true;
                        if(x==n-1 || y==m-1)
                            atlantic = true;
                        if(atlantic && pacific)
                            return true;
                        visited[x][y]=1;
                        q.add(v);
                    }
                }
                
            }
        }
        return false;
        
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        n = heights.length;
        m = heights[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(bfs(heights,i,j)){
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    ans.add(pos);
                }
            }
        }
        return ans;
        
    }
}