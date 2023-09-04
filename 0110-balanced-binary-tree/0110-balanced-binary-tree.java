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
    public int getDepth(TreeNode root, int lvl){
        if(root==null)
            return lvl;
        int lvlLeft = getDepth(root.left,lvl);
        int lvlRight =  getDepth(root.right,lvl);
        if(Math.abs(lvlRight-lvlLeft)>1 || lvlLeft==-1 || lvlRight==-1)
           return -1;
        return Math.max(lvlLeft,lvlRight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int isBal = getDepth(root,0);
        if(isBal==-1)
            return false;
        return true;
    }
}