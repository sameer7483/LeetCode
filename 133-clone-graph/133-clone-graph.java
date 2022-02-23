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
            return null;
      Node newNode = new Node(node.val);
        Map<Integer, Node> m = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, newNode));
        m.put(newNode.val, newNode);
        Map<Integer, Boolean> v = new HashMap<>();
        v.put(node.val, true);
        while(!q.isEmpty()){
            Pair p = q.poll();
            v.put(p.n1.val, true);
            ArrayList<Node> l = new ArrayList<>();
            for(int i=0;i<p.n1.neighbors.size();i++){
                if(m.containsKey(p.n1.neighbors.get(i).val)){
                    l.add(m.get(p.n1.neighbors.get(i).val));
                }
                else{
                    Node n = new Node(p.n1.neighbors.get(i).val);
                    l.add(n);
                     q.add(new Pair(p.n1.neighbors.get(i),n));
                    m.put(n.val, n);
                }
            }
            p.n2.neighbors = l;
            // for(int i=0;i<p.n1.neighbors.size();i++){
            //     if(!v.containsKey(p.n1.neighbors.get(i).val))
            //     q.add(new Pair(p.n1.neighbors.get(i), p.n2.neighbors.get(i)));
            // }
        }
        return newNode;    
    }
    
}