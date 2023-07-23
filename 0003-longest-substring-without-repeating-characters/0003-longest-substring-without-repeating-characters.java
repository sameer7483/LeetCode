class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int i=0;
        int res = 0;
        for(int j = 0; j < s.length();j++){
            m.put(s.charAt(j), m.getOrDefault(s.charAt(j), 0)+1);
            while(i < j && j-i+1 > m.size()){
                m.put(s.charAt(i), m.get(s.charAt(i)) -1);
                if(m.get(s.charAt(i)) == 0)
                    m.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}