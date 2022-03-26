class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int j= 0;
        int i=0;
        int n = s.length();
        int res = 0;
        while(j< n){
            int c = m.getOrDefault(s.charAt(j), 0);
            m.put(s.charAt(j), c+1);
            while(i<=j && m.size() < j-i+1){
                c = m.get(s.charAt(i));
                if(c==1)
                    m.remove(s.charAt(i));
                else
                    m.put(s.charAt(i), c-1);
                i++;
            }
            res = Math.max(res, j-i+1); 
            j++;
        }
        return res;
    }
}