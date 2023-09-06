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
    int count = 0;
    public int getMaxPathSum(TreeNode root){
        if(root==null)
            return 0;
        int left = getMaxPathSum(root.left);
        int right = getMaxPathSum(root.right);
        count = Math.max(count,Math.max(Math.max(left+root.val+right,root.val), Math.max(left+root.val, root.val+right)));
        return Math.max(root.val, Math.max(left+root.val, root.val+right));
        
    }
    public int maxPathSum(TreeNode root) {
        count = root.val;
        getMaxPathSum(root);
        return count;
    }
}


