class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length; 
        dp = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res, dfs(mat, i, j, -1, vis));
            }
        }
        return res;
    }
    
    public int dfs(int[][] mat, int r, int c, int prev, boolean[][] vis){
        int m = mat.length;
        int n = mat[0].length;
        if(r < 0 || r >= m || c < 0 || c >= n || mat[r][c] <= prev || vis[r][c])
            return 0;
        if(dp[r][c] != 0)
            return dp[r][c];
        vis[r][c] = true;
        int res = 1 +
            Math.max(dfs(mat, r+1, c, mat[r][c], vis), 
                    Math.max(dfs(mat, r-1, c, mat[r][c], vis), 
                        Math.max(dfs(mat, r, c+1, mat[r][c], vis), dfs(mat, r, c-1, mat[r][c], vis))));
        vis[r][c] = false;
        return dp[r][c]=res;
    }
}