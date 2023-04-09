class Solution {

    public int largestPathValue(String colors, int[][] edges) {
        //iterative topological sort
        int res = 0;
        int n = colors.length();
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] e : edges){
            if(!adj.containsKey(e[0]))
                adj.put(e[0], new ArrayList<>());
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int[][] dp = new int[n][26];
        for(int i=0;i<n;i++){
            if(indegree[i]== 0){
                q.add(i);
                dp[i][colors.charAt(i)-'a'] = 1;
            }
        }
        int seen = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            seen++;
            for(int i=0;i<26;i++)
                res = Math.max(res, dp[u][i]);
            for(int v : adj.getOrDefault(u, new ArrayList<>())){
                indegree[v]--;
                for(int i=0;i<26;i++){
                    dp[v][i] = Math.max(dp[v][i], dp[u][i] + (colors.charAt(v)-'a' == i ? 1 : 0));
                }
                if(indegree[v] == 0)
                    q.add(v);
            }
        }
        return seen == n ? res : -1;
    }
    
}