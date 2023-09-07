class WordDictionary {
    
   public class TreeNode {
        public char value;
        public HashMap<Character,TreeNode> neighbors;
        public TreeNode(){
            neighbors  = new HashMap<>();
        }
    }
    
    TreeNode root;
    int depth;
    
    public void addWord(String word) {
        depth = Math.max(depth,word.length());
        
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
    
    public boolean searchWord(String word, TreeNode parent) {
            if(word.length()>depth)
                return false;
            for(int j=0;j<word.length();j++){
                boolean letterNotFound = true;
                char ch = word.charAt(j);
                if(ch=='.'){
                    for(Map.Entry<Character,TreeNode> entry: parent.neighbors.entrySet()){
                        if(searchWord(word.substring(j+1,word.length()),entry.getValue()))
                            return true;
                    }
                    return false;
                }
                else {
                    parent = parent.neighbors.get(ch);
                        if(parent==null){
                            return false;
                        }
                } 
            }
            //System.out.println(parent.value+" "+parent.neighbors.size());
            if(parent.neighbors.get('-')!=null)
                    return true;
            return false;
    }
    
    public boolean search(String word) {
        return searchWord(word,root);
    }

    public WordDictionary() {
        depth = 0;
        root = new TreeNode();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */