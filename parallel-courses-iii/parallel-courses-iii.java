class Solution {
    int dp[];
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] ans = new int[n+1];
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0;i<relations.length;i++){
            List<Integer> l = adj.getOrDefault(relations[i][1], new ArrayList<>());
            l.add(relations[i][0]);
            adj.put(relations[i][1], l);
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(ans[i] == 0){
                ans[i] = util(i, adj, time);
            }
            max = Math.max(max, ans[i]);
        }
        return max;
    }
    
    public int util(int start, Map<Integer, List<Integer>> adj, int[] time){
        int max = 0;
        if(dp[start] != -1)
            return dp[start];
        for(Integer c : adj.getOrDefault(start, new ArrayList<>())){
            max = Math.max(max, util(c, adj, time));
        }
        return dp[start]=time[start-1]+max;
    }
}