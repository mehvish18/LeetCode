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
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    public void getKthSmallest(TreeNode root, int k) {
        if(root==null)
            return;
        if(pq.size()==k){
            if(pq.peek()>root.val){
                pq.poll();
                pq.add(root.val);
            }
        }
        else{
            pq.add(root.val);
        }
        getKthSmallest(root.left,k);
        getKthSmallest(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        getKthSmallest(root,k);
        return pq.peek();
    }
}