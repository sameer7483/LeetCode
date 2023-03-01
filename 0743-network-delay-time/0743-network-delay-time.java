class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] t : times){
            List<int[]> l = adj.getOrDefault(t[0], new ArrayList<>());
            l.add(new int[]{t[1], t[2]});
            adj.put(t[0], l);
        }
        return bfs(adj, n, k);
        
    }
    
    public int bfs(Map<Integer, List<int[]>> adj, int n, int k){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[1]-b[1]);
        Set<Integer> vis = new HashSet<>();
        q.add(new int[]{k, 0});
        while(!q.isEmpty()){
            int[] p = q.poll();
            vis.add(p[0]);
            if(vis.size() == n)
                return p[1];
            for(int[] nei : adj.getOrDefault(p[0], new ArrayList<>())){
                if(!vis.contains(nei[0])){
                    q.add(new int[]{nei[0], p[1]+nei[1]});
                }
            }
        }
        return -1;
    }
}