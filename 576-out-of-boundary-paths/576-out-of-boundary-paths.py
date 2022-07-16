class Solution:
    
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        @lru_cache(None)
        def dp(maxMove, r, c):
            if r < 0 or r >= m or c < 0 or c >= n:
                return 1
            if maxMove == 0:
                return 0
            return dp(maxMove-1, r+1, c) + dp(maxMove-1, r-1, c) + dp(maxMove-1, r, c+1) + dp(maxMove-1, r, c-1)
        return dp(maxMove, startRow, startColumn) % ( 10**9 + 7)
        

            
        