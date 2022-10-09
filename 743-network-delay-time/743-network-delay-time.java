class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
        int e = times.length;
        for(int i=0;i<e;i++){
            if(!adj.containsKey(times[i][0])){
                adj.put(times[i][0], new ArrayList<>());
            }
            adj.get(times[i][0]).add(new Pair<>(times[i][1], times[i][2]));
        }
        int res = util(adj, k, n);
        return res;
    }
    
    public int util(Map<Integer, List<Pair<Integer, Integer>>> adj, int u, int n){
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b)->a.getValue() - b.getValue());
        q.add(new Pair(u, 0));
        int t = 0;
        Set<Integer> vis = new HashSet<>();
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            vis.add(p.getKey());
            t = p.getValue();
            for(Pair<Integer, Integer> v : adj.getOrDefault(p.getKey(), new ArrayList<>())){
                if(!vis.contains(v.getKey())){
                    q.add(new Pair(v.getKey(), p.getValue()+v.getValue()));
                }
            }
        if(vis.size() == n){
                return t;
            }
        }

        return -1;
    }
    
}