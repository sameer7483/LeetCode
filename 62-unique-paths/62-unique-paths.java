class Solution {
    
    public int uniquePaths(int m, int n) {
        //dp[m][n] = dp[m-1][n] + dp[m][n-1]
        int[] dp = new int[n];
        int prev = 1;
        dp[0] = 1;
        for(int i=0;i<m;i++){
            prev = 1;
            for(int j=1;j<n;j++){
                    dp[j] += prev;
                    prev = dp[j];
            }
        }
        return dp[n-1];
        
    }
      
}