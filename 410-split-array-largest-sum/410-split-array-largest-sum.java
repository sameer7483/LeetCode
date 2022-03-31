class Solution {
    int[][] dp;
    public int splitArray(int[] nums, int m) {
        dp = new int[nums.length+1][m+1];
        for(int i=0;i<=nums.length;i++)
            Arrays.fill(dp[i], -1);
        return util(nums, 0, m);
    }
    
    public int util(int[] nums, int start, int m){
        if(start == nums.length)
            return 0;
        long sum =0;
        if(dp[start][m] != -1)
            return dp[start][m];
        if(m==1){
            for(int i=start;i<nums.length;i++)
                sum += nums[i];
            return dp[start][m]= (int)sum;
        }
        long min = Integer.MAX_VALUE;
        for(int i=start;i<nums.length-1;i++){
            sum += nums[i];
            int val = util(nums, i+1, m-1);
            min = Math.min(min, Math.max(sum, val));
        }
        return dp[start][m]= (int)min;
    }
}