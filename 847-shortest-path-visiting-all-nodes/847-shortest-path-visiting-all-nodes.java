class Solution {
    public int[][] dp;
    public int[][] dp2;
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1)
            return 0;
        dp = new int[n][n];
        dp2 = new int[n][100000];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE/4);
            Arrays.fill(dp2[i], -1);
        }
            
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
            for(int j=0;j<graph[i].length;j++){
                dp[i][graph[i][j]] = 1;
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int vis = (1 << i);
            min = Math.min(min, dfs(vis, i, n));
        }
        return min;
    }
    
    public int dfs(int vis, int start,int n){
        if(((1<<n) -1) == vis)
            return 0;
        if(dp2[start][vis] != -1) return dp2[start][vis];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(((1<<i) & vis) ==0){
                min = Math.min(min, dfs(vis|(1<<i), i, n) + dp[start][i]);
            }
        }
        return dp2[start][vis]=min;
    }
}