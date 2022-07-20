class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> m = new HashMap<>();
        for(int i=0;i<s.length();i++){
            m.put(s.charAt(i), new LinkedList<>());
        }
        for(int i=0;i<words.length;i++){
            if(m.containsKey(words[i].charAt(0))){
                m.get(words[i].charAt(0)).add(words[i]);
            }
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            Queue<String> q = m.get(s.charAt(i));
            int size = q.size();
            for(int j=0;j<size;j++){
                String p = q.poll();
                if(p.length()==1) count++;
                else{
                    if(m.containsKey(p.charAt(1))){
                        m.get(p.charAt(1)).add(p.substring(1));
                    }
                }
            }
        }
        return count;
        
    }
}