class Solution {
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        int[][] ess = new int[n][2];
        for(int i=0;i<n;i++){
            ess[i] = new int[]{eff[i], speed[i]};
        }
        Arrays.sort(ess, (a, b)->b[0]-a[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long sum = 0;
        long res = 0;
        for(int[] e : ess){
            sum += e[1];
            q.add(e[1]);
            if(q.size() > k)
                sum -= q.poll();
            res = Math.max(res, sum*e[0]); 
        }
        return (int)(res % (1000000007));
        
    }
   
    //brute force 2^n
    public int util(int n, int[] speed, int[] eff, int k, long sum, int min, int start){
        if(k==0 || start == n){
            return ((int)(sum%1000000007) * min) % 1000000007;
        }
        int res = 0;
        for(int i=start; i<n;i++){
            //take
            int take = util(n,speed, eff, k-1, sum + speed[i], Math.min(min, eff[i]), i+1);
            int nottaken = util(n,speed, eff, k, sum, min, i+1);
            res = Math.max(res, Math.max(take, nottaken));
        }
        return res;
    }
}