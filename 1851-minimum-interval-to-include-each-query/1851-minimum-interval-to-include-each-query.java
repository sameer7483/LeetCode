class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int[][] queriesWithIdx = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            queriesWithIdx[i][0] = queries[i];
            queriesWithIdx[i][1] = i;            
        }
        Arrays.sort(queriesWithIdx, (a, b)->a[0]-b[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(a[1]-a[0]) - (b[1]-b[0]));
        int j=0;
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int qVal = queriesWithIdx[i][0];
            int qIdx = queriesWithIdx[i][1];
            while(j < intervals.length && qVal >= intervals[j][0])
                q.add(intervals[j++]);
            while(!q.isEmpty() && q.peek()[1] < qVal)
                q.poll();
            res[qIdx] = q.isEmpty() ? -1 : q.peek()[1]-q.peek()[0]+1;  
        }
        return res;
    }
}