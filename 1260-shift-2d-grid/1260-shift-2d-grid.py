class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        m = len(grid)
        n = len(grid[0])
        res = [[0]*n for i in range(m)]
        for i in range(m):
            for j in range(n):
                x = (n*i +j +k)%(m*n)
                p = x//n
                q = x-n*p
                res[p][q] = grid[i][j]
        return res
                
                
                
        