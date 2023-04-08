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
        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> m = new HashMap<>();
        q.add(node);
        Set<Integer> vis = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node p = q.poll();
                vis.add(p.val);
                List<Node> neigh = new ArrayList<>();
                for(Node n : p.neighbors){
                    if(!m.containsKey(n.val))
                        m.put(n.val, new Node(n.val));
                    neigh.add(m.get(n.val));
                    if(!vis.contains(n.val))
                        q.add(n);
                }
                if(!m.containsKey(p.val))
                    m.put(p.val, new Node(p.val));
                m.get(p.val).neighbors = neigh;                
            }
        }
        return m.get(node.val);
    }
}