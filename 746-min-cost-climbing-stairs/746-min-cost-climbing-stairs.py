class Solution:
    def __init__(self):
        self.dp = dict()
    def helper(self, cost, i):
        if i >= len(cost):
            return 0
        if i in self.dp:
            return self.dp[i]
        self.dp[i]=cost[i] + min(self.helper(cost, i+1), self.helper(cost, i+2))
        return self.dp[i]
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        return min(self.helper(cost, 0), self.helper(cost, 1))
        
        