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
    HashMap<Integer, Integer> mp = new HashMap<>();
    public TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd){
        if(pStart>pEnd || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int inroot = mp.get(preorder[pStart]);
        int nLeft = inroot-inStart;
        root.left = build(preorder, pStart+1, pStart+nLeft, inorder, inStart, inroot-1);
        root.right = build(preorder, pStart+nLeft+1, pEnd, inorder, inroot+1, inEnd);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for( int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode n = build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return n;
    }
}