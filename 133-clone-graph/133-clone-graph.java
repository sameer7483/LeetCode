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

class Pair{
    Node n1;
    Node n2;
    public Pair(Node n1, Node n2){
        this.n1 = n1;
        this.n2 = n2;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Node newNode = new Node(node.val);
        Set<Integer> vis = new HashSet<>();
        Map<Integer, Node> m = new HashMap<>();
        m.put(newNode.val, newNode);
        Queue<Node> q = new LinkedList<>();
        vis.add(node.val);
        q.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<q.size();i++){
                Node p = q.poll();
                List<Node> l = new ArrayList<>();
                for(Node n : p.neighbors){
                        Node newN = m.getOrDefault(n.val, new Node(n.val));
                        l.add(newN);
                        m.put(newN.val, newN); 
                        if(!vis.contains(n.val)){
                            vis.add(n.val);
                            q.add(n);                            
                        }
                    
                }
                Node newP = m.get(p.val);
                newP.neighbors = l;
                m.put(newP.val, newP);
            }
        }
        return newNode;
    }
    
}