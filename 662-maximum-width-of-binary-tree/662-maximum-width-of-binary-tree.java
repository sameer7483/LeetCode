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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
        q.add(new Pair(0, root));
        int max = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int begin = q.peek().getKey();
            for(int i=0;i<size;i++){
                Pair<Integer, TreeNode> p = q.poll();
                max = Math.max(max, p.getKey()-begin+1);
                int left = 2*p.getKey()+1;
                int right = 2*p.getKey()+2;
                if(p.getValue().left != null)
                    q.add(new Pair(left, p.getValue().left));
                if(p.getValue().right != null)
                    q.add(new Pair(right, p.getValue().right));     
            }
        }
        return max;
    }
}