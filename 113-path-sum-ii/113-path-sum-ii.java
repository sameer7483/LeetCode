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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        util(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    public void util(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res){
        if(root == null)
            return;
        // if(targetSum < 0)
        //     return;
        if(targetSum-root.val == 0  && root.left == null && root.right == null){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        util(root.left, targetSum - root.val, path, res);
        util(root.right, targetSum - root.val, path, res);
        path.remove(path.size()-1);
        
    }
}