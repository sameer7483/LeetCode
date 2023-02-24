class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            int lo = i;
            int hi = i;
            while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
                lo -= 1;
                hi += 1;
            }
            res += (hi-lo-1)/2 +1;
            lo = i;
            hi = i+1;
            while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
                lo -= 1;
                hi += 1;
            }  
            res += (hi-lo -1)/2;
        }
        return res;        
    }
}