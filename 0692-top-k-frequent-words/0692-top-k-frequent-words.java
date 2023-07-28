class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<>();
        for(String word : words){
            m.put(word, m.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>((a, b)->
                                                                    a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey().compareTo(a.getKey()) );
        for(Map.Entry<String, Integer> ent : m.entrySet()){
            q.add(new Pair(ent.getKey(), ent.getValue()));
            if(q.size() > k){
                q.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(0, q.poll().getKey());
        }
        return res;       
    }
}