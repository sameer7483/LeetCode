class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        dx = [-1, 1, -1, 1, -1, 1, 0, 0]
        dy = [-1, 1, 1, -1, 0, 0, -1, 1]
        for i in range(m):
            for j in range(n):
                live = 0
                dead = 0
                for k in range(8):
                    if (0 <= i+dx[k] < m) and (0 <= j+dy[k] < n):
                        if board[i+dx[k]][j+dy[k]] == 1 or board[i+dx[k]][j+dy[k]] == -1 :
                            live += 1
                if board[i][j] == 1:
                    if live < 2 or live > 3:
                        board[i][j] = -1
                elif board[i][j] == 0 and live == 3:
                    board[i][j] = 2
        for i in range(m):
            for j in range(n):
                if board[i][j] == -1:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
        
                        
                
        