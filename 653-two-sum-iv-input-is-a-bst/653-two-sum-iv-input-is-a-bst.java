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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        return dfs(root, k, s);
    }
    
    public boolean dfs(TreeNode root, int k, Set<Integer> s){
        if(root == null)
            return false;
        if(s.contains(k-root.val))
            return true;
        s.add(root.val);
        return dfs(root.left, k, s) || dfs(root.right, k, s);
    }
}