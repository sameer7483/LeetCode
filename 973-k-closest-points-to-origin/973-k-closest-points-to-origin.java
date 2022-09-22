class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b)->b.getKey()-a.getKey());
        for(int i=0;i<points.length;i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            q.add(new Pair(dist, i));
            if(q.size() > k )
                q.poll();
        }
        int[][] res = new int[q.size()][2];
        int idx = 0;
        while(!q.isEmpty()){
            res[idx++] = points[q.poll().getValue()];
        }
        return res;
    }
}