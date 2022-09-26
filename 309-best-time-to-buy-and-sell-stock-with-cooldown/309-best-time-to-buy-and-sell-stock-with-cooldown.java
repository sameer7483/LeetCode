class Solution {
    public int maxProfit(int[] prices) {
//        t1[i] = t0[i-2]-prices[i], t1[i-1]
        //t0[i] = t0[i-1], t1[i-1] + prices[i]
        
        int t1i = Integer.MIN_VALUE/2;
        int t0i = 0;
        int lastSec = 0;
        int last = 0;
        for(int i=0;i< prices.length;i++){
            lastSec = last;
            last = t0i;
            t0i = Math.max(t0i, t1i+prices[i]);
            t1i = Math.max(lastSec-prices[i], t1i);
        }
        return Math.max(t1i, t0i);
    }
}