class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0;i<t.length();i++){
            m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0)+1);
        }
        int i = 0, j=0;
        int count = m.size();
        String res = s;
        boolean found = false;
        while(j < s.length()){
            if(m.containsKey(s.charAt(j))){
                m.put(s.charAt(j), m.get(s.charAt(j))-1);
                if(m.get(s.charAt(j))==0)
                    count--;
            }
            while(count <=0 && i <= j){
                if(m.containsKey(s.charAt(i))){
                    if(j-i+1 <= res.length()){
                        res = s.substring(i, j+1);
                        found = true;
                    }
                    m.put(s.charAt(i), m.get(s.charAt(i))+1);
                    if(m.get(s.charAt(i))==1)
                        count++;
                }  
                i++;
            }
            j++;
        }
        return found == true ? res : "";
    }
}