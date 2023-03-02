class Solution {
    public int maxProfit(int[] prices) {
        //ti0 = max(t[i-1][0], t[i-1][1]+prices[i])
        //ti1 = max(t[i-1][1], t[i-2][0]-prices[i])
        int n = prices.length;
        int[][] t= new int[n+1][2];
        t[0][0] = 0;
        t[0][1] = Integer.MIN_VALUE;
        t[1][0] = 0;
        t[1][1] = -prices[0];
        for(int i=2;i<=n;i++){
            t[i][0] = Math.max(t[i-1][0], t[i-1][1]+prices[i-1]);
            t[i][1] = Math.max(t[i-1][1], t[i-2][0]-prices[i-1]);
        }
        return t[n][0];
        
    }
}