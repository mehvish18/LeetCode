class Solution {
    Map<String,Boolean> visited = new HashMap<>();
    int m,n;
    public int bfs(int i1, int j1, int[][] grid){
        //System.out.println("source: "+i1+" "+j1);
        visited.put(i1+" "+j1,true);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(i1);
        q2.add(j1);
        int area = 1;
        while(!q1.isEmpty()){
            int i = q1.poll();
            int j = q2.poll();
            String s1 = (i-1)+" "+j;
            String s2 = (i+1)+" "+j;
            String s3 = i+" "+(j-1);
            String s4 = i+" "+(j+1);
            if(i-1>=0){
                if(visited.get(s1)==null && grid[i-1][j]==1){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i-1);
                    q2.add(j);
                    visited.put(s1,true);
                    area++;
                }
            }
            if(i+1<m){
                if(visited.get(s2)==null && grid[i+1][j]==1){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i+1);
                    q2.add(j);
                    visited.put(s2,true);
                    area++;
                }
            }
            if(j-1>=0){
                if(visited.get(s3)==null && grid[i][j-1]==1){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i);
                    q2.add(j-1);
                    visited.put(s3,true);
                    area++;
                }
            }
            if(j+1<n){
                if(visited.get(s4)==null && grid[i][j+1]==1){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i);
                    q2.add(j+1);
                    visited.put(s4,true);
                    area++;
                }
            }
            
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int area=0;
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited.get(i+" "+j)==null && grid[i][j]==1){ 
                    area = Math.max(bfs(i,j,grid),area);
                }
            }
        
        }

        return area;
    }
}