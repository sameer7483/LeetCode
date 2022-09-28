class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    max = Math.max(max, dfs(grid, vis, i, j));
                }
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid, boolean[][] vis, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] || grid[r][c] == 0)
            return 0;
        vis[r][c] = true;
        return 1 +
            dfs(grid, vis, r+1, c) +
            dfs(grid, vis, r-1, c) +
            dfs(grid, vis, r, c+1) +
            dfs(grid, vis, r, c-1);
            
    }
}