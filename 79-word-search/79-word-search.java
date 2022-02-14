class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board, word, i, j, vis))
                    return true;
            }
        }
        return false;
        
    }
    
    public boolean dfs(char[][] board, String word, int r, int c, boolean[][] vis){
        int m = board.length;
        int n = board[0].length;
        if(word== null || word.isEmpty())
            return true;
        if(r < 0 || r >= m || c < 0 || c >=n || vis[r][c] || board[r][c] != word.charAt(0))
            return false;
        vis[r][c] = true;
        if(dfs(board, word.substring(1), r+1, c, vis)||
           dfs(board, word.substring(1), r-1, c, vis)||
           dfs(board, word.substring(1), r, c+1, vis)||
           dfs(board, word.substring(1), r, c-1, vis))
            return true;
        vis[r][c] = false;
        return false; 
    }
}