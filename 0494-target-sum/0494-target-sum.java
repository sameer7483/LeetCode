class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return util(nums, 0, target);
    }
    
    public int util(int[] nums, int curr, int target){
        if(target == 0 && curr == nums.length){
            return 1;
        }
        if(curr == nums.length)
            return 0;
        return util(nums, curr+1, target-nums[curr]) + util(nums, curr+1, target+nums[curr]);
    }
}