class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        //dp[i][j] += dp[i-1][j-k]
        long[][] dp = new long[n+1][target+1];
        dp[0][0] = 1;
        int mod = (int)1e9 +7;
        for(int i=1;i<=n;i++){
            for(int f=1;f<=k;f++){
                for(int j=1;j<=target;j++){
                    if(j >= f)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-f])%mod;
                }
            }
        }
        return (int)dp[n][target];
    }
    
    public int util(int n, int f, int target){
        if(n < 0 || target < 0)
            return 0;
        if(n == 0 && target == 0)
            return 1;
        int res = 0;
        for(int i=1;i<=f;i++){
            res += util(n-1, f, target-i);
        }
        return res;
    }
}