class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dp = new Boolean[s.length()+1];
        for(String str : wordDict)
            dict.add(str);
        return util(s, 0, dict);
        
    }
    public boolean util(String s, int curr, Set<String> dict){
        if(curr == s.length())
            return true;
        if(dp[curr] != null)
            return dp[curr];
        boolean res = false;
        for(int i=curr;i<s.length();i++){
            if(dict.contains(s.substring(curr, i+1)))
                res = res || util(s, i+1, dict);
        }
        return dp[curr] = res;
    }
}