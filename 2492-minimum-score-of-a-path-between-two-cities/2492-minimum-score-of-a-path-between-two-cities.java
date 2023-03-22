class Solution {
    int res;
    public int minScore(int n, int[][] roads) {
        res = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] r : roads){
            if(!adj.containsKey(r[0]))
                adj.put(r[0], new ArrayList<>());
            if(!adj.containsKey(r[1]))
                adj.put(r[1], new ArrayList<>());
            adj.getOrDefault(r[0], new ArrayList<>()).add(new int[]{r[1], r[2]});
            adj.getOrDefault(r[1], new ArrayList<>()).add(new int[]{r[0], r[2]});
        }
        dfs(adj, new HashSet<>(), 1);
        return res;
          
    }
    
    public void dfs(Map<Integer, List<int[]>> adj, Set<Integer> recVis, int curr){
        if(recVis.contains(curr))
            return;
        recVis.add(curr);
        for(int[] v : adj.getOrDefault(curr, new ArrayList<>())){
            res = Math.min(res, v[1]);
            dfs(adj, recVis, v[0]);
        }
    }
}