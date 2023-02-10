public class Node implements Comparator<Node>{
        public int node;
        public int dist;
        
        public Node(){
            
        }
        public Node(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
        @Override public int compare(Node n1, Node n2){
            return n1.dist-n2.dist;
        }
    }
class Solution {
    public int m, n1;
    public int [] dist;
    public List<List<Node>> adj = new ArrayList<>();
    public Set<Integer> settled = new HashSet<>();
    
    
    public void dijikstra(int source){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n1, new Node());
        dist[source]=0;
        pq.add(new Node(source,0));
        while(settled.size()!=n1){
            if(pq.isEmpty())
                return;
            int u = pq.remove().node;
            if(settled.contains(u))
                continue;
            
            settled.add(u);
            for(int i=0;i<adj.get(u).size();i++){
                Node v = adj.get(u).get(i);
                if(!settled.contains(v.node)){
                    if(dist[u]+v.dist < dist[v.node]){
                        dist[v.node] = dist[u]+v.dist;
                    }
                    pq.add(new Node(v.node,dist[v.node]));
                }
            }
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        n1=n;
        dist = new int[n+1];
        m = times.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<m;i++){
            Node no = new Node(times[i][1],times[i][2]);
            adj.get(times[i][0]).add(no);
        }
        dijikstra(k);
        int max=0;
        for(int i=1;i<=n;i++){
            max = Math.max(max,dist[i]);
        }
        if(max == Integer.MAX_VALUE )
            return -1;
        return max;
    }
}
