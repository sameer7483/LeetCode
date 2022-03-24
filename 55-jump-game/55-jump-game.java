class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new Boolean[n];
        return util(nums, 0);
    }
    
    public boolean util(int[] nums, int start){
        if(start == nums.length-1)
            return true;
        if(dp[start] != null)
            return dp[start];
        for(int i=start+1;i<=start+nums[start];i++){
            if(util(nums, i))
                return dp[start]= true;
        }
        return dp[start] =false;
    }
}