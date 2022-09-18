class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m  = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] != '.' && !isSafe(board, i, j))
                    return false;
            }
        }
        return true;
    }
    
    public boolean isSafe(char[][] board, int r, int c){
        Set<Character> s = new HashSet<>();
        int m  = board.length;
        int n = board[0].length;
        for(int i=0;i<n;i++){
            if(board[r][i] != '.' && s.contains(board[r][i]))
                return false;
            s.add(board[r][i]);
        }
        s.clear();
        for(int i=0;i<m;i++){
            if(board[i][c] != '.' && s.contains(board[i][c]))
                return false;
            s.add(board[i][c]);
        }  
        s.clear();
        int x = (r/3)*3;
        int y = (c/3)*3;
        for(int i= x;i<x+3;i++){
            for(int j = y;j<y+3;j++){
                if(board[i][j] != '.' && s.contains(board[i][j]))
                    return false;
                s.add(board[i][j]);
            }
        }
        return true;
    }
}