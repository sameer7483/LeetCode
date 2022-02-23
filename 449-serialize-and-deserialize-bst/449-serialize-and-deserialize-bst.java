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
        if(root == null) return "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        List<String> c = new ArrayList<>();
        c.add(String.valueOf(root.val));
        if(left != null && !left.isEmpty())
            c.add(left);
        if(right != null && !right.isEmpty())
            c.add(right);
        if(!c.isEmpty())
            return String.join(",", c);
        return "";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) return null;
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        int n = str.length;
        if(n==1)
            return root;
        int i=1;
        List<String> left = new ArrayList<>();
        for(i=1;i<str.length;i++){
            if(Integer.parseInt(str[i])-Integer.parseInt(str[0]) > 0) break;
            left.add(str[i]);
        }
        List<String> right = new ArrayList<>();
        for(;i<str.length;i++){
            right.add(str[i]);
        }
        root.left = deserialize(String.join(",", left));
        root.right = deserialize(String.join(",", right));
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;