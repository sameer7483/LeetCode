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
        if(root == null) return false;
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int i=0, j= res.size()-1;
        while(i<j){
            int sum = res.get(i) + res.get(j);
            if(sum == k) return true;
            if(sum < k) i++;
            else j--;
        }
        return false;
    }    
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null) return ;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}