class Solution:
    def appealSum(self, s: str) -> int:
        #dp[i] = dp[i-1] + (i - prev[s[i]])
        n = len(s)
        dp = [0]* (n+1)
        prev = {}
        res  = 0
        for i in range(1, len(s)+1):
            dp[i] = dp[i-1] + ((i-1-prev[s[i-1]]) if s[i-1] in prev else i)
            prev[s[i-1]] = i-1
            res += dp[i]
        return res
            
        