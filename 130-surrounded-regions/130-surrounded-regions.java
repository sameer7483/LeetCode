class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            if(!vis[i][0])
                dfs(board, vis, i, 0);
            if(!vis[i][n-1])
                dfs(board, vis, i, n-1);
        }
        for(int j=0;j<n;j++){
            if(!vis[0][j])
                dfs(board, vis, 0, j);
            if(!vis[m-1][j])
                dfs(board, vis, m-1, j);
        } 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'N')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(char[][] board, boolean[][] vis, int r, int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || vis[r][c] || board[r][c] != 'O')
            return;
        vis[r][c] = true;
        board[r][c] = 'N';
        dfs(board, vis, r+1, c);
        dfs(board, vis, r-1, c);
        dfs(board, vis, r, c+1);
        dfs(board, vis, r, c-1);
    }
}