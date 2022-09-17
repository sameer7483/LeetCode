class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> m = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            m.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        for(int j = 0;j<words.length;j++){
            for(int i=0;i<=words[j].length();i++){
                String pre = words[j].substring(0, i);
                String suff = words[j].substring(i);
                if(isPalindrome(suff) && m.containsKey(pre) && m.get(pre) != j){
                    res.add(Arrays.asList(j, m.get(pre)));
                }                
                if(!pre.isEmpty() && isPalindrome(pre) && m.containsKey(suff) && m.get(suff) != j){
                        res.add(Arrays.asList(m.get(suff), j));
                }

            }
        }
        return res;
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i= s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    public boolean isPalindrome(String s){
        int i=0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}