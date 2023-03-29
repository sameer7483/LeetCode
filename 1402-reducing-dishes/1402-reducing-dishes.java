class Solution {
    int[][] dp;
    public int maxSatisfaction(int[] sat) {
        Arrays.sort(sat);
        dp = new int[sat.length][sat.length+1];
        for(int i=0;i<sat.length;i++)
            Arrays.fill(dp[i], -1);
        return Math.max(0, util(sat, 0, 1));
    }
    
    public int util(int[] sat, int start, int time){
        if(start >= sat.length)
            return 0;
        if(dp[start][time] != -1)
            return dp[start][time];
        return dp[start][time] = Math.max(sat[start]*time+util(sat, start+1, time+1), util(sat, start+1, time));
    }
}