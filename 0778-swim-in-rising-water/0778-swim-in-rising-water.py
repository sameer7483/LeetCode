class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        pq = []
        heapq.heappush(pq, (grid[0][0], 0 , 0))
        res = 0
        m = len(grid)
        n = len(grid[0])
        vis = [[False]*n for i in range(m)]
        dr = [0, 0, 1, -1]
        dc = [1, -1, 0, 0]
        while len(pq) > 0 :
            val, r, c = heapq.heappop(pq)
            res = max(res, val)
            if r == m-1 and c == n-1:
                return res
            vis[r][c] = True
            for i in range(len(dr)):
                if r+dr[i] >= 0 and r+dr[i]<m and c+dc[i] >=0 and c+dc[i] < n and not vis[r+dr[i]][c+dc[i]]:
                    heapq.heappush(pq, (grid[r+dr[i]][c+dc[i]], r+dr[i], c+dc[i]))
                    
        return 0
            
            
            
        
        