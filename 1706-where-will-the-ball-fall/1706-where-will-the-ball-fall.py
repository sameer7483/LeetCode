class Solution:
    def findBall(self, grid: List[List[int]]) -> List[int]:
        m = len(grid)
        n = len(grid[0])
        def dfs(r, c):
            if r >= m and 0 <= c < n:
                return c
            if r < 0 or r >= m or c < 0 or c >= n:
                return -1;
            if grid[r][c] == 1 and (c == n-1 or grid[r][c+1] == -1):
                return -1;
            if grid[r][c] == -1 and (c == 0 or grid[r][c-1] == 1):
                return -1
            if grid[r][c] == 1:
                return dfs(r+1, c+1)
            else:
                return dfs(r+1, c-1)
        res = []
        for i in range(n):
            res.append(dfs(0, i))
        return res
        