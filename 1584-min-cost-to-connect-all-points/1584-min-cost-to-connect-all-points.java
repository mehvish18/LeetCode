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
        parent[0]=-1;
        for(int i=0;i<v;i++){
            int u = minKey(key,inMst);
            inMst[u] = true;
            //System.out.println(u+" "+key[u]);
            ans += key[u];
            for(int j=0;j<v;j++){
                if(graph[u][j]!=0 && !inMst[j] && graph[u][j]<key[j]){
                    key[j]=graph[u][j];
                    parent[j]=u;
                }
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        v = points.length;
        parent = new int[v];
        graph = new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0; j<v;j++){
                if(i==j)
                    graph[i][j]=0;
                else
                    graph[i][j] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                //System.out.println(i+" "+j+" "+graph[i][j]);
            }
        }
        prims();
        int cost=0;
        //System.out.println(Arrays.toString(parent));
        /*for(int i=1;i<v;i++){
            cost += graph[i][parent[i]];
        }*/
        return ans;
    }
}