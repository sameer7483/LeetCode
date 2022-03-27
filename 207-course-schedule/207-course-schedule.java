class Solution {
    public boolean canFinish(int n, int[][] p) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] c : p){
            List<Integer> l = adj.getOrDefault(c[0], new ArrayList<>());
            l.add(c[1]);
            adj.put(c[0], l);
        }
        boolean[] vis = new boolean[n];
        boolean[] recVis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(isCycle(adj, i, vis, recVis))
                    return false;     
            }
        }
        return true;
    }
    
    public boolean isCycle(Map<Integer, List<Integer>> adj, int u, boolean[] vis, boolean[] recVis){
        if(recVis[u])
            return true;
        if(vis[u])
            return false;
        vis[u] = true;
        recVis[u] = true;
        for(Integer v : adj.getOrDefault(u, new ArrayList<>())){
            if(isCycle(adj, v, vis, recVis))
                return true;
        }
        recVis[u] = false;
        return false;
    }
}