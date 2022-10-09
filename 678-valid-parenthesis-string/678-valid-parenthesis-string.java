class Solution {
    Boolean[][] dp;
    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length()];
        return util(s, 0, 0);
    }
    
    public boolean util(String s,int start, int leftP){
        if(leftP < 0)
            return false;
        if(start == s.length() && leftP != 0)
            return false;        
        if(start == s.length() && leftP == 0)
            return true;
        if(dp[start][leftP] != null)
            return dp[start][leftP];
        if(s.charAt(start) == '('){
            return dp[start][leftP] = util(s, start+1, leftP+1);
        }
        else if(s.charAt(start) == ')'){
            return dp[start][leftP]=util(s, start+1, leftP-1);
        }
        else{
            return dp[start][leftP]= util(s, start+1, leftP-1)||util(s, start+1, leftP+1)||util(s, start+1, leftP);
        }
    }
}