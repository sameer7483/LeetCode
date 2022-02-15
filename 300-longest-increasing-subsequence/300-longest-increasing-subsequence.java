class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        //dp[i] lis in first i
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}