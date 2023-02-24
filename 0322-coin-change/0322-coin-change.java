class Solution {
    long[][] dp;
    public int coinChange(int[] coins, int amount) {
        //dp[i][j] = 1+dp[i][j-coins[i-1]], dp[i-1][j]
        dp = new long[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            Arrays.fill(dp[i], -1);
        long res = util(coins, amount, coins.length);
        return res > Integer.MAX_VALUE ? -1 : (int)res;
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