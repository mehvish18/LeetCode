class Solution {
    Map<String,ArrayList<String>> adj = new HashMap<>();
    Map<String,Boolean> visited = new HashMap<>();
    
    public void bfs(String source){
        //System.out.println("source: "+source);
        visited.put(source,true);
        Queue<String> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()){
            String node = q.poll();
            for(int i=0;i<adj.get(node).size();i++){
                if(visited.get(adj.get(node).get(i))==null){
                    //System.out.println(adj.get(node).get(i));
                    q.add(adj.get(node).get(i));
                    visited.put(adj.get(node).get(i),true);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                //System.out.println(i+" "+j);
                if(grid[i][j]=='1'){
                    String s = ""+i+"*"+j;
                    if(adj.get(s)==null)
                        adj.put(s,new ArrayList<>());
                    //System.out.println("i+j: "+i+j);
                    if(i!=grid.length-1){
                        if(grid[i+1][j]=='1') {
                            String s1 = ""+(i+1)+"*"+j;
                            //System.out.println("s s1: "+ s+" "+s1);
                            ArrayList l = adj.getOrDefault(s,new ArrayList<>());
                            l.add(s1);
                            adj.put(s,l);
                            l = adj.getOrDefault(s1,new ArrayList<>());
                            l.add(s);
                            adj.put(s1,l);
                        }
                    }
                    if(j!=grid[i].length-1){
                        if(grid[i][j+1]=='1') {
                            String s1 = ""+i+"*"+(j+1);
                            //System.out.println("2nd s s1: "+ s+" "+s1);
                            ArrayList l = adj.getOrDefault(s,new ArrayList<>());
                            l.add(s1);
                            adj.put(s,l);
                            l = adj.getOrDefault(s1,new ArrayList<>());
                            l.add(s);
                            adj.put(s1,l);
                        }
                    }
                }
            }
        }
        int c=0;
        for (String node : adj.keySet()) {
                if(visited.get(node)==null){
                    c++;
                    bfs(node);
                }
        }
        
        return c;
    }
}