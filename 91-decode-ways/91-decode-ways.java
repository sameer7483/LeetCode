class Solution {
    Set<String> set;
    int[] dp;
    public int numDecodings(String s) {
        set = new HashSet<>();
        dp = new int[s.length()];
        Arrays.fill(dp, -1); 
        for(int i=1;i<=26;i++){
            set.add(String.valueOf(i));    
        }
        return util(s,0);
    }
    
    public int util(String s, int i){
        if(i >= s.length())
            return 1;
        if(dp[i] != -1)
            return dp[i];
        int first = 0;
        int second = 0;
        if(set.contains(s.substring(i,i+1))){
            first = util(s, i+1);
        }
        if(s.length()-i >= 2 && set.contains(s.substring(i,i+ 2))){
            second = util(s, i+2);
        }
        return dp[i] = first + second;
    }
    
    
}