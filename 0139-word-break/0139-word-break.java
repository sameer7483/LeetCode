class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        dp = new Boolean[s.length()];
        return util(s,0, set);
    }
    
    public boolean util(String s,int start, Set<String> set){
        if(start >= s.length())
            return true;
        boolean res = false;
        if(dp[start] != null)
            return dp[start];
        for(int i=start;i<s.length();i++){
            if(set.contains(s.substring(start, i+1))){
                res = res || util(s,i+1, set);
            }
        }
        return dp[start]=res;
    }
}