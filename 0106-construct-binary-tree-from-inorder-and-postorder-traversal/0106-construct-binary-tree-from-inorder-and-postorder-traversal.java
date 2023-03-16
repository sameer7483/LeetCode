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
    int curr;
    Map<Integer, Integer> m;
    public TreeNode buildTree(int[] io, int[] po) {
        m = new HashMap<>();
        for(int i=0;i<io.length;i++)
            m.put(io[i], i);
        curr = io.length-1;
        return util(io, po, 0, io.length-1);
    }
    
    public TreeNode util(int[] io, int[] po, int lo, int hi){
        if(lo > hi)
            return null;
        int mid = m.get(po[curr]);
        TreeNode root = new TreeNode(po[curr]);
        curr -= 1;
        root.right = util(io, po, mid+1, hi);
        root.left = util(io, po, lo, mid-1);
        return root;
        
    }
}