class Edge{
    public int v;
    public int w;
    public Edge(int v, int w){
        this.v = v;
        this.w = w;
    }
}
class Solution {
    long dp[];
    public int countRestrictedPaths(int n, int[][] edges) {
        dp = new long[n+1];
        Arrays.fill(dp, -1);
        Map<Integer,List<Edge>> adj = new HashMap<>();
        for(int[] e : edges){
            List<Edge> l1 = adj.getOrDefault(e[0], new ArrayList<>());
            List<Edge> l2 = adj.getOrDefault(e[1], new ArrayList<>());
            l1.add(new Edge(e[1], e[2]));
            l2.add(new Edge(e[0], e[2]));
            adj.put(e[0], l1);
            adj.put(e[1], l2);
        }
        int[] dist = dijkstra(n, adj, n);
        return (int)totalPath(dist, n, 1, adj);
        
    }
    
    public long totalPath(int[] dist, int start, int end, Map<Integer, List<Edge>> adj){
        if(start == end)
            return 1;
        if(dp[start] != -1){
            return dp[start];
        }
        int mod =(int) 1e9+7;
        long sum = 0;
        for(Edge e: adj.getOrDefault(start, new ArrayList<>())){
            if(dist[start] < dist[e.v])
                sum =(sum + totalPath(dist, e.v, end, adj)%mod)%mod;
        }
        return dp[start]=sum % mod;
    }
    
    public int[] dijkstra(int start, Map<Integer, List<Edge>> adj, int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> q = new PriorityQueue<>((a,b) -> a.w - b.w);
        q.add(new Edge(start, 0));
        dist[start] = 0;
        // boolean[] visited = new boolean[n+1];
        while(!q.isEmpty()){
            Edge p = q.poll();
            for(Edge e : adj.getOrDefault(p.v, new ArrayList<>())){
                if(dist[e.v] > dist[p.v] + e.w){
                    dist[e.v] = dist[p.v] + e.w;
                    q.add(e);
                }
            }                
        }
        return dist;
    }
}