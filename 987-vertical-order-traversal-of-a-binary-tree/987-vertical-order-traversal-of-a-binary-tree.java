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
    public void verticalTraversal(TreeNode root, int r, int c, Map<Integer, Map<Integer, List<Integer>>> m){
        if(root == null)
            return;
        Map<Integer, List<Integer>> rowMap = m.getOrDefault(c, new TreeMap<>());
        List<Integer> l = rowMap.getOrDefault(r, new ArrayList<>());
        l.add(root.val);
        rowMap.put(r, l);
        m.put(c, rowMap);
        if(root.left != null){
            verticalTraversal(root.left, r+1, c-1, m);
        }
        if(root.right != null){
            verticalTraversal(root.right, r+1, c+1, m);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Map<Integer,List<Integer>>> m = new TreeMap<>();
        verticalTraversal(root, 0, 0, m);
        for(Map.Entry<Integer,Map<Integer,List<Integer>>> entry : m.entrySet()){
            List<Integer> l = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> ent : entry.getValue().entrySet()){
                Collections.sort(ent.getValue());
                l.addAll(ent.getValue());
            }
            res.add(l);
        }
        return res;
    }
}