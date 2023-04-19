class Solution {
    public int swimInWater(int[][] grid) {
        int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int p1[], int p2[]){
                return grid[p1[0]][p1[1]]-grid[p2[0]][p2[1]];
            }
        });
        boolean [][] seen = new boolean[m][n];
        pq.add(new int[]{0,0});
        int max = grid[0][0];
        while(pq.size()>0){
            int [] t = pq.remove();
            if(seen[t[0]][t[1]])
                continue;
            seen[t[0]][t[1]]=true;
            max = Math.max(max,grid[t[0]][t[1]]);
            if(t[0]==m-1 && t[1]==n-1)
                break;
            for(int i=0;i<4;i++){
                int x  = t[0]+dir[i][0];
                int y  = t[1]+dir[i][1];
                if(x>=0 && y>=0 && x<m && y<n){
                    pq.add(new int[]{x,y});
                }
            }   
        }
        return max;
    }
}