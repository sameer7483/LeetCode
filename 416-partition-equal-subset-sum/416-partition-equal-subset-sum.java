class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int n = nums.length;
        int target = sum/2;
        //dp[i][j] is can we get j using i element;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] =true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(j-nums[i-1] >=0)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][target];
    }
    
}