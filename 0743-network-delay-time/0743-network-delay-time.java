class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int [] dist = new int[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
    public int compare(int[] n1, int[] n2) {
        return n1[1]-n2[1];
    }
});
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
            dist[i]= Integer.MAX_VALUE;
        }
        for(int i=0;i<times.length;i++){
            int [] arr = new int[2];
            arr[0]=times[i][1];
            arr[1]=times[i][2];
            adj.get(times[i][0]).add(arr);
        }
        int [] arr = new int[2];
        arr[0]=k;
        arr[1]=0;
        dist[k]=0;
        pq.add(arr);
        while(pq.size()>0){
            int [] u = pq.poll();
            for(int i=0;i<adj.get(u[0]).size();i++){
                int [] v = adj.get(u[0]).get(i);
                if(dist[v[0]]>dist[u[0]]+v[1]){
                    dist[v[0]]=dist[u[0]]+v[1];
                    arr = new int[2];
                    arr[0]=v[0];
                    arr[1]=dist[v[0]];
                    pq.add(arr);
                }
            }
        }
        int max=0;
        for(int i=1;i<n+1;i++){
            if(max<dist[i])
                max = dist[i];
        }
        if(max==Integer.MAX_VALUE)
            return -1;
        return max;
        
    }
}

/*
1 : 2,1
2: 1,3

0   1   2
inf 3   0

2,0




*/