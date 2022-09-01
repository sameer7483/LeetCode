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
    public int goodNodes(TreeNode root) {
        return goodNodesUtil(root, Integer.MIN_VALUE);
    }
    public int goodNodesUtil(TreeNode root, int max) {
        if(root == null)
            return 0;
        int res = (root.val >= max ? 1 : 0);
        max = Math.max(max, root.val);        
        int left = goodNodesUtil(root.left, max);
        int right = goodNodesUtil(root.right, max);
        res += left + right;
        return res;
    }    
    
}