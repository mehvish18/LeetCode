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
    public boolean isIdentical(TreeNode root, TreeNode subroot){
        if(root==null){
            if(subroot==null)
                return true;
            return false;
        }
        else if(subroot==null)
                return false;
        if(root.val==subroot.val){
            if(isIdentical(root.left,subroot.left) && isIdentical(root.right,subroot.right))
                return true;
        }
        return false;
    }
    public boolean subtreePresent(TreeNode root, TreeNode subroot) {
        if(root==null){
            return false;
        }
        if(isIdentical(root,subroot))
            return true;
        else if(subtreePresent(root.left,subroot) || subtreePresent(root.right,subroot))
            return true;
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        return subtreePresent(root,subroot);
    }
}


