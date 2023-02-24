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
    int res = -1;
    int i = 0;
    public int kthSmallest(TreeNode root, int k) {
        util(root, k);
        return res;
    }
    
    public void util(TreeNode root, int k){
        if(root == null)
            return;
        util(root.left, k);
        i += 1;
        if(i == k)
            res = root.val;
        util(root.right, k);
    }
}