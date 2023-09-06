/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "n";
        String ro = ""+root.val;
        String l = serialize(root.left);
        String r = serialize(root.right);
        return ro+","+l+","+"r "+r;
    }
    
//1,2,n,r n,r 3,4,n,r n,r 5,n,r n

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    //System.out.println(data);
    String[] arr = data.split(",");
    Stack<TreeNode> stck = new Stack<>();
    TreeNode root = new TreeNode();
    if(arr[0]=="n")
        return null;
    root.val = Integer.parseInt(arr[0]);
    stck.push(root);
    for(int i=1;i<arr.length;i++){
        String nodeStr = arr[i];
        TreeNode top = stck.peek();
        TreeNode node = new TreeNode();
        //System.out.println(nodeStr);
        if(nodeStr.charAt(0)=='r'){
            if(!nodeStr.substring(2,nodeStr.length()).equals("n")){
          node.val = Integer.parseInt(nodeStr.substring(2,nodeStr.length()));
          top.right = node;
          stck.pop();
          stck.push(node);
            }
            else
                stck.pop();
        }
        else {
          if(!nodeStr.equals("n")){
            node.val = Integer.parseInt(nodeStr); 
            top.left = node;
            stck.push(node);
          }
        }
    }
    return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
