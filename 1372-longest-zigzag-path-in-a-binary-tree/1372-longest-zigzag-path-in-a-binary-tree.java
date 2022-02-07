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
    
    public int longestZigZag(TreeNode root) {
            return util(root)[2];
    }
    
    public int[] util(TreeNode root){
       if (root == null) return new int[]{-1, -1, -1};
        int[] r = util(root.right);
        int[] l =util(root.left);
        int[] res = new int[3];
        res[0] = 1 + l[1];
        res[1] = 1 + r[0];
        res[2] = Math.max(res[0],Math.max(res[1], Math.max(l[2], r[2])));
        return res;
    }
}