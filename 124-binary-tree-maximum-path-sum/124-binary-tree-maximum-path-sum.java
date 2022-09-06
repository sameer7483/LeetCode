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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        util(root);
        return maxSum;
        
    }
    
    public int util(TreeNode root){
        if(root == null)
            return 0;
        int left = util(root.left);
        int right = util(root.right);
        maxSum = Math.max(maxSum, left+right+root.val);
        maxSum = Math.max(maxSum, left+root.val);
        maxSum = Math.max(maxSum, right+root.val);
        maxSum = Math.max(maxSum, root.val);
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}