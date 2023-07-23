class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            Arrays.fill(dp[i], -1);
        int res = util(coins, 0, amount);
        return res >= Integer.MAX_VALUE/2 ? -1 : res;
    }
    
    public int util(int[] coins, int curr, int amount){
        if(amount <= 0)
            return 0;
        if(curr >= coins.length)
            return Integer.MAX_VALUE/2;
        if(dp[curr][amount] != -1)
            return dp[curr][amount];
        if(amount >= coins[curr]){
             return dp[curr][amount] = Math.min(1+util(coins, curr, amount-coins[curr]), util(coins, curr+1, amount));
        }
        else{
            return dp[curr][amount] = util(coins, curr+1, amount);
        }
    }
}