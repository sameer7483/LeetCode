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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode nroot = new TreeNode(val);
            nroot.left = root;
            return nroot;
        }
        int currDep = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode p = q.poll();
                if(currDep == depth-1){
                    TreeNode left = p.left;
                    TreeNode right = p.right;
                    p.left = new TreeNode(val, left, null);
                    p.right = new TreeNode(val, null, right);
                }
                if(p.left != null)
                    q.add(p.left);
                if(p.right != null)
                    q.add(p.right);
            }
            currDep++;
            if(currDep >=depth)
                break;
        }
        return root;
        
    }
}