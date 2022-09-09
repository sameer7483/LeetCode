class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int k=0;k<s.length();k++){
            int i = k, j = k;
            while(i >= 0 && j<s.length()){
                if(s.charAt(i) != s.charAt(j))
                    break;
                i--;
                j++;
                count++;
            }
            i = k;
            j = k+1;
            while(i >= 0 && j< s.length()){
                if(s.charAt(i) != s.charAt(j))
                    break;
                i--;
                j++;
                count++;                
            }
            
        }
        return count;
    }
    
}