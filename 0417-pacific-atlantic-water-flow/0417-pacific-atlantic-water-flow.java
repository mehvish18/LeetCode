class Solution {
    int m,n;
    boolean atlantic, pacific;
    public void dfs(int i, int j, int[][] heights, Map<String, Boolean> visited){
        if(i<0 || i>=m || j<0 || j>=n || (atlantic & pacific))
            return;
        if(i-1<0 || j-1<0)
            pacific =true;
        if(j+1>=n || i+1>=m)
            atlantic = true;
        visited.put(i+" "+j,true);
        //System.out.println("i:"+i +" j:"+j);
        if((j-1)>=0){
            if(heights[i][j-1]<=heights[i][j] & visited.get(i+" "+(j-1))==null){
                dfs(i, j-1, heights,visited);
            }
        }
        if((i+1)<m){
            if(heights[i+1][j]<=heights[i][j] & visited.get((i+1)+" "+j)==null){
                dfs(i+1, j, heights,visited);
            }
        }
        if((j+1)<n){ 
            if(heights[i][j+1]<=heights[i][j] & visited.get(i+" "+(j+1))==null){
                dfs(i, j+1, heights,visited);
            }
        }
        if((i-1)>=0){
            if(heights[i-1][j]<=heights[i][j] & visited.get((i-1)+" "+j)==null){
                dfs(i-1, j, heights,visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                Map<String, Boolean> visited = new HashMap<>();
                atlantic = false;
                pacific = false;
                dfs(i,j,heights, visited);
                if(atlantic & pacific){  
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    ans.add(coord);
                }   
            }
        }
        return ans;
    }
}