class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            int count = m1.getOrDefault(s1.charAt(i), 0);
            m1.put(s1.charAt(i), count+1);
        }
        Map<Character, Integer> m2 = new HashMap<>();
        int i=0, j=0;
        int k = s1.length();
        int n = s2.length();
        while(j<n){
            int count = m2.getOrDefault(s2.charAt(j), 0);
            m2.put(s2.charAt(j), count+1);            
            if(j-i+1 < k){
                j++;
            }
            else if(j-i+1 == k){
                if(m1.equals(m2))
                    return true;
                int c = m2.get(s2.charAt(i));
                if(c == 1)
                    m2.remove(s2.charAt(i));
                else
                    m2.put(s2.charAt(i), c-1);
                i++;
                j++;
            }
        }
        return false;
    }
}