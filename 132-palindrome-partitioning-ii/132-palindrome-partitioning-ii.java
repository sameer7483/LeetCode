class Solution {
    int dp[];
    public int minCut(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return util(s, 0);
    }
    
    public int util(String s, int start){
        if(start == s.length()-1)
            return 0;
        if(dp[start]!=-1)
            return dp[start];
        if(isPalindrome(s, start, s.length()))
            return 0;
        int min = s.length()-1;
        for(int i=start+1;i<s.length();i++){
            if(isPalindrome(s, start, i)){
                min = Math.min(min, 1+util(s, i));
            }
        }
        return dp[start]= min;
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i<j-1){
            if(s.charAt(i) != s.charAt(j-1))
                return false;
            i++;
            j--;
        }
        return true;
    }
}