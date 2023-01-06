class Solution {
    Map<String,PriorityQueue<String>> adj = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(int i=0;i<tickets.size();i++){
            PriorityQueue<String> lst = adj.getOrDefault(tickets.get(i).get(0),new PriorityQueue<String>());
            lst.add(tickets.get(i).get(1));
            adj.put(tickets.get(i).get(0),lst);
        }
        dfs("JFK");
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String source){
        PriorityQueue<String> q = adj.get(source);
        if(q!=null){
            while(q.size()>0){
                String v = q.poll();
                dfs(v);
            }
        }
        ans.add(source);
    }
}