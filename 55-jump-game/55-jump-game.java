class Solution {
    public boolean canJump(int[] nums) {
        //dp[i] = if can reach i
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                dp[i] = dp[i]||(dp[j] && (i-j) <= nums[j]);
            }
        }
        return dp[n-1];
    }
}