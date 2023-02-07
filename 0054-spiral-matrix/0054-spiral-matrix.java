class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int re= matrix.length-1;
        int cs = 0;
        int rs = 0;
        int ce = matrix[0].length-1;
        int noOfElements = matrix.length*matrix[0].length;
        
        int r=0,c=0;
        List<Integer> lst = new ArrayList<>();
        boolean left=false, right=true, top=false, bottom=false;
        for(int i=0;i<noOfElements;i++){
            //System.out.println(r+" "+c);
            //System.out.println(matrix[r][c]);
            lst.add(matrix[r][c]);
            if(right && r==rs && c==ce){
                //System.out.println("bottom");
                rs++;
                right=false;
                bottom=true;
            }
            else if(bottom && r==re && c==ce){
                ce--;
                bottom=false;
                left=true;
            }
            else if(left && r==re && c==cs){
                re--;
                top=true;
                left=false;
            }
            else if(top && r==rs && c==cs){
                cs++;
                top=false;
                right=true;
            }
            if(right){
                c++;
            }
            else if(left){
                c--;
            }
            else if(bottom){
                r++;
            }
            else if(top){
                r--;
            }
        }
        return lst;
        
    }
}

