class Solution {
    long[][] dp;
    public int coinChange(int[] coins, int amount) {
        //dp[i][j] = 1+dp[i][j-coins[i-1]], dp[i-1][j]
        dp = new long[coins.length+1][amount+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        int n = coins.length;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    dp[i][j] = Math.min(dp[i-1][j],1+dp[i][j-coins[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount] >= Integer.MAX_VALUE ? -1 : (int)dp[n][amount];
    }
    
    public long util(int[] coins, int amount, int n){
        if(n <= 0 || amount < 0)
            return Long.MAX_VALUE/2;
        if(amount == 0)
            return 0;
        if(dp[n][amount] != -1)
            return dp[n][amount];
        if(amount >= coins[n-1]){
            return dp[n][amount]= Math.min(util(coins, amount, n-1), 1+util(coins, amount-coins[n-1], n));
        }
        else 
            return dp[n][amount]=util(coins, amount, n-1); 
    }
}