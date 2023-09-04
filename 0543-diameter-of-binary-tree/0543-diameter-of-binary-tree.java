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
    public int getDepth(TreeNode root, int lvl){
        if(root==null)
            return lvl;
        int lvlLeft = getDepth(root.left,lvl);
        int lvlRight =  getDepth(root.right,lvl);
        max = Math.max(lvlLeft+lvlRight,max);
        return Math.max(lvlLeft,lvlRight)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root, 0);
        return max;
    }
}

/*
*/