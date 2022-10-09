class Solution {
    int[] parent;
    public int find(int c){
        if(parent[c] == c)
            return c;
        return find(parent[c]);
    }
    public int minCostConnectPoints(int[][] points) {
        //MST : Minimum Spanning Tree
        //Kruskal
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int n = points.length;
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                q.add(new int[]{Math.abs(points[i][1] - points[j][1]) + Math.abs(points[i][0] - points[j][0]), i, j});
            }
        }
        while(!q.isEmpty()){
            int[] p = q.poll();
            int p1 = find(p[1]);
            int p2 = find(p[2]);
            if(p1 != p2){
                res += p[0];
                parent[p1] = p2;
            }
        }
        return res;
    }
}