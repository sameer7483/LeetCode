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
    int i=0;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        i=0;
        util(root, k);
        return ans;
    }
    public void util(TreeNode root, int k){
        if(root == null) return ;
        util(root.left, k);
        i++;
        if(i== k){
            ans = root.val;
            return;
        }
        util(root.right,k);

    }
}