/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> lvlOrder = new ArrayList<>();
    public void getLvlOrder(TreeNode root, int lvl){
        if(root==null){
            return;
        }
        lvlOrder.get(lvl).add(root.val);
        getLvlOrder(root.left, lvl+1);
        getLvlOrder(root.right, lvl+1);
    }
    
    public int getDepth(TreeNode root, int lvl){
        if(root==null){
            return lvl;
        }
        return Math.max(getDepth(root.left, lvl+1),getDepth(root.right, lvl+1));
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        int depth = getDepth(root,0);
        for(int i=0;i<depth;i++){
            lvlOrder.add(new ArrayList<>());
        }
        getLvlOrder(root,0);
        return lvlOrder;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> lst = levelOrder(root);
        List<Integer> l = new ArrayList<Integer>();
         for(int i=0;i<lst.size();i++){
             List<Integer> n = lst.get(i);
             l.add(n.get(n.size()-1));
         }
        return l;
    }
}

