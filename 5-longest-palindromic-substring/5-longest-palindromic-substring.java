class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String res = "";
        
        for(int k=0;k<n;k++){
            int i=k, j= k;
            while(i >= 0 && j < n){
                if(s.charAt(i) != s.charAt(j))
                    break;
                i--;
                j++;
            }
            if(j-i-1 > max){
                max = j-i-1;
                res = s.substring(i+1, j);
            }
            i = k;
            j = k+1;
            while(i >= 0 && j < n){
                if(s.charAt(i) != s.charAt(j))
                    break;
                i--;
                j++;
            }
            if(j-i-1 > max){
                max = j-i-1;
                res = s.substring(i+1, j);
            }            
        }
        return res;
    }
    
}