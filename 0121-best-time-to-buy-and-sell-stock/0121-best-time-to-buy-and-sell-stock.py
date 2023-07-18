class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        curr_max = 0
        for i in range(len(prices)-1, -1, -1):
            curr_max = max(curr_max, prices[i])
            res = max(res, curr_max - prices[i])
        return res
            
            
        