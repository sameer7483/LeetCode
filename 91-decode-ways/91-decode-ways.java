class Solution {
    int[] dp;
    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        for(int i=1;i<=26;i++){
            set.add(String.valueOf(i));
        }
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return util(s, 0, set);
    }
    
    public int util(String s, int start, Set<String> set){
        if(start == s.length())
            return 1;
        if(dp[start] != -1)
            return dp[start];
        int res = 0;
        for(int i=start;i<s.length();i++){
            if(set.contains(s.substring(start, i+1))){
                res += util(s, i+1, set);
            }
        }
        return dp[start]= res;
    }
}  