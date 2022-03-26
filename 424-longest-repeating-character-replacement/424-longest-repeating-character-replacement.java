class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int count[] = new int[26];
        int i=0;
        int maxCount = 0;
        int res = 0;
        for(int j=0;j<n;j++){
            maxCount = Math.max(maxCount, ++count[s.charAt(j)-'A']);
            while(i<= j && j-i+1 - maxCount > k){
                count[s.charAt(i)-'A']--;
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}