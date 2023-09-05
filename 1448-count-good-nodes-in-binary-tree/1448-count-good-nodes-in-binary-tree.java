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
    public void getCountGNodes(TreeNode root, int maxSoFar){
        if(root==null)
            return;
        if(root.val >= maxSoFar){
            count++;
            maxSoFar = root.val;
        }
        getCountGNodes(root.left, maxSoFar);
        getCountGNodes(root.right, maxSoFar);
    }
    public int goodNodes(TreeNode root) {
        getCountGNodes(root, root.val);
        return count;
    }
}

