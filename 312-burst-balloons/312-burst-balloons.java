class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length; 
        dp = new int[n+1][n+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        return util(nums, 0, n-1);
    }
    
    public int util(int[] nums, int i, int j){
        int n = nums.length;
        int res = 0;
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        for(int k=i;k<=j;k++){
            int sum = util(nums, i, k-1) + util(nums, k+1, j);
            int temp = (i-1 < 0 ? 1 : nums[i-1])*nums[k]*(j+1 >= n ? 1 : nums[j+1]);
            res = Math.max(res, sum+temp);
        }
        return dp[i][j] = res;
    }
}