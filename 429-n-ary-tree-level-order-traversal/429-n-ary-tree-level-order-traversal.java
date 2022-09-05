/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node curr = q.poll();
                l.add(curr.val);
                for(int j=0;j<curr.children.size();j++){
                    if(curr.children.get(j) != null){
                        q.add(curr.children.get(j));
                    }
                }
            }
            res.add(l);
        }
        return res;
    }
}