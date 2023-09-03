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
    int max=0;
    public void getDepth(TreeNode root, int level){
        max = Math.max(max,level);
        if(root==null)
            return;
        
        getDepth(root.left,level+1);
        getDepth(root.right,level+1);
    }
    public int maxDepth(TreeNode root) {
        getDepth(root,0);
        return max;
    }
}