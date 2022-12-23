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
    public boolean [] visited =new boolean[101];
    public void getNeighbors(Node node, Node n){
        if(visited[node.val])
            return ;
        visited[node.val]=true;
        for(int i=0;i<node.neighbors.size();i++){
            //System.out.println(node.val + " neighbor: "+ node.neighbors.get(i).val);
            Node nei;
            if(map.get(node.neighbors.get(i).val)==null){
                nei = new Node(node.neighbors.get(i).val);
                map.put(node.neighbors.get(i).val,nei);
            }
            else
                nei = map.get(node.neighbors.get(i).val);
            getNeighbors(node.neighbors.get(i),nei);  
            n.neighbors.add(nei);    
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Node n = new Node(node.val);
        map.put(node.val,n);
        getNeighbors(node, n);
        //System.out.println("-----");
        //System.out.println(n.neighbors.get(1).neighbors.get(1).val);
        return n;
    }
}