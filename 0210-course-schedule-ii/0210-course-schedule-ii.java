class Solution {
    
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] toplogical = new int[n];
        int k=0;
        Queue<Integer> q = new LinkedList<Integer>();
        int [] deg = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            deg[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<n;i++){
            if(deg[i]==0) {
                toplogical[k]=i;
                k++;
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i=0;i<adj.get(node).size();i++){
                if(--deg[adj.get(node).get(i)]==0){
                    q.add(adj.get(node).get(i));
                    toplogical[k]=adj.get(node).get(i);
                    k++;
                }
            }
        }
        if(k<n)
            return new int[] {};
        return toplogical;
    }
}