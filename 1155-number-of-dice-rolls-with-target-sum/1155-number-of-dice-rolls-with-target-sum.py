class Solution {
public:
    int numRollsToTarget(int d, int f, int target) {
        long long dp[32][1005]= {0};
        for(int i=0;i<=d;i++)
            dp[i][0] = 0;
        for(int i=0;i<=target;i++)
            dp[0][i] = 0;
        dp[0][0] = 1;
        int count = 0;
        int mod = (int)(1e9+7);

        for(int i=1;i<=d;i++){
            for(int k=1;k<=f;k++){
                for(int j=1;j<=target;j++){
                    if(j >= k)
                        dp[i][j] = (dp[i][j] + dp[i-1][j-k])%mod;
                }                            
                }

            }
        return (int) dp[d][target];         
    }
};