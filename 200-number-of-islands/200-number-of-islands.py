class Solution:
    def dfs(self, grid:List[List[str]], visited:List[List[bool]], x, y):
        m = len(grid)
        n = len(grid[0])
        if x < 0 or x >= m or y < 0 or y >= n or visited[x][y] or grid[x][y]=='0':
            return
        visited[x][y] = True
        self.dfs(grid, visited, x-1, y)
        self.dfs(grid, visited, x+1, y)
        self.dfs(grid, visited, x, y-1)
        self.dfs(grid, visited, x, y+1)
        
    def numIslands(self, grid: List[List[str]]) -> int:
        m = len(grid)
        n = len(grid[0])        
        visited = [[False]*n for i in range(m)]
        res = 0
        for i in range(m):
            for j in range(n):
                if visited[i][j] == False and grid[i][j] == '1':
                    res +=1
                    self.dfs(grid, visited, i, j)
                
        return res        
        