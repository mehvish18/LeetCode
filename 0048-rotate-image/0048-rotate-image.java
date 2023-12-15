class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int s = 0, e = c-1;
        int temp=0;
        for(int i=0;i<r/2;i++){
            for(int j=s;j<e;j++){
                int oldr = i;
                int oldc = j;
                int oldval = matrix[i][j];
                //System.out.println(i+" ij  "+j);
                int newr = oldc;
                int newc = c-1-oldr;
                while(newr!=i || newc != j){
                    newr = oldc;
                    newc = c-1-oldr;
                    temp = matrix[newr][newc];
                    matrix[newr][newc] = oldval;
                    oldr = newr;
                    oldc = newc;
                    oldval = temp;
                    //System.out.println(newr+" "+newc);
                }
            }
            s++;
            e--;
        }
    }
}

/*

old 0 1
new 1 2
 2 2
  0 1 2
0 1 2 3
1 4 5 6
2 7 8 9

  0 1 2
0 7 4 1
1 8 5 2
2 9 6 3



 r c

 c n-1-r





*/