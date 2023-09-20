class Solution {
    int [][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] n1, int[] n2){
                return n1[2]-n2[2];
            }
        });
        int [] arr = new int[3];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = grid[0][0];
        pq.add(arr);
        int min = Integer.MAX_VALUE;
        int [][] visited = new int[n][m];
        while(pq.size()>0){
            int[] u = pq.poll();
            visited[u[0]][u[1]]=1;
            if(u[0]==n-1 && u[1]==m-1){
                min = Math.min(min,u[2]);
            }
            for(int i=0;i<4;i++){
                int x = u[0]+dir[i][0];
                int y = u[1]+dir[i][1];
                if(!(x<0 || y<0 || x>=n || y>=m)){
                    if(visited[x][y]==0){
                        arr = new int[3];
                        arr[0] = x;
                        arr[1] = y;
                        arr[2] = Math.max(u[2],grid[x][y]); 
                        pq.add(arr);
                    }
                }
            }
        }
        return min;
    }
}


/*
0 1 2 3 4
        5

21:15,22:15,22:2,23:1,24:0






*/