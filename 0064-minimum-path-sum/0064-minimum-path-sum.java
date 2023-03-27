class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;        
        dp = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i], -1);
        return backtrack(grid, 0, 0, new boolean[m][n]);
        
    }
    
    public int backtrack(int[][] grid, int r, int c, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c])
            return Integer.MAX_VALUE/4;
        if(r==m-1 && c == n-1)
            return grid[r][c];
        if(dp[r][c] != -1)
            return dp[r][c];
        vis[r][c] = true;
        int dn = backtrack(grid, r+1, c, vis);
        int rt = backtrack(grid, r, c+1, vis);
        vis[r][c] = false;
        return dp[r][c] = grid[r][c] + Math.min(dn,rt);
    }
}