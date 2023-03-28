class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        Arrays.fill(dp, -1);
        return util(days, costs, 0);
    }
    
    public int util(int[] days, int[] costs, int curr){
        if(curr >=days.length)
            return 0;
        if(dp[curr] != -1)
            return dp[curr];
        int oneday = costs[0] + util(days, costs, curr+1);
        int sevday = costs[1] + util(days, costs, getNext(days, curr+1, days[curr]+7));
        int thirtyday = costs[2] + util(days, costs, getNext(days, curr+1, days[curr]+30));
        return dp[curr] = Math.min(oneday, Math.min(sevday, thirtyday));
    }
    
    public int getNext(int[] days,int lo, int key){
        int hi = days.length;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(days[mid] < key)
                lo = mid+1;
            else hi = mid;
        }
        return lo;
    }
}