class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    
    public int util(String s1, String s2, int m, int n){
        if(m==0 || n==0)
            return 0;
        if(dp[m][n] != -1)
            return dp[m][n];
        int result = 0;
        if(s1.charAt(m-1)  == s2.charAt(n-1)){
            result =  1+ util(s1, s2, m-1, n-1);
        }
        else{
            result = Math.max(util(s1, s2, m-1, n), util(s1, s2, m, n-1));
        }
        dp[m][n] = result;
        return dp[m][n];
    }
}