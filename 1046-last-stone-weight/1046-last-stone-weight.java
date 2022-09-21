class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b-a);
        for(int i=0;i<stones.length;i++){
            q.add(stones[i]);
        }
        while(q.size() > 1){
            int y = q.poll();
            int x = q.poll();
            if(x == y) continue;
            q.add(y-x);
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}