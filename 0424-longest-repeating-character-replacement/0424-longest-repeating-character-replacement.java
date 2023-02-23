class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(k >= n)
            return n;
        Map<Character, Integer> m = new HashMap<>();
        int max = 0;
        int j = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);
            max = Math.max(max, m.get(s.charAt(i)));
            while(j < n && max+k < i-j+1){
                m.put(s.charAt(j), m.get(s.charAt(j))-1);
                j++;
            }
            res = Math.max(res, i-j+1);
        }
        return res;
    }
}