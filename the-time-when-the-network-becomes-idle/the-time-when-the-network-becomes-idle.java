class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int m = edges.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            List<Integer> l1 = adj.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> l2 = adj.getOrDefault(edge[1], new ArrayList<>());
            l1.add(edge[1]);
            l2.add(edge[0]);
            adj.put(edge[0], l1);
            adj.put(edge[1], l2); 
        }
        int[] t =bfs(adj, n);
        int res = 0;
        for(int i=1;i<n;i++){
            int extra = (t[i]-1)/patience[i];
            int lastOut = extra * patience[i];
            int lastIn = lastOut + t[i];
            res = Math.max(res, lastIn);
        }
        return res+1;
    }
    
    int[] bfs(Map<Integer, List<Integer>> adj, int n){
        int[] t = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        boolean visited[] = new boolean[n];
        visited[0] = true;
        while(!q.isEmpty()){
            int p = q.poll();
            for(int next : adj.get(p)){
                if(!visited[next]){
                    visited[next] = true;
                    t[next] = 1 + t[p];
                    q.add(next);
                }
            } 
        }
        for(int i=0;i<n;i++){
            t[i] = 2*t[i];
        }
        return t;
    }
}