/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Integer,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
       if(node==null)
           return null;
       if(map.get(node.val)!=null)
           return map.get(node.val);
       Node ans = new Node(node.val);
       map.put(node.val,ans);
       for(int i=0;i<node.neighbors.size();i++){
           ans.neighbors.add(cloneGraph(node.neighbors.get(i)));
       }
       return ans;
    }
}