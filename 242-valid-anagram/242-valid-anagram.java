class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int n = s.length();
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            
            if(count[i] != 0)
                return false;
        }
        return true;
    }
}