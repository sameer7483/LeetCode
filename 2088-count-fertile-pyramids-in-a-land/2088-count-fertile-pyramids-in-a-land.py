class Solution:
    def countPyramids(self, g: List[List[int]]) -> int:
        m = len(g)
        n = len(g[0])
        res = 0
        @lru_cache(None)
        def dp(i, j, dr):
            if(g[i][j] == 1 and 0 <= i+dr < m and j>0 and j+1 < n and g[i+dr][j] ==1):
                return 1 + min(dp(i+dr, j-1, dr), dp(i+dr, j+1, dr))
            return g[i][j]
        
        for i, j in product(range(m), range(n)):
            res += max(0, dp(i, j, 1)-1)
            res += max(0, dp(i, j, -1)-1)
        return res
            
            
        
        