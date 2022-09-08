class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        String res = "";
        for(int i=0;i<n && n-i > max;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s, i, j)){
                    if(j-i+1 > max){
                        res = s.substring(i, j+1);
                        max = j-i+1;
                    }
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}