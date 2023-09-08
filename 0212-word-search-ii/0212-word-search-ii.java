class Solution {
    HashSet<String> wordsHashSet = new HashSet<>();
    HashSet<String> ans = new HashSet<>();
    int m=0,n=0;
    int [][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public class TreeNode {
        public char value;
        public HashMap<Character,TreeNode> neighbors;
        public TreeNode(){
            neighbors  = new HashMap<>();
        }
    }
    
    TreeNode root;
    int [][] visited;
    
    public Solution() {
        root = new TreeNode();
    }
    
    public void insert(String word) {
        if(root.neighbors.size()==0){
            List<TreeNode> treeList = new ArrayList<>();
            TreeNode node = new TreeNode();
            char ch = word.charAt(0);
            node.value = ch;
            treeList.add(node);
            root.neighbors.put(ch,node);
            for(int i=1;i<word.length();i++){
                TreeNode node1 = new TreeNode();
                ch = word.charAt(i);
                node1.value = ch;
                treeList.add(node1);
                treeList.get(i-1).neighbors.put(ch,node1);      
            }  
            treeList.get(word.length()-1).neighbors.put('-',new TreeNode());
        }
        else {
            TreeNode parent = root;
            for(int j=0;j<word.length();j++){
                boolean letterNotFound = true;
                char ch = word.charAt(j);
                TreeNode node = parent.neighbors.get(ch);
                if(node==null){
                    node = new TreeNode();
                    node.value = ch;
                    parent.neighbors.put(ch,node);  
                }
                parent=node;
            }
            //System.out.println(parent.value+" "+parent.neighbors.size());
            if(parent.neighbors.get('-')!=null)
                    return;
            parent.neighbors.put('-', new TreeNode());
        }
    }

    
    public void dfs(char[][] board, int i, int j,TreeNode parent, String s){
        //System.out.println(i+" "+j);
        if(i<0||j<0||i>=m||j>=n||visited[i][j]==1)
            return;
        if(wordsHashSet.contains(s+board[i][j]))
            ans.add(s+board[i][j]);
        TreeNode node = parent.neighbors.get(board[i][j]);
        if(node!=null){
            visited[i][j]=1;
            //System.out.println(node.value);
            for(int k=0;k<4;k++){
                int x = i+dir[k][0];
                int y = j + dir[k][1];
                dfs(board,x,y,node,s+board[i][j]);
            }
            visited[i][j]=0;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<Character> startsWithSet = new HashSet<>();
        m = board.length;
        n = board[0].length;
        visited = new int[m][n];
        for(int i=0;i<words.length;i++){
            insert(words[i]);
            char ch = words[i].charAt(0);
            startsWithSet.add(ch);
            wordsHashSet.add(words[i]);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(startsWithSet.contains(board[i][j])){
                    //System.out.println(board[i][j]);
                    visited = new int[m][n];
                    dfs(board,i,j,root,"");
                    //System.out.println("-----");
                }
            }
        }
        List<String> res = new ArrayList<>(ans);
        return res;
    }
}


