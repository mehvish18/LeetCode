class Solution {
    public int find(int [][] parRank, int node){
        if(parRank[node][0]!=node)
           parRank[node][0]=find(parRank,parRank[node][0]);
        return parRank[node][0];
    }
    public void union(int [][] parRank,int xroot, int yroot){
        if(parRank[xroot][1]<parRank[yroot][1])
            parRank[xroot][0] = yroot;
        else if(parRank[xroot][1]>parRank[yroot][1])
            parRank[yroot][0] = xroot;
        else {
            parRank[xroot][0] = yroot;
            parRank[yroot][1]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        
        int [][] parRank = new int[edges.length+1][2];
        for(int i=1;i<edges.length+1;i++){
            parRank[i][0]=i;
            parRank[i][1]=0;
        }
        for(int i=0;i<edges.length;i++){
            int xroot = find(parRank,edges[i][0]);
            int yroot = find(parRank,edges[i][1]);
            if(xroot==yroot){
                return edges[i];
            }
            union(parRank,xroot,yroot);
        }
        return new int[0];
        
    }
}