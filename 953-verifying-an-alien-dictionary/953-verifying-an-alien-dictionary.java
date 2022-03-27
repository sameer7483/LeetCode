class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<order.length();i++)
            m.put(order.charAt(i), i);
        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int x=0;
            if(s1.startsWith(s2) && s1.length() > s2.length())
                return false;
            while(x < s1.length() && x < s2.length()){
                if(m.get(s1.charAt(x)) == m.get(s2.charAt(x)))
                    x++;
                else
                    break;
            }
            if(x!=s1.length() && x!=s2.length() && m.get(s1.charAt(x)) > m.get(s2.charAt(x)))
                return false;
        }
        return true;
    }
    
}