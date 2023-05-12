class Solution:
    def mostPoints(self, ques: List[List[int]]) -> int:
        n = len(ques)
        dp = [0]*(n+1)
        for i in range(n-1, -1, -1):
            if i+ques[i][1]+1 < n:
                dp[i] = max(ques[i][0]+dp[i+ques[i][1]+1], dp[i+1])
            else:
                dp[i] = max(ques[i][0], dp[i+1])
        return dp[0]
                
        