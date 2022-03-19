class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int i=0, j=0;
        int n = s.length();
        int max = 0;
        int ans = 0;
        while(j<n){
            max = Math.max(max,++count[s.charAt(j)-'A']);
            while(max+k < j-i+1){
                count[s.charAt(i)-'A']--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
        
    }
}