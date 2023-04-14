class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        n = len(s)
        dp = [[0 for i in range(n+1)] for j in range(n+1)]
        for j in range(n):
            dp[1][j] = 1
        for i in range(2, n+1):
            for j in range(0, n-i+1):
                if s[j] == s[j+i-1]:
                    dp[i][j] = 2 + dp[i-2][j+1]
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j+1])
        return dp[n][0]
                    
        