class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        #dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        #dp[i][1] = max(dp[i-1][1], dp[i-1][0] -prices[i] - fee)
        
        n = len(prices)
        dpi_0 = 0
        dpi_1 = -1000000
        for i in range(1, n+1):
            temp = dpi_0
            dpi_0 = max(dpi_0, dpi_1 + prices[i-1])
            dpi_1 = max(dpi_1, temp - prices[i-1] - fee)
        return dpi_0
        