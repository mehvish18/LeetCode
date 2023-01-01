class Solution {
    Map<String, Boolean> visited = new HashMap<>();
    boolean left, right, top, bottom;
    int m,n;
    List<List<Integer>> path = new ArrayList<>();
    public void bfs(char[][] board, int i, int j){
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.add(i);
        q2.add(j);
        visited.put(i+","+j,true);
        List<Integer> n1 = new ArrayList<>();
        n1.add(i);
        n1.add(j);
        path.add(n1);
        while(!q1.isEmpty()){
            int i1 = q1.poll();
            int j1 = q2.poll();
            //System.out.println(i1+" "+j1);
            
            if((j1+1)<n){
                if(board[i1][j1+1]=='O' & visited.get(i1+","+(j1+1))==null){
                    //right = false;
                    q1.add(i1);
                    q2.add(j1+1);
                    visited.put(i1+","+(j1+1),true);
                    //System.out.println("visited: "+i1+","+(j1+1));
                    n1 = new ArrayList<>();
                    n1.add(i1);
                    n1.add(j1+1);
                    path.add(n1);
                    //System.out.println("right");
                }
                /*else if(board[i1][j1+1]=='X'){
                    right = true;
                    //System.out.println("hello right");
                }*/
            }
            else {
                right = false;
            }
            
            if(i1+1<m){
                if(board[i1+1][j1]=='O' & visited.get((i1+1)+","+j1)==null){
                    //bottom = false;
                    q1.add(i1+1);
                    q2.add(j1);
                    visited.put((i1+1)+","+j1,true);
                    n1 = new ArrayList<>();
                    n1.add(i1+1);
                    n1.add(j1);
                    path.add(n1);
                    //System.out.println("bottom");
                }
                /*else if(board[i1+1][j1]=='X'){
                    bottom = true;
                    //System.out.println("hello bottom");
                }*/
            }
            else {
                bottom = false;
            }
            
            if(j1-1>=0){
                if(board[i1][j1-1]=='O' & visited.get(i1+","+(j1-1))==null){
                    //left = false;
                    q1.add(i1);
                    q2.add(j1-1);
                    visited.put(i1+","+(j1-1),true);
                    n1 = new ArrayList<>();
                    n1.add(i1);
                    n1.add(j1-1);
                    path.add(n1);
                    //System.out.println("left");
                }
                /*else if(board[i1][j1-1]=='X'){
                    //System.out.println("hello left");
                    left = true;
                }*/
            }
            else {
                left = false;
            }
            
            if(i1-1>=0){
                if(board[i1-1][j1]=='O' & visited.get((i1-1)+","+j1)==null){
                    //top = false;
                    q1.add(i1-1);
                    q2.add(j1);
                    visited.put((i1-1)+","+j1,true);
                    n1 = new ArrayList<>();
                    n1.add(i1-1);
                    n1.add(j1);
                    path.add(n1);
                    //System.out.println("top");
                }
                /*else if(board[i1-1][j1]=='X'){
                     //System.out.println("hello top");
                    top = true;
                }*/
            }
            else {
                top = false;
            }
            
            //System.out.println(left + " "+ right+" "+top+" "+bottom);
        }
         //System.out.println("return");
    }
    public void solve(char[][] board) {
        //System.out.println("dd");
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' & visited.get(i+","+j)==null){
                    path = new ArrayList<>();
                    left = right= top = bottom = true;
                    bfs(board,i,j);
                    //System.out.println(left + " "+ right+" "+top+" "+bottom);
                    if(left & right & top & bottom){
                        for(int k=0; k<path.size();k++){
                            int k1 = path.get(k).get(0);
                            int k2 = path.get(k).get(1);
                            board[k1][k2] = 'X';
                        }
                    }
                }
            }
        }
    }
}