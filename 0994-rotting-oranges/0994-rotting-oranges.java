class Solution {
    public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int zeroCount = 0, fcount=0 ;
    for (int i=0; i<grid.length; i++){
        for (int j=0; j<grid[0].length; j++){
            if(grid[i][j]==0) fcount++;
            else if (grid[i][j] == 1) zeroCount++;
            else if (grid[i][j] == 2) queue.add(new int[] {i,j});
        }
    }
    if (fcount == (grid.length * grid[0].length)) return 0;
    

    // when BFS goes to next "level", you should then advance "minute".
    int minute = -1;

    while (!queue.isEmpty()){
        int initalSize = queue.size();

        // BFS x initalSize times 
        for (int i=0; i<initalSize; i++){
            int[] orange = queue.remove();
            int[][] children = {{0,1},{0,-1},{1,0},{-1,0}};

            for (int[] j : children){
                int newRow = j[0] + orange[0];
                int newCol = j[1] + orange[1];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length){
                    // visit fresh oranges and turn them rotten
                    if (grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        queue.add(new int[]{newRow, newCol});
                        zeroCount--;
                    } 
                }
            }
        }
        minute++;
    }
    
    if(zeroCount==0)
        return minute;
    else
        return -1;
}



}