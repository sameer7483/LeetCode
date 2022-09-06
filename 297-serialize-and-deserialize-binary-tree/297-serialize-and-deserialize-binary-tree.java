/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return "";
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            l.add(String.valueOf(curr.val));
            if(curr.left == null && curr.val != 1001){
                q.add(new TreeNode(1001));
            }
            else if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right == null && curr.val != 1001){
                q.add(new TreeNode(1001));
            }
            else if(curr.right != null){
                q.add(curr.right);
            }
        }
        return String.join(",", l);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        String[] str = data.split(",");
        int n = str.length;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        q.add(root);
        int idx = 0;
        while(!q.isEmpty()){
            TreeNode p = q.poll();
            idx++;
            if(idx >= n)
                break;
            if(Integer.valueOf(str[idx]) != 1001){
                p.left = new TreeNode(Integer.valueOf(str[idx]));
                q.add(p.left);
            }
            idx++;
            if(idx >= n)
                break;
            if(Integer.valueOf(str[idx]) != 1001){
                p.right = new TreeNode(Integer.valueOf(str[idx]));
                q.add(p.right);
            }    

        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));