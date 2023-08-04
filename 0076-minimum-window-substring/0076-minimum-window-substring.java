class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<t.length();i++){
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0)+1);
        }
        int count = 0;
        int[] charcount = new int[128];
        int j = 0;
        int i = 0;
        String res = s;
        boolean found = false;
        while(j < s.length()){
            charcount[s.charAt(j)-'A'] += 1;
            if(m.containsKey(s.charAt(j)) && m.get(s.charAt(j)) == charcount[s.charAt(j)-'A'])
                count += 1;
            while(i <= j && count == m.size()){
                res = j-i+1 < res.length() ? s.substring(i, j+1) : res;
                found = true;
                charcount[s.charAt(i)-'A'] -= 1;
                if(charcount[s.charAt(i)-'A'] < m.getOrDefault(s.charAt(i), 0))
                    count -= 1;
                i++;  
            }
            j++;
        }
        return found ? res : "";
    }
}