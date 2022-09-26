class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return util(nums, nums.length,target);
    }
    
    
    public int util(int[] nums, int n, int target){
        if(n==0 && target ==0)
            return 1;
        if(n <= 0)
            return 0;
        return util(nums, n-1, target-nums[n-1]) + util(nums, n-1, target+nums[n-1]);
    }
}