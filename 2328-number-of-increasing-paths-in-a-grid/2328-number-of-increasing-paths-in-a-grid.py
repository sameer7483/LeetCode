class Solution:
    def countPaths(self, grid: List[List[int]]) -> int:
        m, n, mod = len(grid), len(grid[0]), 10**9 +7
        @lru_cache(None)
        def count(r, c):
            res = 1
            for x, y in [[r, c+1], [r, c-1], [r+1, c], [r-1, c] ]:
                if 0 <= x < m and 0 <= y < n and grid[x][y] > grid[r][c]:
                    res += count(x, y)
            return res
        res = 0
        for i in range(m):
            for j in range(n):
                    res += count(i,j)
        return res%(10**9+7)
            
        