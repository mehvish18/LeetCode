class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int oneCount = 0, zeroCount=0 ;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0) zeroCount++;
                else if (grid[i][j] == 1) oneCount++;
                else if (grid[i][j] == 2) queue.add(new int[] {i,j});
            }
        }
        if (zeroCount == (grid.length * grid[0].length)) return 0;
    

        int minute = -1;

        while (!queue.isEmpty()){
            int initalSize = queue.size();

            for (int i=0; i<initalSize; i++){
                int[] orange = queue.remove();
                int[][] children = {{0,1},{0,-1},{1,0},{-1,0}};

                for (int[] j : children){
                    int newRow = j[0] + orange[0];
                    int newCol = j[1] + orange[1];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length){
                        if (grid[newRow][newCol] == 1){
                            grid[newRow][newCol] = 2;
                            queue.add(new int[]{newRow, newCol});
                            oneCount--;
                        } 
                    }
                }
            }
            minute++;
        }
    
        if(oneCount==0)
            return minute;
        else
            return -1;
    }
}