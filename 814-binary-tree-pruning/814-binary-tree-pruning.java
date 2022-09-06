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
    public TreeNode pruneTree(TreeNode root) {
        checkOne(root);
        return (root.val == 0 && root.left == null && root.right == null) ? null : root;
    }
    
    public boolean checkOne(TreeNode root){
        if(root == null)
            return false;
        boolean left = checkOne(root.left);
        boolean right = checkOne(root.right);
        if(left == false)
            root.left = null;
        if(right == false)
            root.right = null;
        return root.val == 1 || left || right;
        
    }
}