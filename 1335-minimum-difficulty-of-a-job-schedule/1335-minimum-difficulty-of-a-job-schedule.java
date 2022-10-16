class Solution {
    int[][] dp;
    public int minDifficulty(int[] jd, int d) {
        if(d > jd.length)
            return -1;
        dp = new int[jd.length][d+1];
        for(int i=0;i<jd.length;i++)
            Arrays.fill(dp[i], -1);
        return util(jd, 0, d);
    }
    
    public int util(int[] jd,int start, int d){
        if(start >= jd.length && d==0)
            return 0;
        if(d <= 0 || start >= jd.length)
            return Integer.MAX_VALUE/2;
        if(dp[start][d] != -1)
            return dp[start][d];
        int sum = Integer.MAX_VALUE;
        int max = 0;
        for(int i=start;i<jd.length;i++){
            max = Math.max(max, jd[i]);
            sum = Math.min(sum, max + util(jd, i+1, d-1));
        }
        return dp[start][d] = sum;
    }
}