class Solution {
    Map<String,ArrayList<String>> adj = new HashMap<>();
    Map<String,Boolean> visited = new HashMap<>();
    int m,n;
    public void bfs(int i1, int j1, char[][] grid){
        //System.out.println("source: "+i1+" "+j1);
        visited.put(i1+" "+j1,true);
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(i1);
        q2.add(j1);
        while(!q1.isEmpty()){
            int i = q1.poll();
            int j = q2.poll();
            String s1 = (i-1)+" "+j;
            String s2 = (i+1)+" "+j;
            String s3 = i+" "+(j-1);
            String s4 = i+" "+(j+1);
            //System.out.println("s1: "+s1);
            //System.out.println("s2: "+s2);
            //System.out.println("s3: "+s3);
            //System.out.println("s4: "+s4);
            if(i-1>=0){
                if(visited.get(s1)==null && grid[i-1][j]=='1'){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i-1);
                    q2.add(j);
                    visited.put(s1,true);
                }
            }
            if(i+1<m){
                if(visited.get(s2)==null && grid[i+1][j]=='1'){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i+1);
                    q2.add(j);
                    visited.put(s2,true);
                }
            }
            if(j-1>=0){
                if(visited.get(s3)==null && grid[i][j-1]=='1'){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i);
                    q2.add(j-1);
                    visited.put(s3,true);
                }
            }
            if(j+1<n){
                if(visited.get(s4)==null && grid[i][j+1]=='1'){
                    //System.out.println(adj.get(node).get(i));
                    q1.add(i);
                    q2.add(j+1);
                    visited.put(s4,true);
                }
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        int c=0;
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited.get(i+" "+j)==null && grid[i][j]=='1'){ 
                    bfs(i,j,grid);
                    c++;  
                }
            }
        
        }

        return c;
    }
}