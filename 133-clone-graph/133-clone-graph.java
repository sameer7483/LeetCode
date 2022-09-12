/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Map<Integer, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node newNode = new Node(node.val);
        m.put(node.val, newNode);
        Set<Integer> vis = new HashSet<>();
        while(!q.isEmpty()){
            Node p = q.poll();
            Node np = m.get(p.val);
            vis.add(p.val);
            List<Node> l = new ArrayList<>();
            for(Node r : p.neighbors){
                if(m.containsKey(r.val)){
                    l.add(m.get(r.val));
                }
                else{
                    Node nn = new Node(r.val);
                    m.put(r.val, nn);
                    l.add(nn);
                }
                if(!vis.contains(r.val)){
                    q.add(r);
                }
            }
            np.neighbors = l;
        }
        return newNode;
    }
}