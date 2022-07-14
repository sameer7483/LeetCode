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
        pre = 0;
        return util(preorder, inorder, 0, inorder.length-1);
    }
    
    public TreeNode util(int[] preorder, int[] inorder, int start, int end){
        if(start > end)
            return null;
        if(pre >= preorder.length)
            return null;
        int elem = preorder[pre];
        int i = start;
        for(i=start;i<=end;i++){
            if(inorder[i] == elem)
                break;
        }
        TreeNode root = new TreeNode(elem);
        if(i> end)
            return null;
        pre++;
        root.left = util(preorder, inorder, start, i-1);
        root.right = util(preorder, inorder, i+1, end);
        return root;
        
    }
 
}