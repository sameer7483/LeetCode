class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Long> res = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e : edges){
            if(!adj.containsKey(e[0]))
                adj.put(e[0], new ArrayList<>());
            if(!adj.containsKey(e[1]))
                adj.put(e[1], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Set<Integer> vis = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!vis.contains(i)){
                res.add(dfs(adj, i, vis));
            }
        }
        long ans = 0;
        int done = 0;
        for(int i=0;i<res.size();i++){
            ans += res.get(i)*(n-res.get(i)-done);
            done += res.get(i);
        }
        return ans;
    }
    
    public long dfs(Map<Integer, List<Integer>> adj, int u, Set<Integer> vis){
        if(vis.contains(u))
            return 0;
        vis.add(u);
        long res = 1;
        for(int v : adj.getOrDefault(u, new ArrayList<>())){
            res += dfs(adj, v, vis);
        }
        return res;
    }
}