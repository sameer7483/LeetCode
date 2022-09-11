class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int x, int y, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y]=='0')
            return;
        visited[x][y] = true;
        dfs(grid, x+1, y, visited);
        dfs(grid, x-1, y, visited);
        dfs(grid, x, y+1, visited);
        dfs(grid, x, y-1, visited);
    }
}