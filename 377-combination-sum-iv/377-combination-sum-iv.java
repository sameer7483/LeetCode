class Solution {
    
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        Arrays.sort(nums);
        for(int j=1;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j >= nums[i]){
                    dp[j] += dp[j-nums[i]];
                }
                
            }
        }
        return dp[target];
    }
}