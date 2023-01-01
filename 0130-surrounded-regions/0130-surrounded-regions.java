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
            if((j1+1)<n){
                if(board[i1][j1+1]=='O' & visited.get(i1+","+(j1+1))==null){
                    q1.add(i1);
                    q2.add(j1+1);
                    visited.put(i1+","+(j1+1),true);
                    n1 = new ArrayList<>();
                    n1.add(i1);
                    n1.add(j1+1);
                    path.add(n1);
                }
            }
            else {
                right = false;
            }
            
            if(i1+1<m){
                if(board[i1+1][j1]=='O' & visited.get((i1+1)+","+j1)==null){
                    q1.add(i1+1);
                    q2.add(j1);
                    visited.put((i1+1)+","+j1,true);
                    n1 = new ArrayList<>();
                    n1.add(i1+1);
                    n1.add(j1);
                    path.add(n1);
                }
            }
            else {
                bottom = false;
            }
            
            if(j1-1>=0){
                if(board[i1][j1-1]=='O' & visited.get(i1+","+(j1-1))==null){
                    q1.add(i1);
                    q2.add(j1-1);
                    visited.put(i1+","+(j1-1),true);
                    n1 = new ArrayList<>();
                    n1.add(i1);
                    n1.add(j1-1);
                    path.add(n1);
                }
            }
            else {
                left = false;
            }
            
            if(i1-1>=0){
                if(board[i1-1][j1]=='O' & visited.get((i1-1)+","+j1)==null){
                    q1.add(i1-1);
                    q2.add(j1);
                    visited.put((i1-1)+","+j1,true);
                    n1 = new ArrayList<>();
                    n1.add(i1-1);
                    n1.add(j1);
                    path.add(n1);
                }
            }
            else {
                top = false;
            }
        }
    }
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' & visited.get(i+","+j)==null){
                    path = new ArrayList<>();
                    left = right= top = bottom = true;
                    bfs(board,i,j);
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