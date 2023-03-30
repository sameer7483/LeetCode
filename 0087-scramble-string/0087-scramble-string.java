class Solution {
    Map<String, Boolean> dp;
    public boolean isScramble(String s1, String s2) {
        dp = new HashMap<>();
        return util(s1, s2);
    }
    
    public boolean util(String s1, String s2){
        
        if(s1.length() == 1)
            return s1.equals(s2);
        if(s1.equals(s2))
            return true;
        int n = s1.length();
        if(dp.containsKey(s1+"*"+s2))
            return dp.get(s1+"*"+s2);
        for(int i=1;i<s1.length();i++){
            if((util(s1.substring(0, i), s2.substring(0, i)) &&util(s1.substring(i), s2.substring(i))) ||
             (util(s1.substring(0, i), s2.substring(n-i))&&util(s1.substring(i), s2.substring(0,n-i)))){
                dp.put(s1+"*"+s2, true);
                return true;
            }
              
        }
        dp.put(s1+"*"+s2, false);
        return false;
    }
}