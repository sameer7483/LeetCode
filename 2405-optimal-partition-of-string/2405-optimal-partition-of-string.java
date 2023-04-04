class Solution {
    Map<String, Integer> m;
    public int partitionString(String s) {
        int res = 1;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                res++;
                set = new HashSet<>();
                set.add(s.charAt(i));
                continue;
            }
            set.add(s.charAt(i));
        } 
        return res;
    }
    
    public int util(String s){
        int res = Integer.MAX_VALUE/2;
        if(s.length() == 0)
            return 0;
        if(m.containsKey(s))
            return m.get(s);
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                break;
            set.add(s.charAt(i));
            res = Math.min(res, 1+util(s.substring(i+1)));
        }
        m.put(s, res);
        return res;        
    }
    
}