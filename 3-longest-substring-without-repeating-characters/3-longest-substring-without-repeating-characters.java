class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int i=0, j=0;
        int n = s.length();
        int ans = 0;
        while(j< n){
            char ch = s.charAt(j);
            int c= m.getOrDefault(ch, 0);
            m.put(ch, c+1);
            while(i <= j && m.size() < j-i+1){
                c = m.get(s.charAt(i));
                if(c == 1)
                    m.remove(s.charAt(i));
                else
                    m.put(s.charAt(i), c-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}