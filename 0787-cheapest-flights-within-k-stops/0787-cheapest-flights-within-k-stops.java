class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int []>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] n1, int[] n2){
                return n1[1]-n2[1];
            }
        });
        int [] arr = new int[3];
        arr[0] = src;
        arr[1] = 0;
        arr[2] = k;
        pq.add(arr);
        int [] dist = new int[n];
        int [] steps = new int[n];
        
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
            steps[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        dist[src]=0;
        for(int i=0;i<flights.length;i++){
            int [] a =new int[2];
            a[0] = flights[i][1];
            a[1] = flights[i][2];
            adj.get(flights[i][0]).add(a);
        }
        while(pq.size()>0){
            int [] u = pq.poll();
            if(u[0]==dst) {
                return dist[dst];
            }
            if(u[2]<0)
                continue; 
            for(int i=0;i<adj.get(u[0]).size();i++){
                int [] v =  adj.get(u[0]).get(i);
                if(dist[v[0]]>dist[u[0]]+v[1]){
                    if(v[0]!=dst && u[2]==0)
                        continue;
                    //System.out.println("u:"+u[0]+" v:"+v[0]+" dist[u]:"+dist[u[0]]+" v[1]:"+v[1]);
                    dist[v[0]]=u[1]+v[1];
                    arr = new int[3];
                    arr[0] = v[0];
                    arr[1] = dist[v[0]];
                    arr[2] = u[2]-1;
                    steps[v[0]] = u[2]-1;
                    pq.add(arr);
                }
                if(u[2]-1>steps[v[0]]){
                    arr = new int[3];
                    arr[0] = v[0];
                    arr[1] = u[1]+v[1];
                    arr[2] = u[2]-1;
                    pq.add(arr);
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
            return -1;
        return dist[dst];
    }
}

/*



 
*/