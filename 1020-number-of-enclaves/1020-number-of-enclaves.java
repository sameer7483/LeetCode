class Solution {
    boolean dp[][];
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new boolean[m][n];
        int count = 0;
        int total = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0||i==m-1 || j==n-1) && grid[i][j]==1){
                    backtrack(grid, i, j, m, n);
                }

            }  
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    count++;

            }  
        }
        return count;
    }
    
    public void backtrack(int[][] grid, int r, int c, int m, int n){
        if((r > m-1 || r < 0 || c > n-1 || c<0)) return;
        if(grid[r][c] ==0) return;
        grid[r][c] = 0;
        backtrack(grid, r+1, c, m, n);
        backtrack(grid, r-1, c, m, n);
        backtrack(grid, r, c+1, m, n);
        backtrack(grid, r, c-1, m, n);
    }
}