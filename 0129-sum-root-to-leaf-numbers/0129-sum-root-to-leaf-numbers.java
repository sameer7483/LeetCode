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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        util(root, 0);
        return res;
    }
    
    public void util(TreeNode root, int curr){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            res += curr+root.val;
        }
        curr += root.val;
        util(root.left, curr*10);
        util(root.right, curr*10);
    }
}