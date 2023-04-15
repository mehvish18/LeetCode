class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0, r= matrix.length*matrix[0].length -1, row,col;
        while(l<=r){
            int m = l +(r-l)/2;
            row = m/matrix[0].length;
            col = m%matrix[0].length;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                l=m+1;
            }
            else
                r=m-1;
            
        }
        return false;
    }
}