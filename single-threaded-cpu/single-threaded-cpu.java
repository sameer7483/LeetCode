class Pair{
    int idx;
    int start;
    int proc;
    public Pair(int idx, int start, int proc){
        this.idx = idx;
        this.start = start;
        this.proc = proc;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.proc != b.proc ? a.proc - b.proc : a.idx - b.idx);
        int n = tasks.length;
        int ans[] = new int[n];
        int index = 0;
        List<Pair> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new Pair(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(l, (a, b) -> a.start != b.start ?a.start - b.start : a.proc - b.proc);
        q.add(l.get(0));
        int j=1;
        long time = l.get(0).start;
        while(index < n){
            
            if(!q.isEmpty()){
                Pair p = q.poll();
                ans[index++] = p.idx;
                time += p.proc;
                while(j< n && time>= l.get(j).start){
                        q.add(l.get(j));
                        j++;  
                }
            }
            else{
                time=l.get(j).start;
                q.add(l.get(j));
                j++;
            } 
        }
            
        return ans;
    }
}