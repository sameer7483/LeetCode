class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int res = 0;
        for(int i=n-1;i>=0;i--){
            max = Math.max(max, prices[i]);
            res = Math.max(res, max-prices[i]);
        }
        return res;
        
    }
}