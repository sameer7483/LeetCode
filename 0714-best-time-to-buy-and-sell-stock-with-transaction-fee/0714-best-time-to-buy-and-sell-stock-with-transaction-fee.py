class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        @lru_cache(None)
        def profit(buy, curr):
            if curr == len(prices):
                return 0
            if buy:
                return max(-prices[curr]+profit(not buy, curr+1)-fee, profit(buy, curr+1))
            else:
                return max(prices[curr]+profit(not buy, curr+1), profit(buy, curr+1))
            
        return profit(True, 0)
        