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
        if(root == null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        List<String> sb = new ArrayList<>();
        q.add(root);
        sb.add(String.valueOf(root.val));
        while(!q.isEmpty()){
            TreeNode p = q.poll();
            if(p.left == null){
                sb.add("*");
            }
            else{
                q.add(p.left);
                sb.add(String.valueOf(p.left.val));
            }
            if(p.right == null){
                sb.add("*");
            }
            else{
                q.add(p.right);
                sb.add(String.valueOf(p.right.val));
            }            
        }
        return String.join(",", sb);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())
            return null;
        String str[] = data.split(",");
        int n = str.length;
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1;i<n;i++){
            TreeNode p = q.poll();
            if(!str[i].equals("*")){
                p.left = new TreeNode(Integer.parseInt(str[i]));
                q.add(p.left);
            }
            else{
                p.left = null;
            }
            i++;
            if(!str[i].equals("*")){
                p.right = new TreeNode(Integer.parseInt(str[i]));
                q.add(p.right);
            }
            else{
                p.right = null;
            }             
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));