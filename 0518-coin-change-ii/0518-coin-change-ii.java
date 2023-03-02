class Solution {
    public int change(int amount, int[] coins) {
        //dp[i][j] += dp[i][j-coins[i-1]]
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++)
            dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j >= coins[i-1]){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][amount];
    }
    
    public int util(int[] coins, int curr, int amount){
        if(curr >= coins.length)
            return 0;
        if(amount == 0)
            return 1;
        int res = 0;
        for(int i=curr;i<coins.length;i++){
            if(amount >= coins[i])
                res += util(coins, i, amount-coins[i]);
        }
        return res;
        
    }
}