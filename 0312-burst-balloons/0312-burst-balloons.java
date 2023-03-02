class Solution {
    int[][] dp;
    public int util(int[] nums, int i, int j){
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int res = 0;
        for(int k=i;k<=j;k++){
            int left = util(nums, i, k-1);
            int right = util(nums, k+1, j);
            res = Math.max(res, left + right + (i == 0 ? 1 : nums[i-1]) * nums[k] * (j == nums.length-1 ? 1 : nums[j+1]));
        }
        return dp[i][j] = res;
    }
    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], -1);
        return util(nums, 0, nums.length-1);
    }
}