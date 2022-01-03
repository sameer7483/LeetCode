class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int max = 0;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = values[0]+0;
        dp2[0] = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1], values[i]+i);
        }
        
        for(int i=1;i<n;i++){
            if(dp[i-1]+ values[i]-i > max)
                max = dp[i-1]+ values[i]-i ;
        }
        
        return max;
    }
}