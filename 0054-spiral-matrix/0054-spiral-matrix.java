class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l=0,r=matrix[0].length-1, u = 0, d = matrix.length-1;
        int n = matrix[0].length * matrix.length;
        int dir = 1;
        int j=0,k=0;
        if(matrix[0].length==1)
            dir = 2;
        //1->r 2->d 3->l 4->u
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            //System.out.println("u: "+u+" l: "+l+" r: "+r+" d: "+d);
            //System.out.println(j+" "+k+" dir:"+dir);
            ans.add(matrix[j][k]);
            if(dir==1)
                k++;
            else if(dir==2)
                j++;
            else if(dir==3)
                k--;
            else if(dir==4)
                j--;
            
            if(dir!=2 && j==u && k==r && u!=d){
                dir = 2;
                u++;
                //System.out.println("changed to 2");
            }
            else if(dir!=3 && k==r && j==d && l!=r){
                dir = 3;
                r--;
                //System.out.println("changed to 3");
            }
            else if(dir!=4 && k==l && j==d && u!=d){
                dir = 4;
                d--;
                //System.out.println("changed to 4");
            }
            else if(dir!=1 && j==u && k==l && l!=r){
                l++;
                dir = 1;
                //System.out.println("changed to 1");
            }

            
        }
        return ans;
    }
}

/*
  1, 2,3,4, 8,12, 11 10 9,5 6 7
  
  
  1  2   3  4 
  5  6   7  8
  9  10  11 12
  13 14  15 16
 
 
 l = 2
 r = 2
 u = 2
 d = 2
 
 
  
 
*/