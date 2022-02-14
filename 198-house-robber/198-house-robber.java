class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int result = dpUtil(nums);
        return result;
        

    }
    
    public int dpUtil(int[] nums){
        int n = nums.length;        
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0], nums[1]);
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
    
    public int robUtil(int[] nums, int n){
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robUtil(nums, n-2)+nums[n-1], robUtil(nums,n-1));
    }
    
    
    
    public int robUtilDp(int[] nums, int n){
        int[] t = new int[n+1];
        t[0] = 0;
        if(n>0)
        t[1] = nums[0];
        if(n>1)
        t[2] = Math.max(nums[0], nums[1]);
        for(int i=3;i<=n;i++){
            t[i] = Math.max(t[i-2] + nums[i-1], t[i-3] + nums[i-2]);
        }
        return t[n];
    }
}