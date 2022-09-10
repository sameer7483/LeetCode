class Solution {
    public int maxProfit(int k, int[] prices) {
       // t[i][k][0]= t[i-1][k][1]+prices[i], t[i-1][k][0]
       // t[i][k][1]=t[i-1][k-1][0]-prices[i], t[i-1][k][1]
        int n = prices.length;
        int[][][] t = new int[n+1][k+1][2];
        for(int i=0;i<=n;i++)
            t[i][0][0] = 0;
        for(int i=0;i<=k;i++)
            t[0][i][1] = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                t[i][j][0] = Math.max(t[i-1][j][1]+prices[i-1], t[i-1][j][0]);
                t[i][j][1] = Math.max(t[i-1][j-1][0]-prices[i-1], t[i-1][j][1]);
            }
        }
        return t[n][k][0];
        
    }
}