class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int miss = 0;
                for(int pos = 0;pos+i < m && pos+j < n;pos++){
                    if(s.charAt(i+pos) != t.charAt(j+pos) && ++miss > 1)
                        break;
                    res += miss;  
                }
            }
        }
        return res;
    }
}