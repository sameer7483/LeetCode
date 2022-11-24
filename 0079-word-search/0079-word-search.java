class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board, i, j, 0, word, new boolean[m][n])){
                    return true;
                }
                    
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int r, int c, int i, String word, boolean vis[][]){
        if(i==word.length())
            return true;
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(i) || vis[r][c])
            return false;
        vis[r][c] = true;
        boolean up = dfs(board, r-1, c, i+1, word, vis);
        boolean dn = dfs(board, r+1, c, i+1, word, vis);
        boolean le = dfs(board, r, c-1, i+1, word, vis);
        boolean ri = dfs(board, r, c+1, i+1, word, vis);
        vis[r][c] = false;
        return up||dn||le||ri;
    }
}