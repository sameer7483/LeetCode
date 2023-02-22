class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[1]-b[1]);
        Map<Integer, Integer> m = new HashMap<>();
        for(int n:nums){
            int c = m.getOrDefault(n, 0);
            m.put(n, c+1);
        }
        for(Map.Entry<Integer, Integer> ent : m.entrySet()){
            q.add(new int[]{ent.getKey(), ent.getValue()});
            if(q.size()>k)
                q.poll();
        }
        int[] res = new int[k];
        int idx=0;
        while(!q.isEmpty()){
            res[idx] = q.poll()[0];
            idx++;
        }
        return res;
        
    }
}