class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        int max = 0;
        for(int i=n-1;i>=0;i--){
            max = Math.max(prices[i], max);
            res = Math.max(res, max-prices[i]);
        }
        return res;
    }
}