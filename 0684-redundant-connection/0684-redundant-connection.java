class Solution {
    //List<List<Integer>> adj = new ArrayList<>();
    int find(int [] parent,int i){
        if(parent[i]==i)
            return i;
        return find(parent,parent[i]);
    }
    void union(int [] parent, int x,int y){
        parent[x]=y;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length];
        for(int i=0; i<edges.length;i++){
            //adj.add(new ArrayList<>());
            parent[i] =i;
        }
        /*for(int i=0; i<edges.length;i++){
            adj.get(edges[i][0]-1).add(edges[i][1]-1);
            adj.get(edges[i][1]-1).add(edges[i][0]-1);
        }*/
        for (int i = 0; i<edges.length; i++) {
            int x = find(parent,edges[i][0]-1);
            int y = find(parent,edges[i][1]-1);
            System.out.println(x+" "+y);
            if (x == y)
                return edges[i];
 
            union(parent, x, y);
        }
        return new int[]{};
    }
}
/*
1 2 3
3 3 3*/