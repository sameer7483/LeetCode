class Pair{
    String s;
    int count;
    public Pair(String s, int count){
        this.s = s;
        this.count = count;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.count != b.count)
                    return a.count - b.count;
                else
                    return b.s.compareTo(a.s);
            }
        });
        int n = words.length;
        for(int i=0;i<n;i++){
            int count = m.getOrDefault(words[i], 0);
            m.put(words[i], count+1);
        }
        
        for(Map.Entry<String, Integer> entry : m.entrySet()){
            if(q.size() < k)
                q.add(new Pair(entry.getKey(), entry.getValue()));
            else{
                if(entry.getValue() > q.peek().count){
                    q.poll();
                    q.add(new Pair(entry.getKey(), entry.getValue()));
                }
                else if(entry.getValue() == q.peek().count && entry.getKey().compareTo(q.peek().s) < 0){
                    q.poll();
                    q.add(new Pair(entry.getKey(), entry.getValue()));                
                }
            }
        }
        
        List<Pair> l = new ArrayList<>();
        while(!q.isEmpty()){
            l.add(q.poll());
        }
        Collections.sort(l, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.count != b.count)
                    return  b.count - a.count;
                else
                    return a.s.compareTo(b.s);
            }
        });
        List<String> ans = new ArrayList<>();
        for(int i=0;i<l.size();i++){
            ans.add(l.get(i).s);
        }
        return ans;
        
    }
}