class Solution {
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
            parent[i] =i;
        }
        for (int i = 0; i<edges.length; i++) {
            int x = find(parent,edges[i][0]-1);
            int y = find(parent,edges[i][1]-1);
            //System.out.println(x+" "+y);
            if (x == y)
                return edges[i];
 
            union(parent, x, y);
        }
        return new int[]{};
    }
}