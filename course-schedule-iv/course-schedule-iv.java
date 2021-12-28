class Solution {
    Boolean[][] dp;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<numCourses;i++)
            adj.put(i, new ArrayList<>());
        for(int[] edge : prerequisites){
            List<Integer> l = adj.getOrDefault(edge[0], new ArrayList<>());
            l.add(edge[1]);
            adj.put(edge[0], l);
        }
        List<Boolean> ans = new ArrayList<>();
        dp = new Boolean[numCourses][numCourses];
        for(int i=0;i<queries.length;i++){
            ans.add(dfs(queries[i][0], queries[i][1], adj));
        }
        return ans;
        
    }
    
    public boolean dfs(int start, int end, Map<Integer, List<Integer>> adj){
        if(dp[start][end] != null)
            return dp[start][end];
        if(start == end){
            return dp[start][end]=true;
        }
        for(int i=0;i<adj.get(start).size(); i++){
            if(dfs(adj.get(start).get(i), end, adj))
                return dp[start][end]=true;
        }
        return dp[start][end]=false;
    }
}