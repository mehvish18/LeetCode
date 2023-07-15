class Solution {
    int m,n;
    int[][] dp;
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public int getLongestLength(int i,int j, int[][] matrix){
        //System.out.println("called " + i+" "+ j);
        if(dp[i][j]!=0)
            return dp[i][j];
        int max=0;
        for(int k=0;k<4;k++){
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            //System.out.println("X "+x+" y "+y+" ");
            if(x<0 || y<0 || x>=m ||y>=n)
                continue;
            //System.out.println("matrix "+matrix[x][y]+" "+matrix[i][j]);
            if(matrix[x][y]>matrix[i][j])
                max = Math.max(getLongestLength(x,y, matrix),max);
        }
        dp[i][j] = 1+max;
        //System.out.println(i+" "+ j+" "+dp[i][j]);
        return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(getLongestLength(i,j,matrix),max);
            }
        }
        return max;
    }
}