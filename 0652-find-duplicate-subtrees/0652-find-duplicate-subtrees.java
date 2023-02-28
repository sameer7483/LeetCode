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
    Map<String, Integer> m;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        m = new HashMap<>();
        util(root, res);
        return res;
    }
    
    public String util(TreeNode root, List<TreeNode> res){
        if(root == null)
            return "";
        String str = String.format("%d, %s, %s", root.val, util(root.left, res), util(root.right, res));
        m.put(str, m.getOrDefault(str, 0)+1);
        if(m.get(str) == 2)
            res.add(root);
        return str;
    }


}