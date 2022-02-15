class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res="";
        for(int i=0;i<n;i++){
            //odd
            int l=i, r=i;
            while(l>=0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    res = r-l+1 > res.length() ? s.substring(l, r+1) : res;
                    l--;r++;
                }
                else break;
                
            }
            l=i; r=i+1;
            //even
            while(l>=0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    res = r-l+1 > res.length() ? s.substring(l, r+1) : res;
                    l--;r++;
                }
                else
                    break;
            }            
        }
        return res;
    }
}