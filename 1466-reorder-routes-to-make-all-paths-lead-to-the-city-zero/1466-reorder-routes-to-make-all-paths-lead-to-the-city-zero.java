class Solution {
    public int minReorder(int n, int[][] conn) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] c : conn){
            if(!adj.containsKey(c[0]))
                adj.put(c[0], new ArrayList<>());
            if(!adj.containsKey(c[1]))
                adj.put(c[1], new ArrayList<>());
            adj.get(c[0]).add(new int[]{c[1], 0});
            adj.get(c[1]).add(new int[]{c[0], 1});
        }
        int res = dfs(adj, 0, new HashSet<>());
        int m = conn.length;
        return m - res;
    }
    
    public int dfs(Map<Integer, List<int[]>> adj, int curr, Set<Integer> vis){
        if(vis.contains(curr))
            return 0;
        int res = 0;
        vis.add(curr);
        for(int[] v : adj.getOrDefault(curr, new ArrayList<>())){
            if(!vis.contains(v[0])){
                res += v[1];
                res += dfs(adj, v[0], vis);
            } 
        }
        return res;
    }
}