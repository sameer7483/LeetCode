class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] = text1[i] == text[j] ? 1 + dp[i-1][j-1] : Math.max(dp[i][j-1], dp[i-1][j]);
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = text1.charAt(i-1) == text2.charAt(j-1) ? 1+dp[i-1][j-1] : Math.max(dp[i-1][j], dp[i][j-1]); 
            }
        }
        return dp[m][n];
    }
}