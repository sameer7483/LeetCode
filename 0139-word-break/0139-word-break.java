class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] = dp[j] && s.substring(j, i) in wordDict
        Set<String> dict = new HashSet<>();
        for(String word: wordDict)
            dict.add(word);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=0;j--)
                dp[i] = dp[i] || (dp[j] && dict.contains(s.substring(j, i)));
        }
        return dp[n];
    }
}