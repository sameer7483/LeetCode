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
    int ans= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        util(root);
        return ans;
    }
    
    public int[] util(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int[] left = util(root.left);
        int[] right = util(root.right);
        int[] res = new int[2];
        res[0] = Math.max(root.val, root.val + Math.max(left[0], right[0]));
        res[1] = Math.max(root.val + left[0] + right[0], root.val);
        ans = Math.max(ans, Math.max(res[0], res[1]));
        return res;
    }

}