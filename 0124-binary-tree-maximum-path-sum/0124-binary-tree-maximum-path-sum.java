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
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        util(root);
        return res;
    }
    
    public int util(TreeNode root){
        if(root == null)
            return 0;
        int left = util(root.left);
        int right = util(root.right);
        res = Math.max(res, Math.max(left+right+root.val, Math.max(root.val, root.val + Math.max(left, right))));
        return Math.max(root.val, root.val + Math.max(left, right));
    }
}