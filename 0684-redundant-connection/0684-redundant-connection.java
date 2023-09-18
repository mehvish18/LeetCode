class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<String, Integer> mp = new HashMap<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = edges.length-1;
        int root =edges[0][0];
        for(int i=0;i<edges.length;i++){
            mp.put(edges[i][0]+" "+edges[i][1], i);
            mp.put(edges[i][1]+" "+edges[i][0], i);
            List<Integer> lst = adj.getOrDefault(edges[i][0], new ArrayList<>());
            lst.add(edges[i][1]);
            adj.put(edges[i][0], lst);
            lst = adj.getOrDefault(edges[i][1], new ArrayList<>());
            lst.add(edges[i][0]);
            adj.put(edges[i][1],lst);
        }
        int [] parent = new int[adj.size()+1];
        boolean [] visited = new boolean[adj.size()+1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        parent[1]=1;
        int u=0,v=0;
        while(q.size()>0){
            u = q.poll();
            for(int i=0;i<adj.get(u).size();i++){
                v=adj.get(u).get(i);
                if(!visited[v]){
                    visited[v]=true;
                    parent[v]=u;
                    q.add(v);
                }
                else if(parent[u]!=v){
                    q = new LinkedList<>();
                    break;
                }
            }
        }
        if((mp.get(u+" "+v)!=null && mp.get(u+" "+v)==n))
            return edges[n];
        int max=mp.get(u+" "+v);
        //System.out.println("ans "+u+" "+v);
        //System.out.println(Arrays.toString(parent));
        HashSet<Integer> us = new HashSet<>();
        us.add(u);
        HashSet<Integer> vs = new HashSet<>();
        vs.add(v);
        int node=0;
        int u1=u,v1=v;
        int steps = 0;
        while(true){
            //System.out.println(u+" "+v);
            if(us.contains(v)) {
               node = v;
               break;
            }
            if(vs.contains(u)) {
               node=u;
               break;
            }
            v = parent[v];
            u = parent[u];
            us.add(u);
            vs.add(v);
            steps += 1;
        }
        v=v1;
        u=u1;
        int step2 = 0;
        //System.out.println(u+" "+v+" "+ node);
        while(u!=node && v!=node){
            step2 += 1;
            if(v!=node){
                if(mp.get(parent[v]+" "+v)!=null && mp.get(parent[v]+" "+v)>max)
                    max=mp.get(parent[v]+" "+v);
                v = parent[v];
            }
            if(u!=node) {
                if(mp.get(parent[u]+" "+u)!=null && mp.get(parent[u]+" "+u)>max)
                    max=mp.get(parent[u]+" "+u);
                u = parent[u];
            }
            //System.out.println(u+" "+v);
        }
        System.out.println("1: "+steps+" 2:"+step2);
        return edges[max];
        
    }
}

/*

1 2 3 4 5
1 1   1


*/