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
    int pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++){
            m.put(inorder[i], i);
        }
        pre = 0;
        return makeTree(preorder, m, 0, n-1);
    }
    
    public TreeNode makeTree(int[] preorder,Map<Integer, Integer> m, int lo, int hi){
        if(pre >= preorder.length || lo > hi)
            return null;
        TreeNode curr = new TreeNode(preorder[pre]);
        int idx = m.get(preorder[pre]);
        if(idx < lo || idx > hi)
            return null;
        pre++;
        curr.left = makeTree(preorder, m, lo, idx-1);
        curr.right = makeTree(preorder, m, idx+1, hi);
        return curr;
    }
}