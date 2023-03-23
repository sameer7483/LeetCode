class Solution {
    int[] parent;
    int island = 0;
    public int find(int c){
        if(parent[c] != c){
            parent[c] = find(parent[c]);
        }
        return parent[c];
    }
    public void union(int c1, int c2){
        int p1 = find(c1);
        int p2 = find(c2);
        if(p1 != p2){
            parent[p1] = p2;
            island--;
        }
    }
    public int makeConnected(int n, int[][] conn) {
        if(conn.length < n-1)
            return -1;
        island = n;
        parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        for(int i=0;i<conn.length;i++){
            union(conn[i][0], conn[i][1]);
        }
        return island-1;
    }
}