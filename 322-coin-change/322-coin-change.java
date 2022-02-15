class Solution {
    long[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new long[coins.length+1][amount+1];
        //dp[i][j]= min coin needed to make j amount using first i coins.
        int n = coins.length;
        Arrays.fill(dp[0], Long.MAX_VALUE/2);
        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j >= coins[i-1]){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            
        }
        
        if(dp[n][amount] >= Integer.MAX_VALUE)
            return -1;
        return (int)dp[n][amount];
    }
}