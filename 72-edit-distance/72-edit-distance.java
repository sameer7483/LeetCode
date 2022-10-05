class Solution {
    public int minDistance(String w1, String w2) {
        //w2[i] == w1[j]
        //dp[i][j] = dp[i-1][j-1]
        //else
        //dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
        
        int m = w2.length();
        int n = w1.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i] = i;
        for(int i=0;i<=m;i++)
            dp[i][0] = i;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(w2.charAt(i-1) == w1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
        
    }
}