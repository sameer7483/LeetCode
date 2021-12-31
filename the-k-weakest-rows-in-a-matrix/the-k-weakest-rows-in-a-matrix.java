class Pair{
    public int idx;
    public int count;
    public Pair(int idx, int count){
        this.idx = idx;
        this.count = count;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.count != b.count)
                    return b.count - a.count;
                return b.idx - a.idx;
            }
        });
        int m = mat.length;
        int n = mat[0].length;
        Pair[] res = new Pair[k];
        for(int i=0;i<m;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j] ==1)
                    count++;
            }
            if(q.size() < k){
                q.add(new Pair(i, count));
            }
            else if(q.size() == k){
                if(count < q.peek().count){
                    q.poll();
                    q.add(new Pair(i, count));
                }
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            res[idx++] = q.poll();
        }
        Arrays.sort(res, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.count != b.count)
                    return a.count - b.count;
                return a.idx - b.idx;
            }
        });
        int[] ans = new int[k];
        int x=0;
        while(x<k){
            ans[x] = res[x++].idx;
        }
        return ans;
    }
}