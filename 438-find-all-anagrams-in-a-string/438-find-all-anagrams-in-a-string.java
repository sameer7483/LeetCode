class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<p.length();i++){
            int count = m.getOrDefault(p.charAt(i), 0);
            m.put(p.charAt(i), count+1);
        }
        int k = p.length();
        int i=0, j=0, n = s.length();
        int count = m.size();
        List<Integer> res = new ArrayList<>();
        while(j<n){
            char ch = s.charAt(j);
            if(m.containsKey(ch)){
                m.put(ch, m.get(ch)-1);
                if(m.get(ch) ==0)
                    count -=1;                
            }
            if(j-i+1 < k){
                j++;
            }
            else{
                if(count ==0)
                    res.add(i);
                if(m.containsKey(s.charAt(i))){
                    m.put(s.charAt(i), m.get(s.charAt(i))+1);
                    if(m.get(s.charAt(i))==1)
                        count++;
                }  
                i++;
                j++;
            }
        }
        return res;
    }
}