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
            return null;
        Map<Integer, Node> m = new HashMap<>();
        dfs(node, m, new HashSet<>());
        bfs(node, m);
        return m.get(node.val);
        
    }
    
    public void bfs(Node node, Map<Integer, Node> m){
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Set<Integer> vis = new HashSet<>();
        while(!q.isEmpty()){
            Node p = q.poll();
            if(vis.contains(p.val))
                continue;
            vis.add(p.val);
            List<Node> l = new ArrayList<>();
            for(Node n : p.neighbors){
                l.add(m.get(n.val));
                q.add(n);
            }
            m.get(p.val).neighbors = l;
        }
    }
    
    public void dfs(Node node, Map<Integer, Node> m, Set<Integer> recVis){
        if(recVis.contains(node.val))
            return;
        if(m.containsKey(node.val))
            return;
        recVis.add(node.val);
        for(Node n : node.neighbors){
            dfs(n, m, recVis);
        }
        recVis.remove(node.val);
        m.put(node.val, new Node(node.val));
    }
}