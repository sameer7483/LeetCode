class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean [][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    res += 1;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return res;
    }
    
    public void dfs(char[][] grid, int r, int c, boolean[][] vis){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] || grid[r][c] == '0')
            return;
        vis[r][c] = true;
        dfs(grid, r-1, c, vis);
        dfs(grid, r+1, c, vis);
        dfs(grid, r, c-1, vis);
        dfs(grid, r, c+1, vis);
    }
}