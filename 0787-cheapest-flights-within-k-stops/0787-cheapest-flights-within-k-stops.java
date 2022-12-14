public class Node implements Comparator<Node>{
    public int node;
    public int dist;
    public int kLeft;
    
    public Node(){
        
    }
    
    public Node(int n, int d, int k1){
        this.node = n;
        this.dist = d;
        this.kLeft = k1;
    }
    
    public Node(int n, int d){
        this.node = n;
        this.dist = d;
    }
    
    @Override 
    public int compare(Node n1, Node n2){
        return n1.dist-n2.dist;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
                adj.get(flights[i][0]).add(new Node(flights[i][1],flights[i][2]));
        }
        int []dist = new int[n];
        int []step = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(step,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Node());
        pq.add(new Node(src,0,k));
        dist[src]=0;
        while(!pq.isEmpty()){
                //break;
            Node u = pq.remove();
            if(u.node==dst)
                return u.dist;
            
            for(Node v:adj.get(u.node)){
                if(u.kLeft>=0){
                    if(v.node!=dst && u.kLeft==0)
                        continue;
                    if(u.dist+v.dist < dist[v.node]){
                        dist[v.node]=u.dist+v.dist;
                        step[v.node]=u.kLeft-1;
                        pq.add(new Node(v.node,u.dist+v.dist,u.kLeft-1));
                    }
                    else if(u.kLeft-1 > step[v.node])
                        pq.add(new Node(v.node,u.dist+v.dist,u.kLeft-1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
            return -1;
        return dist[dst];
    }
}

