class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        Set<String> dict = wordDict.stream().collect(Collectors.toSet());
        return util(s, 0, dict);
    }
    
    public boolean util(String s, int start, Set<String> dict){
        if(start == s.length())
            return true;
        if(dp[start] != null)
            return dp[start];
        for(int i=start;i<s.length();i++){
            if(dict.contains(s.substring(start, i+1))){
                if(util(s, i+1, dict))
                    return dp[start] = true;
            }
        }
        return dp[start]=false;
    }
}