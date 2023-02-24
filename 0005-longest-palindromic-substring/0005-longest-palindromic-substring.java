class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0;i<s.length();i++){
            int lo = i;
            int hi = i;
            while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
                lo -= 1;
                hi += 1;
            }
            res = hi-lo -1 > res.length() ? s.substring(lo+1, hi) : res;
            lo = i;
            hi = i+1;
            while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
                lo -= 1;
                hi += 1;
            }  
            res = hi-lo -1 > res.length() ? s.substring(lo+1, hi) : res;
        }
        return res;
    }
}