class Solution {
    int v;
    int [][] graph;
    int [] parent;
    int ans=0;
    public int minKey(int [] key, boolean [] inMST){
        int m = Integer.MAX_VALUE;
        int mIndex = -1;
        for(int i=0;i<v;i++){
           if(!inMST[i] && key[i]<=m){
               m=key[i];
               mIndex = i;
           }
        }
        return mIndex;
    }
    public void prims(){  
        int [] key = new int[v];
        boolean [] inMst = new boolean[v];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0]=0;
     
        for(int i=0;i<v;i++){
            int u = minKey(key,inMst);
            inMst[u] = true;
            ans += key[u];
            for(int j=0;j<v;j++){
                if(graph[u][j]!=0 && !inMst[j] && graph[u][j]<key[j]){
                    key[j]=graph[u][j];
                
                }
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        v = points.length;
        parent = new int[v];
        graph = new int[v][v];
        for(int i=0;i<v;i++){
            graph[i][i]=0;
            for(int j=i+1; j<v;j++){
                    graph[i][j] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                graph[j][i] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            }
        }
        prims();
        return ans;
    }
}