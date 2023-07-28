class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int r, int c, boolean[][] vis){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || vis[r][c] || grid[r][c] == '0')
            return;
        vis[r][c] = true;
        dfs(grid, r+1, c, vis);
        dfs(grid, r-1, c, vis);
        dfs(grid, r, c+1, vis);
        dfs(grid, r, c-1, vis); 
    }
}