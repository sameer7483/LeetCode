class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(beginWord))
            wordList.add(beginWord);
        int n = wordList.size();
        Map<String, List<String>> adj = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                    int count=0;
                    for(int k=0;k<wordList.get(i).length();k++){
                        if(wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) count++;
                        if(count > 1) break;
                    }
                    if(count ==1){
                        List<String> l1 = adj.getOrDefault(wordList.get(i), new ArrayList<>());
                        List<String> l2 = adj.getOrDefault(wordList.get(j), new ArrayList<>());
                        l1.add(wordList.get(j));
                        l2.add(wordList.get(i));
                        adj.put(wordList.get(i), l1);
                        adj.put(wordList.get(j), l2);
                    }  
            }
        }
        return bfs(adj, beginWord, endWord);
        
    }
    
    public int bfs(Map<String, List<String>> adj, String begin, String endWord){
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        q.add(begin);
        vis.add(begin);
        int level=0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0;i<size;i++){
                String p = q.poll();
                if(p.equals(endWord))
                    return level;
                for(String s : adj.getOrDefault(p, new ArrayList<>())){
                    if(!vis.contains(s)){
                        vis.add(s);
                        q.add(s);
                    }                    
                }

            }
        }
        return 0;
    }
}