class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> getDistance(b) - getDistance(a));
        for(int point[] : points){
            pq.add(point);
            if(pq.size() > k)
                pq.poll();
        }
                     
        int[][] res = new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }           
                     
         return res;
    }
    
    private int getDistance(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}