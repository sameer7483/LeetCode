class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n+1][amount+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){          
                if(j >= coins[i-1]){
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                    
            }
        }
        return dp[n][amount] >= Integer.MAX_VALUE ? -1 : (int)dp[n][amount];
            
    }
}