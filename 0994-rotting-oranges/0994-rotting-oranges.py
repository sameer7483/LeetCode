class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        q = []
        total = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i, j))
                if grid[i][j] != 0:
                    total += 1
        minutes = 0
        dx = [0, 1, 0, -1]
        dy = [1, 0, -1, 0]
        vis = set()
        while(len(q) > 0):
            size = len(q)
            for i in range(size):
                x, y = q.pop(0)
                vis.add((x, y))
                for k in range(len(dx)):
                    if 0<=x+dx[k]<m and 0<=y+dy[k]<n and (x+dx[k], y+dy[k]) not in vis and grid[x+dx[k]][y+dy[k]] == 1:
                        q.append((x+dx[k], y+dy[k]))
                        grid[x+dx[k]][y+dy[k]] = 2
            if len(q) > 0 :
                minutes += 1
        return -1 if len(vis) != total else minutes
        
                        
                    
                
                
        