class Solution {
    public int maxProfit(int[] prices) {
        //t1[i][k] =max(t1[i-1][k],t0[i-2][k-1]-prices[i])
        //t0[i][k] = max(t0[i-1][k],t1[i-1][k]+prices[i])
        int t1ik = Integer.MIN_VALUE;
        int t0ik = 0;
        int t0ik2 = 0;
        for(int i=0;i<prices.length;i++){
            int temp = t0ik;
            t0ik = Math.max(t0ik, t1ik+prices[i]);
            t1ik = Math.max(t1ik, t0ik2 - prices[i]);
            t0ik2 = temp;
        }
        return t0ik;
    }

}