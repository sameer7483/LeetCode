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
    Map<Integer, Integer> m;
    public int[] findFrequentTreeSum(TreeNode root) {
        m = new HashMap<>();
        int max = Integer.MIN_VALUE;
        util(root);
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : m.entrySet()){
            if(entry.getValue() == max)
                res.add(entry.getKey());
        }
        return res.stream().filter(Objects::nonNull).mapToInt(i->i).toArray();
    }
    
    public int util(TreeNode root){
        if(root == null)
            return 0;
        int sum =  root.val + util(root.left) + util(root.right);
        int count = m.getOrDefault(sum, 0);
        m.put(sum, count+1);
        return sum;
    }
}