class Solution {

    public int minDistance(String word1, String word2) {
       return dpUtil(word1, word2);
    }
    
    public int dpUtil(String w1, String w2){
        int m = w1.length();
        int n = w2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][0] = i;
            
        }
        for(int i=1;i<=n;i++) {
            dp[0][i] = i;
        }
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(w1.charAt(i-1) != w2.charAt(j-1)){
                    dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
                else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
            
        
    }
    
    public int util(String w1, int m, String w2, int n){
        if(m==0)
            return n;
        if(n==0)
            return m;
        if(w1.charAt(m-1) != w2.charAt(n-1)){
            // Insert
            int ins = 1+util(w1, m, w2, n-1);
            // Delete
            int del = 1+util(w1, m-1, w2, n);
            //replace
            int rep = 1+util(w1, m-1, w2, n-1);
            return Math.min(ins, Math.min(del, rep));
        }
        else{
           return util(w1, m-1, w2, n-1);
        }
    }

}