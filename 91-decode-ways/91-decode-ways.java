class Solution {
    Set<String> set;
    int[] dp;
    public int numDecodings(String s) {
        set = new HashSet<>();
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        for(int i=1;i<=26;i++)
            set.add(String.valueOf(i));
        return util(s, 0);
    }
    
    public int util(String s, int start){
        if(start >= s.length())
            return 1;
        if(dp[start] != -1)
            return dp[start];
        String one = s.substring(start, start+1);
        String two = "";
        if(start+2 <= s.length())
            two = s.substring(start, start+2);
        if(set.contains(one) && set.contains(two))
            return dp[start] = util(s, start+1) + util(s, start+2);
        else if(set.contains(one))
            return dp[start]= util(s, start+1);
        else
            return dp[start] = 0;
    }
    
}