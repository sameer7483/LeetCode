class Solution {
    int dp[][];
    public int change(int target, int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(j >= nums[i-1]){
                    dp[i][j] = dp[i][j-nums[i-1]] + dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][target];        
        // int n = coins.length;
        // dp = new int[n+1][amount+1];
        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return util(coins, n, amount);
    }
    
    public int util(int[] coins, int n , int amount){
        if(amount ==0)
            return 1;
        if(n==0)
            return 0;
        int result =0;
        if(dp[n][amount] != -1)
            return dp[n][amount];
        if(coins[n-1] <= amount){
            result = util(coins, n-1, amount) + util(coins, n, amount-coins[n-1]);
        }
        else{
            result = util(coins, n-1, amount);
        }
        dp[n][amount] = result;
        return result;
    }
}