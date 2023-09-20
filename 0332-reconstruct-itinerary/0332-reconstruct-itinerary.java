class Solution {
    List<String> ans = new ArrayList<>();
    
    public void dfs(Map<String,PriorityQueue<String>> adj, String node){
      if(adj.get(node)!=null){
        while(adj.get(node).size()>0){
          String v = adj.get(node).poll();
          dfs(adj,v);
        }
      }
      ans.add(node);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj = new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            PriorityQueue pq = adj.getOrDefault(tickets.get(i).get(0), new PriorityQueue<String>());
            pq.add(tickets.get(i).get(1));
            adj.put(tickets.get(i).get(0),pq);  
        }
        dfs(adj,"JFK");
        Collections.reverse(ans);
        return ans;
    }
}
