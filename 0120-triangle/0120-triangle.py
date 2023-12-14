class Solution:
    def minimumTotal(self, t: List[List[int]]) -> int:
        dp = [[-1]*len(t) for i in range(len(t))]
        def minTriangle(i, j):
            if i == len(t):
                return 0
            if dp[i][j] != -1:
                return dp[i][j]
            dp[i][j] = min(t[i][j]+minTriangle(i+1, j),t[i][j]+ minTriangle(i+1, j+1))
            return dp[i][j]
        
        return minTriangle(0, 0)
        