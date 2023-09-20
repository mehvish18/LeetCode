class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int [][] adj = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
    public int compare(int[] n1, int[] n2) {
        return n1[1]-n2[1];
    }
});
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j] = (int)(Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]));
            }
        }
        int [] arr= new int[2];
        arr[0] = 0;
        arr[1] = 0;
        pq.add(arr);
        int [] vis = new int[n];
        int dis = 0;
        while(pq.size()>0){
            int [] u = pq.poll();
            if(vis[u[0]]==1)
                continue;
            vis[u[0]] = 1;
            dis += u[1];
            for(int j=0;j<n;j++){
                if(vis[j]==0){
                    arr= new int[2];
                    arr[0] = j;
                    arr[1] = adj[u[0]][j];
                    pq.add(arr);
                }
            }
        }
        return dis;
    }
}