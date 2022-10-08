class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i=0;i<s.length();i++)
            last[s.charAt(i)-'a'] = i;
        boolean[] curr = new boolean[26];
        List<Integer> res = new ArrayList<>();
        int prev = -1;
        for(int i=0;i<s.length();i++){
            if(!curr[s.charAt(i)-'a'])
                curr[s.charAt(i)-'a'] = true;
            if(last[s.charAt(i)-'a'] == i){
                curr[s.charAt(i)-'a'] = false;
                int j;
                for(j=0;j<26;j++){
                    if(curr[j])
                        break;
                }
                if(j == 26){
                    res.add(i-prev);
                    prev = i;
                }     
            }  
        }
        return res;
    }
    
}