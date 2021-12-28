class Edge{
    public int v;
    public double w;
    public Edge(int v, double w){
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
       Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});    
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});    
        }
        double[] p = new double[n];
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> -p[i]));
        pq.offer(start);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (cur == end) {
                return p[end];
            }
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                if (p[cur] * succProb[index] > p[neighbor]) {
                    p[neighbor] = p[cur] * succProb[index];
                    pq.offer(neighbor);
                }
            }
        }
        return 0d;
         
    }
    
    public double dijkstra(int n, int start,int end, Map<Integer, List<Edge>> adj){
        double[] prob = new double[n];
        Arrays.fill(prob, 0.0);
        prob[start] =1.0;
        PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> (int) (b.w - a.w));
        q.add(new Edge(start, prob[start]));
        Map<Integer, Boolean> visited = new HashMap<>();
        while(!q.isEmpty()){
            Edge p = q.poll();
            int node = p.v;
            double weight = p.w;
                if(node == end)
                    return prob[end];
              for(Edge e : adj.getOrDefault(node, new ArrayList<>())){
                double d = weight * e.w;
                if(d > prob[e.v]){
                    prob[e.v] = d;
                    q.add(new Edge(e.v, prob[e.v]));
                }
            }              


        }
        return prob[end];
    }
}