class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j= s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                break;
            i++;
            j--;
        }
        if(i==j)
            return true;
        return isValid(s, i, j-1) || isValid(s, i+1, j);

    }
    
    public boolean isValid(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}