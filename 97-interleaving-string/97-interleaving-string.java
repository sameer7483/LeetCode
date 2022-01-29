class Solution {
    Boolean dp[][];
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        dp = new Boolean[m+1][n+1];
        if(m+n != s3.length())
            return false;
        return util(s1, 0, s2, 0, s3);
        
    }
    
    public boolean util(String s1, int i, String s2, int j, String s3){
        if(i+j == s3.length())
            return true;
        if(dp[i][j] != null)
            return dp[i][j];
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            return dp[i][j]= util(s1, i+1, s2, j, s3) || util(s1, i, s2, j+1, s3);
        }
        else if( i < s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            return dp[i][j]= util(s1, i+1, s2, j, s3);
        }
        else if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            return dp[i][j]= util(s1, i, s2, j+1, s3);
        }
        else return dp[i][j]= false;
    }
}