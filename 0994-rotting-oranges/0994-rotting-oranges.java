class Solution {
    boolean [][] visited;
    int m,n;
    int min=0;
    int fcount = 0;
    int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    Map<Integer,List<Integer>> lvlsx = new HashMap<>();
    Map<Integer,List<Integer>> lvlsy = new HashMap<>();
    public void bfs(int[][] grid, int i, int j,int lvl){
        //System.out.println(i+" "+j+" "+lvl);
        visited[i][j]=true;
            for(int k=0;k<4;k++){
                int x = dir[k][0]+i;
                int y = dir[k][1]+j;
                if(x>=0 & x<m & y>=0 & y<n){
                    if(grid[x][y]==1 & !visited[x][y]){
                        fcount--;
                         //System.out.println(fcount);
                        grid[x][y] = 2;
                        List<Integer> lx = lvlsx.getOrDefault(lvl+1,new ArrayList<Integer>());
                        lx.add(x);
                        List<Integer> ly = lvlsy.getOrDefault(lvl+1,new ArrayList<Integer>());
                        ly.add(y);
                        lvlsx.put(lvl+1,lx);
                        lvlsy.put(lvl+1,ly);
                    }
                }
            }
    }
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int k=0;
        visited = new boolean[m][n];
        lvlsx.put(0,new ArrayList<Integer>());
        lvlsy.put(0,new ArrayList<Integer>());
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    fcount++;
                if(grid[i][j]==2){
                    lvlsx.get(0).add(i);
                    lvlsy.get(0).add(j);
                }
            }
        }
        int i=0;
        while(lvlsx.size()>0){
            for(int j=0;j<lvlsx.get(i).size();j++){
                bfs(grid,lvlsx.get(i).get(j),lvlsy.get(i).get(j),i);
            }
            lvlsx.remove(i);
            lvlsy.remove(i);
            i++;
        }
        /*for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //System.out.println(fcount);
                if(!visited[i][j] & grid[i][j]==2){
                    min++;
                    bfs(grid,i,j);
                    //min = Math.max(minVal[lx][ly],min);
                }
            }
        }*/
        if(fcount==0)
            return i-1;
        else return -1;
    }
}