class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 && !vis[i][j] && util(grid, m, n, i, j, vis)){
                    res++;
                }
            }
        }
        return res;
    }
    
    public boolean util(int[][] grid,int m,int n, int r, int c, boolean[][] vis){
        if(r >= m || r < 0 || c >= n || c < 0)
            return false;
        if(grid[r][c] == 1)
            return true;
        if(vis[r][c])
            return true;
        vis[r][c] = true;
        boolean up = util(grid, m, n, r-1, c, vis);
        boolean dn = util(grid, m, n, r+1, c, vis);
        boolean lt = util(grid, m, n, r, c-1, vis);
        boolean rt = util(grid, m, n, r, c+1, vis);
        return up && dn && lt && rt;
    }
}