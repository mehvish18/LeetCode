class Solution {
    int [] deg;
    List<List<Integer>> adj = new ArrayList<>();
    List<Integer> toplogical = new ArrayList<>();
    
    
    public boolean canFinish(int n, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<Integer>();
        deg = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            deg[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<n;i++){
            if(deg[i]==0) {
                toplogical.add(i);
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<adj.get(node).size();i++){
                if(--deg[adj.get(node).get(i)]==0){
                    q.add(adj.get(node).get(i));
                    toplogical.add(adj.get(node).get(i));
                }
            }
        }
        return (toplogical.size()>=n);
    }
}

  
